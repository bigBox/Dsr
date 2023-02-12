package com.dj.domain.enums;

/**
 * @ClassName: FiveEle2Produce  
 * @Description: 五行属性产出映射
 * @author zcq 
 * @date 2020年8月5日
 */
public enum FiveEle2Produce {

	//金
	gold(1, 102001),
	//木
    wood(2, 102002),
    //水
    water(3, 102003),
    //火
    fire(4, 102004),
    //土
    earth(5, 102005);

	public int getFiveEle() {
		return fiveEle;
	}

	public void setFiveEle(int fiveEle) {
		this.fiveEle = fiveEle;
	}

	public int getDigGold() {
		return digGold;
	}

	public void setDigGold(int digGold) {
		this.digGold = digGold;
	}

	private int fiveEle;
	private int digGold;
	
	
	FiveEle2Produce(int fiveEle, int digGold){
		this.fiveEle = fiveEle;
		this.digGold = digGold;
	}
	
	
	public static FiveEle2Produce getFiveEle2Produce(int fiveEle) {
		for (FiveEle2Produce tmp : FiveEle2Produce.values()) {
			if (fiveEle == tmp.getFiveEle()) {
				return tmp;
			}
		}
		return null;
	}
	
	public static boolean checkIsDigGold(int value) {
		for (FiveEle2Produce tmp : FiveEle2Produce.values()) {
			if (value == tmp.getDigGold()) {
				return true;
			}
		}
		return false;
	}
}
