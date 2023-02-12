package com.dj.domain.log;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.dj.domain.base.Column;
import com.dj.domain.base.Entity;
import com.dj.domain.base.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(fetch = Entity.FeatchType.START)
@Table(name = "log_resource")
@TableName("log_resource")
public class LogResource extends AbsLog {

	/**
	 * @Field roleID
	 */
	@Column(name = "roleID")
	@TableField("roleID")
	private int roleID;
	/**
	 * @Field type
	 */
	@Column(name = "type")
	@TableField("type")
	private String type;
	/**
	 * @Field resourceID
	 */
	@Column(name = "resourceID")
	@TableField("resourceID")
	private String resourceID;
	/**
	 * @Field count
	 */
	@Column(name = "count")
	@TableField("count")
	private int count;
	/**
	 * @Field change
	 */
	@Column(name = "change")
	@TableField("change")
	private int change;
	/**
	 * @Field circType
	 */
	@Column(name = "bill")
	@TableField("bill")
	private String bill;
	/**
	 * @Field desc
	 */
	@Column(name = "desc")
	@TableField("desc")
	private String desc;
}