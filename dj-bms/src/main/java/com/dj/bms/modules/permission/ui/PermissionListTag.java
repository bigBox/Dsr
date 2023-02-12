package com.dj.bms.modules.permission.ui;

import javax.servlet.http.HttpServletRequest;

import com.dj.bms.common.ui.AbstractListTag;
import com.dj.bms.common.ui.support.TableTagTdSupport;
import com.dj.bms.common.ui.support.TableTagThSupport;
import com.dj.bms.modules.permission.vo.PermissionVO;

/**
 * @author zcq
 * @date 2020-03-03
 */
@SuppressWarnings("serial")
public class PermissionListTag extends AbstractListTag {

	@Override
	protected TableTagThSupport getTableTagThSupport() {
		return () -> "操作";
	}

	@Override
	protected TableTagTdSupport getTableTagTdSupport() {
		HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();
		String contextPath = request.getContextPath();
		return object -> {
			PermissionVO permissionVO = (PermissionVO) object;
			return "<a href=\"" + contextPath + "/admin/permission/edit?id=" + permissionVO.getPermissionId()
					+ "\" class=\"btn btn-xs btn-warning\">编辑</a>\n<a href=\"javascript:if(confirm('确定要删除吗？')) location.href='"
					+ contextPath + "/admin/permission/remove?id=" + permissionVO.getPermissionId()
					+ "'\" class=\"btn btn-xs btn-danger\">删除</a>";
		};
	}

}
