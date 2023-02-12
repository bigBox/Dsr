package com.dj.bms.modules.menu.ui;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.dj.bms.common.ui.AbstractListTag;
import com.dj.bms.common.ui.support.TableTagTdSupport;
import com.dj.bms.common.ui.support.TableTagThSupport;
import com.dj.bms.common.ui.util.HtmlElementUtils;
import com.dj.bms.modules.menu.vo.MenuVO;

/**
 * 侧边栏 List 标签
 * 
 * @author zcq
 * @date 2020-03-14
 */
@SuppressWarnings("serial")
public class SidebarListTag extends AbstractListTag {

	@Override
	protected TableTagThSupport getTableTagThSupport() {
		return () -> "操作";
	}

	@Override
	protected TableTagTdSupport getTableTagTdSupport() {
		String contextPath = super.getContextPath();
		HttpServletRequest request = (HttpServletRequest) super.pageContext.getRequest();
		String dialog = request.getParameter("dialog");
		return object -> {
			StringBuilder sb = new StringBuilder();
			MenuVO menuVO = (MenuVO) object;
			if (Objects.equals(dialog, "true")) {
				sb.append("<a href=\"javascript:void(0);\" onclick=\"selectSidebar(\""+menuVO.getMenuId()+"\",\""+menuVO.getMenuName()+"\")\" class=\"btn btn-xs btn-primary\">选择</a>");
				sb.append("\t\n");
				sb.append(HtmlElementUtils.convertScript("function selectSidebar(){parent.$('#parentSidebarId').val(id);parent.$('#parentSidebarName').val(name);parent.bootbox.hideAll();}"));
			} else {
				String editPath = contextPath + "/admin/sidebar/edit?id=" + menuVO.getMenuId();
				String removePath = contextPath + "/admin/sidebar/remove?id="+ menuVO.getMenuId();
				sb.append("<a href=\"javascript:void(0);\" onclick=\"dialog.href('"+ editPath +"', 'bms-iframe')\" class=\"btn btn-xs btn-warning\">编辑</a>");
				sb.append("\t\n");
				sb.append("<a href=\"javascript:void(0);\" onclick=\"dialog.deleteConfirm('"+ removePath +"')\" class=\"btn btn-xs btn-danger\">删除</a>");
			}
			return sb.toString();
		};
	}

}
