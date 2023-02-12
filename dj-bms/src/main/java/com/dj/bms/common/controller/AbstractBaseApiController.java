package com.dj.bms.common.controller;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.beans.Result;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.dto.BaseDTO;
import com.dj.bms.common.entity.BaseDO;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.CookieAndSessionUtil;
import com.dj.bms.common.vo.BaseVO;
import com.dj.bms.config.ApplicationConfig;
import com.dj.bms.modules.user.model.User;

/**
 * 该类是 Api Controller 层的基础父类，实现了常用的业务增删改查方法，建议大部分的 Api Controller 层继承。
 * <p>继承该类后，需要重写父类的方法，使用 {@code @RequestMapping} 注解定义方法的路由。
 * 对于简单的业务，返回父类的方法即可。如果父类的方法无法满足业务需求，子类可以自己实现业务逻辑。
 * <p>注意：要继承该类，对应的 {@code DO} 要继承 {@link BaseDO}，{@code DTO} 要继承 {@link BaseDTO}，
 * {@code VO} 要继承 {@link BaseVO}
 * 
 * @param <DO> 数据库表映射实体类的类型
 * @param <DTO> 数据传输的类型
 * @param <VO> 视图传输的类型
 * 
 * @author zcq
 * @date 2020-01-14
 * @since 3.0
 */
public abstract class AbstractBaseApiController<DO extends BaseDO, DTO extends BaseDTO, VO extends BaseVO>
		implements BaseApiController<VO> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected ApplicationConfig applicationConfig;

	public ResponseEntity<Result<VO>> save(VO vo, HttpServletRequest request, HttpServletResponse response) {
		this.getService().save(this.getVO2DTO().apply(vo));
		return new ResponseEntity<Result<VO>>(
				new Result<>(this.getDTO2VO().apply(this.getService().getById(vo.getPrimaryKey()))),
				HttpStatus.CREATED);
	}

	public ResponseEntity<Result<VO>> remove(Integer id, HttpServletRequest request, HttpServletResponse response) {
		this.getService().removeById(id);
		return new ResponseEntity<Result<VO>>(new Result<>(null), HttpStatus.NO_CONTENT);
	}

	public ResponseEntity<Result<VO>> update(VO vo, HttpServletRequest request, HttpServletResponse response) {
		this.getService().updateById(getVO2DTO().apply(vo));
		return new ResponseEntity<Result<VO>>(
				new Result<>(this.getDTO2VO().apply(this.getService().getById(vo.getPrimaryKey()))),
				HttpStatus.CREATED);
	}

	public ResponseEntity<Result<VO>> getOne(Integer id, HttpServletRequest request, HttpServletResponse response) {
		return new ResponseEntity<Result<VO>>(new Result<VO>(getDTO2VO().apply(this.getService().getById(id))),
				HttpStatus.OK);
	}

	public ResponseEntity<Result<Page<? extends VO>>> page(Integer pageNumber, HttpServletRequest request,
			HttpServletResponse response) {
		Page<DTO> dtoPage = this.getService().page(pageNumber, 25, this.getQueryWrapper());
		List<? extends VO> voList = dtoPage.getList().stream().filter(Objects::nonNull).map(getDTO2VO())
				.collect(Collectors.toList());
		Page<? extends VO> voPage = new Page<>(voList, dtoPage.getPageNumber(), dtoPage.getPageSize(),
				dtoPage.getTotalRow());
		return new ResponseEntity<Result<Page<? extends VO>>>(new Result<>(voPage), HttpStatus.OK);
	}

	protected abstract Function<? super DTO, ? extends VO> getDTO2VO();

	protected abstract Function<? super VO, ? extends DTO> getVO2DTO();

	protected abstract BaseService<DO, DTO> getService();

	protected abstract QueryWrapper<DO> getQueryWrapper();

	/**
	 * 获取当前登录用户的信息
	 * 
	 * @param request
	 * @return
	 */
	protected User getUser(HttpServletRequest request) {
		return CookieAndSessionUtil.getSession(request, "user");
	}

}
