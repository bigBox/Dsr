package com.dj.bms.modules.node.service.impl;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

import com.dj.bms.modules.node.model.Node;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.modules.node.dao.NodeDao;
import com.dj.bms.modules.node.dto.NodeDTO;
import com.dj.bms.modules.node.service.NodeService;
import com.dj.bms.modules.post.service.PostService;
import com.dj.bms.modules.user.model.User;

/**
 * @author zcq
 * @date 2018年11月3日 下午2:48:24
 */
@Service
public class NodeServiceImpl extends AbstractBaseServiceImpl<Node, NodeDTO> implements NodeService{

	@Autowired
	private NodeDao nodeDao;
	
	// @Autowired
	// private TopicService topicService;
	
	//根据板块查询节点
	@Override
	public List<Node> findAllByTab(String tabName, Integer pageNumber, Integer pageSize) {
		return nodeDao.selectAllByTab(tabName, pageNumber, pageSize);
	}

	@Override
	public Node findByTitle(String title) {
		return nodeDao.selectByTitle(title);
	}
	
	@Override
	public Node findById(Integer id) {
		return nodeDao.selectById(id);
	}

	//子节点
	@Override
	public List<Node> findChildrenNode(String nodeTitle, Integer pageNumber, Integer pageSize) {
		return nodeDao.selectChildrenNode(nodeTitle, pageNumber, pageSize);
	}

	//相邻节点
	/*@Override
	public List<Node> adjacencyNode(Node node) {
		if(node.getparentNodeId() != null) {
			return nodeDao.selectAtherNode(node.getNodeCode(), node.getparentNodeId(), null, null);
		}else {
			return nodeDao.selectAtherParentNode(node.getNodeCode(), node.getTabId(), null, null);
		}
	}*/

	//查询全部节点
	@Override
	public List<Node> findAll(Integer pageNumber, Integer pageSize) {
		return nodeDao.selectAll(pageNumber, pageSize);
	}

	// 后台节点列表
	@Override
	public Page<Node> pageForAdmin(String nodeTitle, Integer pageNumber, Integer pageSize) {
		List<Node> list = nodeDao.listForAdmin(nodeTitle, (pageNumber - 1) * pageSize, pageSize);
		return new Page<Node>(list, pageNumber, pageSize, count(nodeTitle));
	}

	// 统计节点列表
	@Override
	public int count(String nodeTitle) {
		return nodeDao.count(nodeTitle);
	}

	@Transactional
	@Override
	public void update(Integer nodeId, String parentNodeId, String nodeName, String avatarNormal, String avatarLarge, String nodeDesc) {
		Node node = findById(nodeId);
		// 先更新话题的节点名称
		/*if(!nodeTitle.equals(node.getNodeTitle())) {
			topicService.updateNodeTitile(node.getNodeTitle(), nodeTitle);
		}*/
		// node.setparentNodeId(parentNodeId);
		node.setNodeCode(nodeName);
		node.setNodeTitle(nodeName);
		// node.setAvatarNormal(avatarNormal);
		// node.setAvatarLarge(avatarLarge);
		node.setNodeDesc(nodeDesc);
		node.setUrl("/n/" + nodeName);
		node.setUpdateDate(new Date());
		// 最后在更新节点
		nodeDao.update(node);
	}

	/**
	 * 添加节点
	 * @param node
	 */
	@Override
	public void save(Node node) {
		nodeDao.insert(node);
	}

	/**
	 * 删除节点
	 */
	@Transactional
	@Override
	public void deleteById(Integer id) {
		Node node = findById(id);
		// 先将话题的节点设置为 null
		// topicService.updateNodeTitile(node.getNodeTitle(), null);
		// 然后在删除节点
		nodeDao.deleteById(id);
	}

	/**
	 * 统计当天的节点数量
	 */
	@Override
	public int countToday() {
		return nodeDao.countToday();
	}

	@Override
	public Function<? super NodeDTO, ? extends Node> getDTO2DOMapper() {
		return nodeDTO -> {
			if (nodeDTO != null) {
				Node node = new Node();
				BeanUtils.copyProperties(nodeDTO, node);
				return node;
			}
			return null;
		};
	}

	@Override
	public Function<? super Node, ? extends NodeDTO> getDO2DTOMapper() {
		return node -> {
			if (node != null) {
				NodeDTO nodeDTO = new NodeDTO();
				BeanUtils.copyProperties(node, nodeDTO);
				return nodeDTO;
			}
			return null;
		};
	}

	@Override
	public BaseDao<Node> getDao() {
		return nodeDao;
	}
}
