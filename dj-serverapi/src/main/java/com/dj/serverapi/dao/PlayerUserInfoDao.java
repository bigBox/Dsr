package com.dj.serverapi.dao;

import com.dj.domain.entity.player.PlayerUserInfo;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IPlayerUserInfoDao;
import org.springframework.stereotype.Component;

@Component
public class PlayerUserInfoDao extends BaseCacheDao<PlayerUserInfo> implements IPlayerUserInfoDao {

}
