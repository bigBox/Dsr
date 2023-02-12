package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.data.FriendAction;
import com.dj.domain.data.FriendApply;
import com.dj.protobuf.friend.EFriendApplyType;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @ClassName: FriendModel
 * @Description: 好友
 * @date 2019年8月7日
 */
public class FriendModel extends BaseModel {

    public FriendModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_FRIEND, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.initNewSubMap(RedisKeys.KEY_FRIEND_APPLY);
        this.data.set(RedisKeys.KEY_FRIEND_ACTION, Lists.newLinkedList());
    }

    public Map<Long, FriendApply> getApply() {
        return this.data.getSubMap(RedisKeys.KEY_FRIEND_APPLY);
    }

    public FriendApply addApply(long friendID, EFriendApplyType applyType) {
        Map<Long, FriendApply> applyMap = getApply();
        FriendApply apply = applyMap.get(friendID);
        if (apply == null) {
            apply = new FriendApply(friendID, System.currentTimeMillis(), applyType.getNumber());
        } else {
            apply.setApplyTime(System.currentTimeMillis());
            apply.setApplyType(applyType.getNumber());
        }
        applyMap.put(friendID, apply);
        return apply;
    }

    public List<FriendAction> getAction(){
        return this.data.get(RedisKeys.KEY_FRIEND_ACTION);
    }
}
