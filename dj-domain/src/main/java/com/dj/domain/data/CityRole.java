package com.dj.domain.data;

import com.dj.domain.util.lib.DataPair;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CityRole {

	private long roleID;
	
	private int npcID;
	
	private int questionID;
	
	private DataPair<Integer, Integer> wantThing = new DataPair<Integer, Integer>(0, 0);
	
	public CityRole(long roleID, int npcID, int questionID, int itemID, int itemCount) {
		this.roleID = roleID;
		this.npcID = npcID;
		this.questionID = questionID;
		this.wantThing.setObj1(itemID);
		this.wantThing.setObj2(itemCount);
	}
	

	public void setWantThing(int itemID, int itemCount) {
		this.wantThing.setObj1(itemID);
		this.wantThing.setObj2(itemCount);
	}
}
