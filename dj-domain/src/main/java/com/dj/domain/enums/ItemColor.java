package com.dj.domain.enums;

public enum ItemColor {

	/**
	 *	未鉴定
	 */
	color1(1),
	/**
	 *	完美
	 */
	color2(2),
	/**
	 *	瑕疵
	 */
	color3(3),
	/**
	 *	破损
	 */
	color4(4),
	/**
	 *	赝品
	 */
	color5(5);

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	private int color;

	ItemColor(int value) {
		this.color = value;
	}
}
