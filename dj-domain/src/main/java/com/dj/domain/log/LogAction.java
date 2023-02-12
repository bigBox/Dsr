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
@Table(name = "log_action")
@TableName("log_action")
public class LogAction extends AbsLog {

	/**
	 * @Field roleID
	 */
	@Column(name = "roleID")
	@TableField("roleID")
	private int roleID;
	/**
	 * @Field cmd
	 */
	@Column(name = "cmd")
	@TableField("cmd")
	private int cmd;
	/**
	 * @Field req
	 */
	@Column(name = "req")
	@TableField("req")
	private String req;
}