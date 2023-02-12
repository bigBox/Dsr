package com.dj.bms.modules.app.controller;

import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dj.bms.common.controller.AbstractBaseController;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.app.dto.AppDTO;
import com.dj.bms.modules.app.model.App;
import com.dj.bms.modules.app.service.AppService;
import com.dj.bms.modules.app.vo.AppVO;

/**
 * 应用 Admin Controller
 * 
 * @author zcq
 * @date 2020-03-08
 */
@Controller
@RequestMapping(value = "/admin/app")
public class AppController extends AbstractBaseController<App, AppDTO, AppVO> {
	
	@Autowired
	private AppService appService;
	
	/**
	 * 返回添加应用页面
	 */
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		return super.add(request, response);
	}

	@Override
	protected Function<? super AppDTO, ? extends AppVO> getDTO2VO() {
		return dto -> (AppVO) BeanUtils.DTO2VO(dto, AppVO.class);
	}

	@Override
	protected Function<? super AppVO, ? extends AppDTO> getVO2DTO() {
		return vo -> (AppDTO) BeanUtils.VO2DTO(vo, AppDTO.class);
	}

	@Override
	protected BaseService<App, AppDTO> getService() {
		return appService;
	}

	@Override
	protected String getModuleName() {
		return "app";
	}

	@Override
	protected String getJspPrefix() {
		return "/admin/" + getModuleName();
	}
	
	@Override
	protected QueryWrapper<App> getQueryWrapper() {
		QueryWrapper<App> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("create_date");
		return queryWrapper;
	}

}
