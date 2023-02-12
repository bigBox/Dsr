package com.dj.bms.common.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.dto.BaseDTO;
import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.dao.mapper.wrapper.update.UpdateWrapper;
import com.dj.bms.common.exception.BaseException;

/**
 * 该接口作为 Service 层的基础接口，定义了常用的业务增删改查方法，建议大部分的 Service 层接口继承。
 * <p>注意：要继承该接口，对应的 {@code DO} 要继承 {@link BaseDO}，{@code DTO} 要继承 {@link BaseDTO}。
 * 
 * @param <DO> 数据库表映射实体类的类型
 * @param <DTO> 数据传输的类型
 * 
 * @author: zcq
 * @date: 2019-12-29
 * @since 3.0
 */
public interface BaseService<DO extends BaseDO, DTO extends BaseDTO> {

	/**
	 * 插入一条数据
	 * @param dto 数据传输对象
	 * @return boolean
	 */
	boolean save(DTO dto) throws BaseException;

	/**
	 * 批量插入多条数据
	 * @param dtoList 数据传输对象集合
	 * @return boolean
	 */
	boolean saveBatch(Collection<DTO> dtoList) throws BaseException;

	/**
	 * 删除满足条件的数据
	 * @param updateWrapper 条件包装器
	 * @return boolean
	 */
	boolean remove(UpdateWrapper<DO> updateWrapper) throws BaseException;

	/**
	 * 根据 ID 删除一条数据
	 * @param id 主键 ID
	 * @return boolean
	 */
	boolean removeById(Serializable id) throws BaseException;

	/**
	 * 根据 ID 集合，批量删除多条数据
	 * @param idList 主键 ID 集合
	 * @return boolean
	 */
	boolean removeBatchIds(Collection<? extends Serializable> idList) throws BaseException;

	/**
	 * 更新满足条件的数据
	 * @param updateWrapper 条件包装器
	 * @return boolean
	 */
	boolean update(DTO dto, UpdateWrapper<DO> updateWrapper) throws BaseException;

	/**
	 * 根据主键 ID 更新一条数据
	 * @param dto 数据传输对象
	 * @return boolean
	 */
	boolean updateById(DTO dto) throws BaseException;

	/**
	 * 根据主键 ID 集合，批量更新多条数据
	 * @param dtoList 数据传输对象集合
	 * @return boolean
	 */
	boolean updateBatchIds(Collection<DTO> dtoList) throws BaseException;

	/**
	 * 根据主键 ID 查询一条数据
	 * @param id 主键 ID
	 * @return DTO
	 */
	DTO getById(Serializable id) throws BaseException;

	/**
	 * 查询满足条件的一条数据
	 * @param queryWrapper 条件包装器
	 * @return DTO
	 */
	DTO getOne(QueryWrapper<DO> queryWrapper) throws BaseException;

	/**
	 * 查询总记录数
	 * @return Integer
	 */
	Integer count() throws BaseException;

	/**
	 * 查询满足条件的记录数
	 * @param queryWrapper 条件包装器
	 * @return Integer
	 */
	Integer count(QueryWrapper<DO> queryWrapper) throws BaseException;

	/**
	 * 查询所有的数据
	 * @return List
	 */
	List<DTO> list() throws BaseException;

	/**
	 * 查询满足条件的多条数据
	 * @param queryWrapper 条件包装器
	 * @return List
	 */
	List<DTO> list(QueryWrapper<DO> queryWrapper) throws BaseException;

	/**
	 * 根据主键 ID 集合，批量查询多条数据
	 * @param idList 主键 ID 集合
	 * @return List
	 */
	List<DTO> listBatchIds(Collection<? extends Serializable> idList) throws BaseException;

	/**
	 * 查询所有的数据并分页
	 * @param pageNumber 当前的页数
	 * @param pageSize 每页显示多少条数据
	 * @return Page
	 */
	Page<DTO> page(Integer pageNumber, Integer pageSize) throws BaseException;

	/**
	 * 查询满足条件的多条数据并分页
	 * @param pageNumber 当前的页数
	 * @param pageSize 每页显示多少条数据
	 * @param queryWrapper 条件包装器
	 * @return Page
	 */
	Page<DTO> page(Integer pageNumber, Integer pageSize, QueryWrapper<DO> queryWrapper) throws BaseException;

	/**
	 * DTO 转换 DO 的函数
	 * @return
	 */
	Function<? super DTO, ? extends DO> getDTO2DOMapper();

	/**
	 * DO 转换 DTO 的函数
	 * @return
	 */
	Function<? super DO, ? extends DTO> getDO2DTOMapper();

	/**
	 * 获取数据访问对象
	 * @return
	 */
	BaseDao<DO> getDao();

}
