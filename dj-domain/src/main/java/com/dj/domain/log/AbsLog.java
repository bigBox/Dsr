package com.dj.domain.log;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import com.dj.domain.base.Column;
import com.dj.domain.base.Entity;
import com.dj.domain.base.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity(fetch = Entity.FeatchType.START)
public class AbsLog {

	/**
	 * @Field id : 自增id-主键
	 */
	@Id
	@Column(name = "id")
	@TableId(value = "id", type = IdType.AUTO)
	protected int id;

	/**
	 * @Field logTime : 日志时间
	 */
	@Column(name = "logTime")
	@TableField("logTime")
	protected String logTime;
}