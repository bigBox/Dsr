package com.dj.serverapi.service;

import com.dj.domain.data.FriendAction;
import com.dj.domain.data.FriendApply;
import com.dj.protobuf.friend.EFriendApplyType;
import com.dj.serverapi.redis.model.FriendModel;
import com.dj.serverapi.service.inf.IFriendService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.inf.IArgumentRunnable;

import java.util.List;
import java.util.Map;

public class FriendServiceImpl extends BaseService implements IFriendService {

    @Override
    public FriendApply friendApply(long targetRoleID, long srcRoleID, EFriendApplyType applyType) {
        return getWriteModel(targetRoleID, FriendModel.class).addApply(srcRoleID, applyType);
    }

    @Override
    public void friendApprove(long targetRoleID, long srcRoleID, IArgumentRunnable<FriendApply> run) {
        Map<Long, FriendApply> applyMap = getWriteModel(srcRoleID, FriendModel.class).getApply();
        FriendApply apply = applyMap.get(targetRoleID);
        run.run(apply);
        applyMap.remove(targetRoleID);
    }

    @Override
    public Map<Long, FriendApply> getApply(long roleID) {
        return getReadModel(roleID, FriendModel.class).getApply();
    }

    @Override
    public void addAction(long roleID, FriendAction action) {
        FriendModel model = getWriteModel(roleID, FriendModel.class);
        List<FriendAction> actions = model.getAction();
        actions.add(action);
    }

    @Override
    public void doAction(long roleID, IArgumentRunnable<FriendAction> run) {
        FriendModel model = getWriteModel(roleID, FriendModel.class);
        List<FriendAction> actions = model.getAction();
        actions.forEach(value->run.run(value));
        actions.clear();
    }
}
