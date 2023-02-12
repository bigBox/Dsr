package com.dj.servertool.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: Notice
 * @Description: 官网论坛公告
 * @author zcq
 * @date 2019年7月2日
 */
@Data
@TableName("site_notice")
@NoArgsConstructor
public class SiteNotice {

	/**
	 * 主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private int id;

	@TableField("title")
	private String title;

	@TableField("content")
	private String content;

	@TableField("time")
	private Date time;

}
