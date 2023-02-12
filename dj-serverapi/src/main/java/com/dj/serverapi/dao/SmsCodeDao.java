package com.dj.serverapi.dao;

import com.dj.domain.entity.player.SmsCode;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.ISmsCodeDao;
import org.springframework.stereotype.Component;

@Component
public class SmsCodeDao extends BaseCacheDao<SmsCode> implements ISmsCodeDao {

}
