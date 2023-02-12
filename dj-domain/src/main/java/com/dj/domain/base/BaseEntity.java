package com.dj.domain.base;

import com.dj.domain.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public abstract class BaseEntity implements Serializable, IEntity {
	private static final long serialVersionUID = -8053649075062950343L;

	/**
	 * @Field id : 自增id-主键
	 */
	protected long id;

	protected long roleID;

	/**
	 * @Field createTime : 记录创建时间
	 */
	protected Date createTime;

	/**
	 * @Field updateTime : 记录更新时间
	 */
	protected Date updateTime;

	public BaseEntity(long roleID) {
		this.roleID = roleID;
		setCreateTime(DateUtil.getCurrentDate());
		setUpdateTime(DateUtil.getCurrentDate());
	}

	@Override
	public String getPrimaryKeyName() {
		return "id";
	}

	@Override
	public Object getPrimaryKeyValue() {
		return id;
	}

	@Override
	public IEntity copy() {
		return null;
	}
	
	protected void copySuper(BaseEntity base) {
		base.setId(id);
		base.setRoleID(roleID);
		base.setCreateTime(createTime);
		base.setUpdateTime(DateUtil.getCurrentDate());
	}
}
