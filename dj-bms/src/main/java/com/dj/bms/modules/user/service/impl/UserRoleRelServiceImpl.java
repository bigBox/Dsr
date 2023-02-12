package com.dj.bms.modules.user.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.user.dao.UserRoleRelDao;
import com.dj.bms.modules.user.dto.UserRoleRelDTO;
import com.dj.bms.modules.user.model.UserRoleRel;
import com.dj.bms.modules.user.service.UserRoleRelService;

/**
 * 用户和角色多对多关联 Service Impl
 * 
 * @author zcq
 * @date 2020-02-23
 */
@Service
public class UserRoleRelServiceImpl extends AbstractBaseServiceImpl<UserRoleRel, UserRoleRelDTO>
		implements UserRoleRelService {

	@Autowired
	private UserRoleRelDao userRoleRelDao;

	@Override
	public Function<? super UserRoleRelDTO, ? extends UserRoleRel> getDTO2DOMapper() {
		return dto -> (UserRoleRel) BeanUtils.DTO2DO(dto, UserRoleRel.class);
	}

	@Override
	public Function<? super UserRoleRel, ? extends UserRoleRelDTO> getDO2DTOMapper() {
		return entity -> (UserRoleRelDTO) BeanUtils.DO2DTO(entity, UserRoleRelDTO.class);
	}

	@Override
	public BaseDao<UserRoleRel> getDao() {
		return userRoleRelDao;
	}

}
