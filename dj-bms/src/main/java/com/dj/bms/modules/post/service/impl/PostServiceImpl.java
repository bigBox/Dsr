package com.dj.bms.modules.post.service.impl;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.exception.BaseException;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.common.util.StringUtils;
import com.dj.bms.modules.node.dto.NodeDTO;
import com.dj.bms.modules.node.service.NodeService;
import com.dj.bms.modules.post.dao.PostDao;
import com.dj.bms.modules.post.dto.PostDTO;
import com.dj.bms.modules.post.enums.PostErrorCodeEnum;
import com.dj.bms.modules.post.exception.PostException;
import com.dj.bms.modules.post.model.Post;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.modules.sys.service.SystemConfigService;
import com.dj.bms.modules.tag.model.Tag;
import com.dj.bms.modules.user.dto.UserDTO;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.user.service.UserService;

@Service
public class PostServiceImpl extends AbstractBaseServiceImpl<Post, PostDTO> implements PostService {

	@Autowired
	private PostDao postDao;
	
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
	public Page<Post> pageByNodeAndNodeTab(Integer pageNumber, Integer pageSize, String nodeTab, String nodeTitle) {
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
	public Page<Post> pageAllByTab(Integer pageNumber, Integer pageSize, String tab) {
		List<Post> list = postDao.selectAllByTab((pageNumber - 1) * pageSize, pageSize,tab);
		int total = postDao.countTopicByTab(tab);
		return new Page<>(list, pageNumber, pageSize, total);
	}
	
	/**
	 * 根据节点查询所有话题
	 */
	@Override
	public Page<Post> pageAllByNode(Integer pageNumber, Integer pageSize, String nodeTitle) {
		List<Post> list = postDao.selectAllByNode((pageNumber - 1) * pageSize, pageSize,nodeTitle);
		int total = postDao.countTopicByNode(nodeTitle);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 根据节点查询精华话题
	 */
	@Override
	public Page<Post> pageGood(Integer pageNumber, Integer pageSize,String nodeTitle) {
		List<Post> list = postDao.selectAllGood((pageNumber - 1) * pageSize, pageSize,nodeTitle);
		int total = postDao.countTopicGoodByNode(nodeTitle);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 根据节点查询无人回复的话题
	 */
	@Override
	public Page<Post> pageNoReply(Integer pageNumber, Integer pageSize,String nodeTitle) {
		List<Post> list = postDao.selectAllNoReply((pageNumber - 1) * pageSize, pageSize,nodeTitle);
		int total = postDao.countTopicNoReplyByNode(nodeTitle);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 根据ID查询话题
	 */
	@Override
	public Post findByTopicId(Integer topicId) {
		return postDao.selectByTopicId(topicId);
	}

	/**
	 * 查询当前作者的其他话题
	 */
	@Override
	public List<Post> findOtherTopicByAuthor(Integer currentTopicId, String author, Integer limit) {
		//return rootTopicDao.selectByAuthor(currentTopicId, author, 0, limit);
		return null;
	}

	/**
	 * 根据昵称分页查询用户的所有话题
	 */
	@Override
	public Page<Post> pageByAuthor(Integer pageNumber, Integer pageSize, String author) {
		int totalRow = postDao.countAllByName(author);
		List<Post> list = postDao.selectByAuthor(author, (pageNumber - 1) * pageSize, pageSize);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 查询所有话题
	 */
	@Override
	public List<Post> findAll() {
		return postDao.selectAll();
	}

	/**
	 * 根据ID删除话题
	 */
	@Override
	public void deleteByTopicId(Integer topicId) {
		postDao.deleteById(topicId);
	}

	/**
	 * 根据作者删除话题
	 */
	@Override
	public void deleteByAuthor(String author) {
		postDao.deleteByAuthor(author);
	}

	/**
	 * 置顶话题
	 */
	@Override
	public void topByTopicId(Integer topicId) {
		Post topic = postDao.selectByTopicId(topicId);
		if(topic != null) {
			topic.setTop(!topic.getTop());
			postDao.updateByTopicId(topic);
		}
	}

	/**
	 * 话题加精
	 */
	@Override
	public void goodByTopicId(Integer topicId) {
		Post topic = postDao.selectByTopicId(topicId);
		if(topic != null) {
			topic.setGood(!topic.getGood());
			postDao.updateByTopicId(topic);
		}
	}

	/**
	 * 发布话题
	 */
	/*@Transactional
	@Override
	public TopicExecution saveTopic(Topic topic) {
		rootTopicDao.insert(topic);
		// 发贴加积分
		rootUserDao.updateScoreByName(Integer.valueOf(systemConfigService.getByKey("create_topic_score").getValue()), topic.getAuthor());
		return new TopicExecution(topic.getTitle(), InsertTopicEnum.SUCCESS, topic);
	}*/
	
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
	public void updateTopic(Post topic) {
		postDao.updateByTopicId(topic);
	}

	/**
	 * 收藏话题列表
	 */
	@Override
	public Page<Post> findCollectsById(Integer pageNumber, Integer pageSize, Integer uid) {
		return null;
	}

	/**
	 * 查询用户发布主题的数量
	 */
	@Override
	public int countByUserName(String userName) {
		return postDao.countAllByName(userName);
	}

	/**
	 * 根据节点查询最新话题
	 */
	@Override
	public Page<Post> pageAllNewest(Integer pageNumber, Integer pageSize,String nodeTitle) {
		List<Post> list = postDao.selectAllNewest((pageNumber - 1) * pageSize, pageSize,nodeTitle);
		int total = postDao.countTopicByNode(nodeTitle);
		return new Page<>(list, pageNumber, pageSize, total);
	}

	/**
	 * 热门话题
	 */
	@Override
	public List<Post> findHot(Integer start, Integer limit) {
		return postDao.selectHot(start, limit);
	}

	/**
	 * 分页查询所有标签
	 */
	@Override
	public Page<Tag> findByTag(Integer pageNumber, Integer pageSize) {
		int totalRow = postDao.countTag();
		List<Tag> list = postDao.selectAllTag((pageNumber - 1) * pageSize, pageSize);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 根据标签查询话题
	 */
	@Override
	public Page<Post> pageByTag(String tag, Integer pageNumber, Integer pageSize) {
		int totalRow = postDao.countByTag(tag);
		List<Post> list = postDao.selectByTag(tag, (pageNumber - 1) * pageSize, pageSize);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 更新主题作者的头像
	 */
	@Override
	public void updateTopicAvatar(User user) {
		postDao.updateTopicAvatar(user);
	}

	/**
	 * 更新节点名称
	 */
	@Override
	public void updateNodeTitile(String oldNodeTitle, String newNodeTitle) {
		postDao.updateNodeTitile(oldNodeTitle, newNodeTitle);
	}

	/**
	 * 统计所有话题
	 */
	@Override
	public int countAllTopic(String tab) {
		return postDao.countTopicByTab(tab);
	}

	/**
	 * 分页模糊查询
	 */
	@Override
	public Page<Post> pageLike(Integer pageNumber, Integer pageSize, String like) {
		List<Post> list = postDao.selectByLike(like, (pageNumber - 1) * pageSize, pageSize);
		int totalRow = postDao.countLike(like);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 根据板块和昵称分页查询话题
	 */
	@Override
	public Page<Post> pageAllByPtabAndAuthor(Integer pageNumber, Integer pageSize, String ptab, String author) {
		int totalRow = postDao.countAllByNameAndPtab(author, ptab);
		List<Post> list = postDao.selectAllByPtabAndAuthor((pageNumber - 1) * pageSize, pageSize, ptab, author);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 首页-最热话题
	 */
	@Override
	public Page<Post> findIndexHot(Integer pageNumber, Integer pageSize, String tab) {
		int totalRow = postDao.countIndexHot(tab);
		List<Post> list = postDao.selectIndexHot((pageNumber - 1) * pageSize, pageSize, tab);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 侧边栏-今日等待回复的话题
	 */
	@Override
	public List<Post> findTodayNoReply(Integer start, Integer limit) {
		return postDao.selectTodayNoReply(start, limit);
	}

	/**
	 * 作者的其他话题
	 */
	@Override
	public List<Post> findOther(String userName, Integer topicId) {
		return postDao.selectOther(userName, topicId);
	}

	/**
	 * 根据节点统计所有话题
	 */
	@Override
	public int countTopicByNode(String nodeTitle) {
		return postDao.countTopicByNode(nodeTitle);
	}

	@Override
	public int countToday() {
		return postDao.countToday();
	}

	@Override
	public Page<Post> pageForAdmin(String author, String startDate, String endDate, Integer pageNumber,
			Integer pageSize) {
		List<Post> list = postDao.selectAllForAdmin(author, startDate, endDate, (pageNumber - 1) * pageSize, pageSize);
		int totalRow = countAllForAdmin(author, startDate, endDate);
		return new Page<Post>(list, pageNumber, pageSize, totalRow);
	}

	@Override
	public int countAllForAdmin(String author,String startDate,String endDate) {
		return postDao.countAllForAdmin(author, startDate, endDate);
	}

	
	@Override
	public Post findById(Integer id) {
		return postDao.selectByTopicId(id);
	}
	
	@Override
	public boolean save(PostDTO topicDTO) throws PostException {
		String title = topicDTO.getTitle();
		if (StringUtils.isEmpty(title)) {
			throw new PostException(PostErrorCodeEnum.TITLE_MISSING);
		}
		String nodeId = topicDTO.getNodeDTO().getNodeId();
		if (StringUtils.isEmpty(nodeId)) {
			throw new PostException(PostErrorCodeEnum.NODE_ID_MISSING);
		}
		NodeDTO nodeDTO = nodeService.getById(nodeId);
		if (nodeDTO == null) {
			throw new PostException(PostErrorCodeEnum.INVALIDATE_NODE);
		}
		Integer userId = topicDTO.getUserDTO().getUserId();
		if (userId == null) {
			throw new PostException(PostErrorCodeEnum.USER_ID_MISSING);
		}
		UserDTO userDTO = userService.getById(userId);
		if (userDTO == null) {
			throw new PostException(PostErrorCodeEnum.INVALIDATE_USER);
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
	public Page<PostDTO> pageByNode(Integer pageNumber, Integer pageSize, Integer nodeId, String tabName) throws BaseException {
		Page<PostDTO> page = null;
		QueryWrapper<Post> queryWrapper = new QueryWrapper<>();
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
	public Function<? super PostDTO, ? extends Post> getDTO2DOMapper() {
		return postDTO -> {
			if (postDTO != null) {
				Post post = new Post();
				BeanUtils.DTO2DO(postDTO, post);
				return post;
			}
			return null;
		};
	}

	@Override
	public Function<? super Post, ? extends PostDTO> getDO2DTOMapper() {
		return post -> {
			if (post != null) {
				PostDTO postDTO = new PostDTO();
				BeanUtils.DO2DTO(post, postDTO);
				return postDTO;
			}
			return null;
		};
	}

	@Override
	public BaseDao<Post> getDao() {
		return postDao;
	}

}
