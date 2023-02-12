package com.dj.domain.entity.robot;

import com.dj.domain.base.BaseEntity;
import com.dj.domain.base.IEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RobotShowTableMoney extends BaseEntity {

	private static final long serialVersionUID = -8767313217764652909L;

	public RobotShowTableMoney(long roleID) {
		super(roleID);
	}

	private int title;

	private int col0Money;

	private Date col0Time;

	private int col1Money;

	private Date col1Time;

	private int col2Money;

	private Date col2Time;

	private int col3Money;

	private Date col3Time;

	@Override
	public IEntity copy() {
		RobotShowTableMoney item = new RobotShowTableMoney();
		copySuper(item);
		item.setTitle(title);
		item.setCol0Money(col0Money);
		item.setCol0Time(col0Time);
		item.setCol1Money(col1Money);
		item.setCol1Time(col1Time);
		item.setCol2Money(col2Money);
		item.setCol2Time(col2Time);
		item.setCol3Money(col3Money);
		item.setCol3Time(col3Time);
		return item;
	}

	public int getMoney(int type) {
		int money = 0;
		switch (type) {
		case 0:
			money = col0Money;
			break;
		case 1:
			money = col1Money;
			break;
		case 2:
			money = col2Money;
			break;
		case 3:
			money = col3Money;
			break;
		}
		return money;
	}

	public int getTotalMoney() {
		return col0Money + col1Money + col2Money + col3Money;
	}

	public long getResetTime() {
		long resetTime = 0;
		if (col0Time != null) {
			resetTime = col0Time.getTime();
		}
		if (col1Time != null && resetTime < col1Time.getTime()) {
			resetTime = col1Time.getTime();
		}
		if (col2Time != null && resetTime < col2Time.getTime()) {
			resetTime = col2Time.getTime();
		}
		if (col3Time != null && resetTime < col3Time.getTime()) {
			resetTime = col3Time.getTime();
		}
		return resetTime;
	}
}