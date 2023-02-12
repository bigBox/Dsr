package com.dj.serverapi.dao;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IGlobalGuildDao;

@Component
public class GlobalGuildDao extends BaseCacheDao<GlobalGuild> implements IGlobalGuildDao {

	@Override
	public String getAccessType() {
		return AccessType.DIRECT_DB;
	}
}
