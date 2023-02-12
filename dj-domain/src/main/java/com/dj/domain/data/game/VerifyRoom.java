package com.dj.domain.data.game;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zcq
 * @ClassName: VerifyRoom
 * @Description: 鉴定房间
 * @date 2019年7月30日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VerifyRoom {

    /**
     *	房间主人
     */
    private long roomRoleID;

    /**
     *	访客列表
     */
    private List<Long> visitorList = Lists.newArrayListWithExpectedSize(3);

    public VerifyRoom(long roomRoleID) {
        this.roomRoleID = roomRoleID;
    }
}
