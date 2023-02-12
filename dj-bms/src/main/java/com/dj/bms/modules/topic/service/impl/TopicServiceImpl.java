package com.dj.bms.modules.topic.service.impl;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.dto.TopicExecution;
import com.dj.bms.common.enums.InsertTopicEnum;
import com.dj.bms.common.exception.BaseException;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.common.util.StringUtils;
import com.dj.bms.modules.node.dto.NodeDTO;
import com.dj.bms.modules.node.service.NodeService;
import com.dj.bms.modules.sys.service.SystemConfigService;
import com.dj.bms.modules.tag.model.Tag;
import com.dj.bms.modules.topic.dao.TopicDao;
import com.dj.bms.modules.topic.dto.TopicDTO;
import com.dj.bms.modules.topic.enums.TopicErrorCodeEnum;
import com.dj.bms.modules.topic.exception.TopicException;
import com.dj.bms.modules.topic.model.Topic;
import com.dj.bms.modules.topic.service.TopicService;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

@Service
public class TopicServiceImpl extends AbstractBaseServiceImpl<Topic, TopicDTO> implements TopicService {

	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NodeService nodeService;
	
	@Autowired
	@Qualifier("systemConfigServiceImpl")
	private SystemConfigService systemConfigService;
	
	/**
	 * 根据节点和节点板块查询话题
	 */
	@Override
	public Page<Topic> pageByNodeAndNodeTab(Integer pageNumber, Integer pageSize, String nodeTab, String nodeTitle) {
		if(nodeTab.equals("all")) {
			return pageAllByNode(pageNumber,pageSize,nodeTitle);
		}else if(nodeTab.equals("good")) {
			return pageGood(pageNumber,pageSize,nodeTitle);
		}else if(nodeTab.equals("noReply")) {
			return pageNoReply(pageNumber,pageSize,nodeTitle);
		}else {
			return pageAllNewest(pageNumber,pageSize,nodeTitle);
		}
	}

	/**
	 * 根据板块查询所有话题
	 */
	@Override
	public Page<Topic> pageAllByTab(Integer pageNumber, Integer pageSize, String tab) {
		List<Topic> list = topicDao.selectAllByTab((pageNumber - 1) * pageSize, pageSize,tab);
		int total = topicDao.countTopicByTab(tab);
		return new Page<>(list, pageNumber, pageSize, total);
	}
	
