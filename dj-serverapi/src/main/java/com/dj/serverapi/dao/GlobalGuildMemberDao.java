package com.dj.serverapi.dao;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.global.GlobalGuildMember;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IGlobalGuildMemberDao;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GlobalGuildMemberDao extends BaseCacheDao<GlobalGuildMember> implements IGlobalGuildMemberDao {

	@Override
	public String getAccessType() {
		return AccessType.DIRECT_DB;
	}
	
	@Override
	public List<GlobalGuildMember> readDbData(long guildID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("guildID", guildID);
		List<GlobalGuildMember> list = selectList(queryParams, guildID, AccessType.DIRECT_DB);
		if(list != null && list.size() > 0) {
			list = new ArrayList<>();
		}
		return list;
	}
}
