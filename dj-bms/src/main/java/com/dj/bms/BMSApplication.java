package com.dj.bms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.ErrorController;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.dj.bms.common.beans.Result;
import com.dj.bms.common.enums.BaseErrorCodeEnum;
import org.springframework.web.servlet.ModelAndView;

/**
 * 以 SpringBoot 的方式启动项目
 * 
 * @author zcq
 * @date 2020-01-15
 * @since 3.0
 */
@Controller
@SpringBootApplication
@ImportResource({"classpath*:spring/spring-*.xml"})
public class BMSApplication implements ErrorController {

	private static final Logger logger = LoggerFactory.getLogger(BMSApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BMSApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setForceEncoding(true);
		characterEncodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterEncodingFilter);
		return registrationBean;
	}

	//@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(value = "/error", produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", BaseErrorCodeEnum.INTERNAL_ERROR.getMessage());
		mv.addObject("errorCode", getStatus(request).value());
		mv.setViewName("/default/front/error/error");
		return mv;
	}

	@RequestMapping(value = "/error")
	@ResponseBody
	public ResponseEntity<Result<String>> error(HttpServletRequest request, HttpServletResponse response) {
		HttpStatus status = getStatus(request);
		return new ResponseEntity<Result<String>>(new Result<>(BaseErrorCodeEnum.INTERNAL_ERROR.getErrorCode(),
				BaseErrorCodeEnum.INTERNAL_ERROR.getMessage()), status);
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode != null) {
			try {
				return HttpStatus.valueOf(statusCode);
			} catch (Exception ex) {
			}
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
