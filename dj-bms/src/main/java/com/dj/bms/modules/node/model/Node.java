package com.dj.bms.modules.node.model;

import java.util.Date;

import com.dj.bms.common.annotation.DO2DTO;
import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.annotation.Table;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.enums.ConverPolicy;

/**
 * 节点实体类
 * 
 * @author zcq
 * @date 2018年11月3日 上午11:38:30
 */
@Table("node")
public class Node implements BaseDO {

	private static final long serialVersionUID = -7346089878757372971L;
	
	/**
	 * 节点ID
	 */
	@Id(value = "node_id")
	private Integer nodeId;
	
	/**
	 * 父节点ID
	 */
	@DO2DTO(targets = {"parentNodeDTO"}, policy = ConverPolicy.ID_CONVER_DTO, service = "nodeServiceImpl")
	private Integer parentNodeId;
	
	/**
	 * 节点编码
	 */
	private String nodeCode;
	
	/**
	 * 节点名字
	 */
	private String nodeTitle;
	
	/**
	 * 节点说明
	 */
	private String nodeDesc;
	
	/**
	 * 节点图标
	 */
	private String avatar;
	
	/**
	 * 链接
	 */
	private String url;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getParentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(Integer parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getNodeTitle() {
		return nodeTitle;
	}

	public void setNodeTitle(String nodeTitle) {
		this.nodeTitle = nodeTitle;
	}

	public String getNodeDesc() {
		return nodeDesc;
	}

	public void setNodeDesc(String nodeDesc) {
		this.nodeDesc = nodeDesc;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Node {nodeId=" + nodeId + ", parentNodeId=" + parentNodeId + ", nodeCode=" + nodeCode + ", nodeTitle="
				+ nodeTitle + ", nodeDesc=" + nodeDesc + ", avatar=" + avatar + ", url=" + url + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "}";
	}

}
