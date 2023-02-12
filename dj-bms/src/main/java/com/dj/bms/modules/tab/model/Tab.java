package com.dj.bms.modules.tab.model;

import java.util.Date;

import com.dj.bms.common.dao.mapper.annotation.Id;
import com.dj.bms.common.dao.mapper.enums.IdType;
import com.dj.bms.common.entity.BaseDO;

/**
 * 父板块
 * @author zcq
 * 2018年7月15日
 * 下午8:53:45
 * TODO
 */
public class Tab implements BaseDO {

	/**
	 * id，主键
	 */
	@Id(value = "topic_id", type = IdType.AUTO)
	private Integer id;
	
	/**
	 * 名称
	 */
	private String tabName;
	
	/**
	 * 描述
	 */
	private String tabDesc;
	
	/**
	 * 是否删除 false：否  true：是
	 */
	private boolean idDelete;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 排列顺序
	 */
	private Integer tabOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public String getTabDesc() {
		return tabDesc;
	}

	public void setTabDesc(String tabDesc) {
		this.tabDesc = tabDesc;
	}

	public boolean isIdDelete() {
		return idDelete;
	}

	public void setIdDelete(boolean idDelete) {
		this.idDelete = idDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getTabOrder() {
		return tabOrder;
	}

	public void setTabOrder(Integer tabOrder) {
		this.tabOrder = tabOrder;
	}

	@Override
	public String toString() {
		return "Tab [id=" + id + ", tabName=" + tabName + ", tabDesc=" + tabDesc + ", idDelete=" + idDelete
				+ ", createDate=" + createDate + ", tabOrder=" + tabOrder + "]";
	}
	
}
