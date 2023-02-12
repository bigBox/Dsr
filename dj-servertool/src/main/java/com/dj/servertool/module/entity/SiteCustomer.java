package com.dj.servertool.module.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: SiteCustomer
 * @Description: 联系客服
 * @author zcq
 * @date 2019年6月26日
 */
@Data
@TableName("site_customer")
@NoArgsConstructor
public class SiteCustomer {

	@TableId(value = "id", type = IdType.AUTO)
	private int id;

	@TableField("username")
	private String username;

	@TableField("customer")
	private String customer;

	@TableField("time")
	private Date time;

}
