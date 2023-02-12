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
@Table(name = "log_online")
@TableName("log_online")
public class LogOnline extends AbsLog {

	/**
	 * @serialField  serverType
	 */
	@Column(name = "serverType")
	@TableField("serverType")
	private String serverType;

	/**
	 * @Field serverID
	 */
	@Column(name = "serverID")
	@TableField("serverID")
	private int serverID;
	/**
	 * @Field onlineCount
	 */
	@Column(name = "onlineCount")
	@TableField("onlineCount")
	private int onlineCount;
}