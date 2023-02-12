package com.dj.domain.data.guildBattle;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GuildBattleRole {

	private long roleID;
	
	private Date battleCDEnd;
	
	private int buildID;
}
