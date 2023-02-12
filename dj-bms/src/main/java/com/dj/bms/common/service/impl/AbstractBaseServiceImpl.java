package com.dj.bms.common.service.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.transaction.annotation.Transactional;

import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.dto.BaseDTO;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.dao.mapper.wrapper.update.UpdateWrapper;
import com.dj.bms.common.exception.BaseException;

/**
 * 该类是 Service Impl 层的基础父类，实现了常用的业务增删改查方法，建议大部分的 Service Impl 层继承。
 * <p>继承该类后即可拥有简单的业务 CRUD 能力。
 * <p>注意：要继承该类，对应的 {@code DO} 要继承 {@link BaseDO}，{@code DTO} 要继承 {@link BaseDTO}。
 * 
 * @param <DO> 数据库表映射实体类的类型
 * @param <DTO> 数据传输的类型
 * 
 * @author zcq
 * @date 2019-12-29
 * @since 3.0
 */
public abstract class AbstractBaseServiceImpl<DO extends BaseDO, DTO extends BaseDTO> implements BaseService<DO, DTO> {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean save(DTO dto) throws BaseException {
		return retBool(getDao().insert(getDTO2DOMapper().apply(dto)));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean saveBatch(Collection<DTO> dtoList) throws BaseException {
		dtoList.forEach(dto -> save(dto));
		return true;
	}

	@Override
	public boolean remove(UpdateWrapper<DO> updateWrapper) throws BaseException {
		return retBool(getDao().delete(updateWrapper));
	}

	@Override
	public boolean removeById(Serializable id) throws BaseException {
		return retBool(getDao().deleteById(id));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean removeBatchIds(Collection<? extends Serializable> idList) throws BaseException {
		idList.forEach(id -> removeById(id));
		return true;
	}

	@Override
	public boolean update(DTO dto, UpdateWrapper<DO> updateWrapper) throws BaseException {
		return retBool(getDao().update(getDTO2DOMapper().apply(dto), updateWrapper));
	}

	@Override
	public boolean updateById(DTO dto) throws BaseException {
		return retBool(getDao().updateById(getDTO2DOMapper().apply(dto)));
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean updateBatchIds(Collection<DTO> dtoList) throws BaseException {
		dtoList.forEach(dto -> updateById(dto));
		return true;
	}

	@Override
	public DTO getById(Serializable id) throws BaseException {
		return getDO2DTOMapper().apply(getDao().selectById(id));
	}

	@Override
	public DTO getOne(QueryWrapper<DO> queryWrapper) throws BaseException {
		return getDO2DTOMapper().apply(getDao().selectOne(queryWrapper));
	}

	@Override
	public Integer count() throws BaseException {
		return getDao().selectCount(null);
	}

	@Override
	public Integer count(QueryWrapper<DO> queryWrapper) throws BaseException {
		return getDao().selectCount(queryWrapper);
	}

	@Override
	public List<DTO> list() throws BaseException {
		return getDao().selectList(null).stream().map(getDO2DTOMapper()).collect(Collectors.toList());
	}

	@Override
	public List<DTO> list(QueryWrapper<DO> queryWrapper) throws BaseException {
		return getDao().selectList(queryWrapper).stream().map(getDO2DTOMapper()).collect(Collectors.toList());
	}

	@Override
	public List<DTO> listBatchIds(Collection<? extends Serializable> idList) throws BaseException {
		return getDao().selectBatchIds(idList).stream().map(getDO2DTOMapper()).collect(Collectors.toList());
	}

	@Override
	public Page<DTO> page(Integer pageNumber, Integer pageSize) throws BaseException {
		QueryWrapper<DO> queryWrapper = new QueryWrapper<>();
		queryWrapper.limit((pageNumber - 1) * pageSize, pageSize);
		List<DTO> list = list(queryWrapper);
		Integer totalRow = count();
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	@Override
	public Page<DTO> page(Integer pageNumber, Integer pageSize, QueryWrapper<DO> queryWrapper) throws BaseException {
		queryWrapper.limit((pageNumber - 1) * pageSize, pageSize);
		List<DTO> list = list(queryWrapper);
		// CountWrapperHelper<DO> helper = new CountWrapperHelper<>(queryWrapper);
		// QueryWrapper<DO> countWrapper = (QueryWrapper<DO>) helper.getInstance();
		Integer totalRow = count(queryWrapper);
		return new Page<>(list, pageNumber, pageSize, totalRow);
	}

	/**
	 * 判断数据库操作是否成功
	 * @param result  数据库操作返回影响条数
	 * @return boolean
	 */
	private static boolean retBool(Integer result) {
		return result != null && result >= 1;
	}

	class CountWrapperHelper<T> implements MethodInterceptor {

		private QueryWrapper<T> queryWrapper;

		public CountWrapperHelper(QueryWrapper<T> queryWrapper) {
			this.queryWrapper = queryWrapper;
		}

		public Object getInstance() {
			Enhancer en = new Enhancer();
			en.setSuperclass(queryWrapper.getClass());
			en.setCallback(this);
			return en.create();
		}

		@Override
		public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
			if (Objects.equals(method.getName(), "getSqlSegment")) {
				return queryWrapper.getNormalSqlSegment();
			}
			return methodProxy.invokeSuper(proxy, args);
		}

	}

}