package com.dj.domain.data.guildBattle;

import com.dj.protobuf.meetEgg.MeetEggDropItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zcq
 * @description 接鸡蛋掉落
 * @date 2020年7月31日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GuildBattleMeetEggDrop {

    // 掉落唯一id
    private String timeID;
    // 掉落配置id
    private int dropID;
    // 方向：2向右，1向左
    private int directionX;
    // 距离掉落的秒数
    private int leftSeconds;

    // 掉落时间
    private long dropTime;

    public MeetEggDropItem toMeetEggDropItem(MeetEggDropItem.Builder builder) {
        builder.setTimeID(timeID);
        builder.setDropID(dropID);
        builder.setLeftSeconds(leftSeconds);
        return builder.build();
    }
}
