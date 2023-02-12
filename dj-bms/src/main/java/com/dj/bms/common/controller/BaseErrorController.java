package com.dj.bms.common.controller;

import com.dj.bms.common.beans.Result;
import com.dj.bms.common.enums.BaseErrorCodeEnum;
//import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zcq
 * @date 2020-01-21
 */
//@Controller
public class BaseErrorController implements ErrorController {

	//@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(value = "/error", produces = "text/html")
	public ModelAndView errorHtml(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", BaseErrorCodeEnum.INTERNAL_ERROR.getMessage());
		mv.addObject("errorCode", getStatus(request).value());
		mv.setViewName("/default/front/error/error");
		return mv;
	}

	@RequestMapping(value = "/error")
	@ResponseBody
	public ResponseEntity<Result<String>> error(HttpServletRequest request) {
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