	/**
	 * 根据节点查询所有话题
	 */
	@Override
	public Page<Topic> pageAllByNode(Integer pageNumber, Integer pageSize, String nodeTitle) {
		List<Topic> list = topicDao.selectAllByNode((pageNumber - 1) * pageSize, pageSize,nodeTitle);
		int total = topicDao.countTopicByNode(nodeTitle);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 根据节点查询精华话题
	 */
	@Override
	public Page<Topic> pageGood(Integer pageNumber, Integer pageSize,String nodeTitle) {
		List<Topic> list = topicDao.selectAllGood((pageNumber - 1) * pageSize, pageSize,nodeTitle);
		int total = topicDao.countTopicGoodByNode(nodeTitle);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 根据节点查询无人回复的话题
	 */
	@Override
	public Page<Topic> pageNoReply(Integer pageNumber, Integer pageSize,String nodeTitle) {
		List<Topic> list = topicDao.selectAllNoReply((pageNumber - 1) * pageSize, pageSize,nodeTitle);
		int total = topicDao.countTopicNoReplyByNode(nodeTitle);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 根据ID查询话题
	 */
	@Override
	public Topic findByTopicId(Integer topicId) {
		return topicDao.selectByTopicId(topicId);
	}

	/**
	 * 查询当前作者的其他话题
	 */
	@Override
	public List<Topic> findOtherTopicByAuthor(Integer currentTopicId, String author, Integer limit) {
		//return rootTopicDao.selectByAuthor(currentTopicId, author, 0, limit);
		return null;
	}

	/**
	 * 根据昵称分页查询用户的所有话题
	 */
	@Override
	public Page<Topic> pageByAuthor(Integer pageNumber, Integer pageSize, String author) {
		int totalRow = topicDao.countAllByName(author);
		List<Topic> list = topicDao.selectByAuthor(author, (pageNumber - 1) * pageSize, pageSize);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 查询所有话题
	 */
	@Override
	public List<Topic> findAll() {
		return topicDao.selectAll();
	}

	/**
	 * 根据ID删除话题
	 */
	@Override
	public void deleteByTopicId(Integer topicId) {
		topicDao.deleteById(topicId);
	}

	/**
	 * 根据作者删除话题
	 */
	@Override
	public void deleteByAuthor(String author) {
		topicDao.deleteByAuthor(author);
	}

	/**
	 * 置顶话题
	 */
	@Override
	public void topByTopicId(Integer topicId) {
		Topic topic = topicDao.selectByTopicId(topicId);
		if(topic != null) {
			topic.setTop(!topic.getTop());
			topicDao.updateByTopicId(topic);
		}
	}

	/**
	 * 话题加精
	 */
	@Override
	public void goodByTopicId(Integer topicId) {
		Topic topic = topicDao.selectByTopicId(topicId);
		if(topic != null) {
			topic.setGood(!topic.getGood());
			topicDao.updateByTopicId(topic);
		}
	}

	/**
	 * 发布话题
	 */
	@Override
	public TopicExecution saveTopic(Topic topic) {
		topicDao.insert(topic);
		// 发贴加积分
		//rootUserDao.updateScoreByName(Integer.valueOf(systemConfigService.getByKey("create_topic_score").getValue()), topic.getAuthor());
		return new TopicExecution(topic.getTitle(), InsertTopicEnum.SUCCESS, topic);
	}

	@Override
	public TopicExecution createTopic(String title, String content, String tab, String nodeCode, String nodeTitle, String tag, User user) {
		return null;
	}
	
	/*@Override
	public TopicExecution createTopic(String title, String content, String tab, String nodeCode,String nodeTitle, String tag,User user) {
		Topic topic = new Topic();
		topic.setPtab(null);
		topic.setTab(tab);
		topic.setTitle(title);
		topic.setTag(tag);
		topic.setContent(content);
		topic.setCreateDate(new Date());
		topic.setUpdateDate(new Date());
		topic.setLastReplyTime(null);
		topic.setLastReplyAuthor(null);
		topic.setViewCount(0);
		topic.setAuthor(user.getUserName());
		topic.setTop(false);
		topic.setGood(false);
		topic.setShowStatus(true);
		topic.setReplyCount(0);
		topic.setIsDelete(false);
		topic.setTagIsCount(true);
		topic.setPostGoodCount(null);
		topic.setPostBadCount(null);
		topic.setStatusCd("1000");
		topic.setNodeSlug(nodeCode);
		topic.setNodeTitle(nodeTitle);
		topic.setRemark(null);
		topic.setAvatar(user.getAvatar());//话题作者的头像
		topic.setUrl(null);
		TopicExecution saveTopic = saveTopic(topic);
		return saveTopic;
	}*/

	/**
	 * 更新话题
	 */
	@Override
	public void updateTopic(Topic topic) {
		topicDao.updateByTopicId(topic);
	}

	/**
	 * 收藏话题列表
	 */
	@Override
	public Page<Topic> findCollectsById(Integer pageNumber, Integer pageSize, Integer uid) {
		return null;
	}

	/**
	 * 查询用户发布主题的数量
	 */
	@Override
	public int countByUserName(String userName) {
		return topicDao.countAllByName(userName);
	}

	/**
	 * 根据节点查询最新话题
	 */
	@Override
	public Page<Topic> pageAllNewest(Integer pageNumber, Integer pageSize,String nodeTitle) {
		List<Topic> list = topicDao.selectAllNewest((pageNumber - 1) * pageSize, pageSize,nodeTitle);
		int total = topicDao.countTopicByNode(nodeTitle);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 热门话题
	 */
	@Override
	public List<Topic> findHot(Integer start, Integer limit) {
		return topicDao.selectHot(start, limit);
	}

	/**
	 * 分页查询所有标签
	 */
	@Override
	public Page<Tag> findByTag(Integer pageNumber, Integer pageSize) {
		int totalRow = topicDao.countTag();
		List<Tag> list = topicDao.selectAllTag((pageNumber - 1) * pageSize, pageSize);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 根据标签查询话题
	 */
	@Override
	public Page<Topic> pageByTag(String tag, Integer pageNumber, Integer pageSize) {
		int totalRow = topicDao.countByTag(tag);
		List<Topic> list = topicDao.selectByTag(tag, (pageNumber - 1) * pageSize, pageSize);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 更新主题作者的头像
	 */
	@Override
	public void updateTopicAvatar(User user) {
		topicDao.updateTopicAvatar(user);
	}

	/**
	 * 更新节点名称
	 */
	@Override
	public void updateNodeTitile(String oldNodeTitle, String newNodeTitle) {
		topicDao.updateNodeTitile(oldNodeTitle, newNodeTitle);
	}

	/**
	 * 统计所有话题
	 */
	@Override
	public int countAllTopic(String tab) {
		return topicDao.countTopicByTab(tab);
	}

	/**
	 * 分页模糊查询
	 */
	@Override
	public Page<Topic> pageLike(Integer pageNumber, Integer pageSize, String like) {
		List<Topic> list = topicDao.selectByLike(like, (pageNumber - 1) * pageSize, pageSize);
		int totalRow = topicDao.countLike(like);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 根据板块和昵称分页查询话题
	 */
	@Override
	public Page<Topic> pageAllByPtabAndAuthor(Integer pageNumber, Integer pageSize, String ptab, String author) {
		int totalRow = topicDao.countAllByNameAndPtab(author, ptab);
		List<Topic> list = topicDao.selectAllByPtabAndAuthor((pageNumber - 1) * pageSize, pageSize, ptab, author);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 首页-最热话题
	 */
	@Override
	public Page<Topic> findIndexHot(Integer pageNumber, Integer pageSize, String tab) {
		int totalRow = topicDao.countIndexHot(tab);
		List<Topic> list = topicDao.selectIndexHot((pageNumber - 1) * pageSize, pageSize, tab);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 侧边栏-今日等待回复的话题
	 */
	@Override
	public List<Topic> findTodayNoReply(Integer start, Integer limit) {
		return topicDao.selectTodayNoReply(start, limit);
	}

	/**
	 * 作者的其他话题
	 */
	@Override
	public List<Topic> findOther(String userName, Integer topicId) {
		return topicDao.selectOther(userName, topicId);
	}

	/**
	 * 根据节点统计所有话题
	 */
	@Override
	public int countTopicByNode(String nodeTitle) {
		return topicDao.countTopicByNode(nodeTitle);
	}

	@Override
	public int countToday() {
		return topicDao.countToday();
	}

	@Override
	public Page<Topic> pageForAdmin(String author, String startDate, String endDate, Integer pageNumber,
			Integer pageSize) {
		List<Topic> list = topicDao.selectAllForAdmin(author, startDate, endDate, (pageNumber - 1) * pageSize, pageSize);
		int totalRow = countAllForAdmin(author, startDate, endDate);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	@Override
	public int countAllForAdmin(String author,String startDate,String endDate) {
		return topicDao.countAllForAdmin(author, startDate, endDate);
	}

	
	@Override
	public Topic findById(Integer id) {
		return topicDao.selectByTopicId(id);
	}
	
	@Override
	public boolean save(TopicDTO topicDTO) throws TopicException {
		String title = topicDTO.getTitle();
		if (StringUtils.isEmpty(title)) {
			throw new TopicException(TopicErrorCodeEnum.TITLE_MISSING);
		}
		String nodeId = topicDTO.getNodeDTO().getNodeId();
		if (StringUtils.isEmpty(nodeId)) {
			throw new TopicException(TopicErrorCodeEnum.NODE_ID_MISSING);
		}
		NodeDTO nodeDTO = nodeService.getById(nodeId);
		if (nodeDTO == null) {
			throw new TopicException(TopicErrorCodeEnum.INVALIDATE_NODE);
		}
		Integer userId = topicDTO.getUserDTO().getUserId();
		if (userId == null) {
			throw new TopicException(TopicErrorCodeEnum.USER_ID_MISSING);
		}
		UserDTO userDTO = userService.getById(userId);
		if (userDTO == null) {
			throw new TopicException(TopicErrorCodeEnum.INVALIDATE_USER);
		}
		topicDTO.setTop(false);
		topicDTO.setGood(false);
		topicDTO.setViewCount(0);
		topicDTO.setShareCount(0);
		topicDTO.setGoodCount(0);
		topicDTO.setBadCount(0);
		topicDTO.setCreateDate(new Date());
		topicDTO.setType(1000);
		topicDTO.setStatus(1000);
		return super.save(topicDTO);
	}
	
	@Override
	public Page<TopicDTO> pageByNode(Integer pageNumber, Integer pageSize, String nodeId, String tabName) throws BaseException {
		Page<TopicDTO> page = null;
		QueryWrapper<Topic> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("node_id", nodeId);
		queryWrapper.orderByDesc("create_date");
		switch (tabName) {
			case "good":
				queryWrapper.eq("good", "1");
				page = page(pageNumber, pageSize, queryWrapper);
				break;
			case "noReply":
				queryWrapper.eq("comment_count", "0");
				page = page(pageNumber, pageSize, queryWrapper);
				break;
			default:
				page = page(pageNumber, pageSize, queryWrapper);
				break;
		}
		return page;
	}

	@Override
	public Function<? super TopicDTO, ? extends Topic> getDTO2DOMapper() {
		return topicDTO -> {
			if (topicDTO != null) {
				Topic topic = new Topic();
				BeanUtils.DTO2DO(topicDTO, topic);
				return topic;
			}
			return null;
		};
	}

	@Override
	public Function<? super Topic, ? extends TopicDTO> getDO2DTOMapper() {
		return topic -> {
			if (topic != null) {
				TopicDTO topicDTO = new TopicDTO();
				BeanUtils.DO2DTO(topic, topicDTO);
				return topicDTO;
			}
			return null;
		};
	}

	@Override
	public BaseDao<Topic> getDao() {
		return topicDao;
	}

}
