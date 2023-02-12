package com.dj.domain.data.meetEgg;

import com.dj.protobuf.common.BaseRoleInfo;
import com.dj.protobuf.guildBattle.GuildBattleBuildInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
* @ClassName: GuildBattleBuild  
* @Description: 商会战斗建筑 
* @author zcq
* @date 2020年7月30日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GuildBattleBuild {

    /**
     *	建筑id
     */
    private int buildID;
    /**
     *	占领玩家id
     */
    private long holdRoleID;
    
    public GuildBattleBuildInfo toGuildBattleBuildInfo(GuildBattleBuildInfo.Builder builder, BaseRoleInfo baseRoleInfo) {
    	builder.setBuildID(buildID);
    	if(baseRoleInfo != null) {
    		builder.setHoldRoleInfo(baseRoleInfo);
    	}
    	return builder.build();
    }
}
