package com.dj.bms.modules.app.ui;

import com.dj.bms.common.ui.AbstractListTag;
import com.dj.bms.common.ui.support.TableTagTdSupport;
import com.dj.bms.common.ui.support.TableTagThSupport;
import com.dj.bms.modules.app.vo.AppCategoryVO;

/**
 * 应用类别 List 标签
 * 
 * @author zcq
 * @date 2020-03-08
 */
@SuppressWarnings("serial")
public class AppCategoryListTag extends AbstractListTag {

	@Override
	protected TableTagThSupport getTableTagThSupport() {
		return () -> "操作";
	}

	@Override
	protected TableTagTdSupport getTableTagTdSupport() {
		String contextPath = super.getContextPath();
		return object -> {
			AppCategoryVO appCategoryVO = (AppCategoryVO) object;
			StringBuilder sb = new StringBuilder();
			sb.append("<a href=\"" + contextPath + "/admin/app/category/edit?id=" + appCategoryVO.getAppCategoryId() + "\" class=\"btn btn-xs btn-warning\">编辑</a>");
			sb.append("\t\n");
			sb.append("<a href=\"javascript:if(confirm('确定要删除吗？')) location.href='" + contextPath + "/admin/app/category/remove?id=" + appCategoryVO.getAppCategoryId() + "'\" class=\"btn btn-xs btn-danger\">删除</a>");
			return sb.toString();
		};
	}

}
