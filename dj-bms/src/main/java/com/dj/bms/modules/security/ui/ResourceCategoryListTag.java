package com.dj.bms.modules.security.ui;

import com.dj.bms.common.ui.AbstractListTag;
import com.dj.bms.common.ui.support.TableTagTdSupport;
import com.dj.bms.common.ui.support.TableTagThSupport;
import com.dj.bms.common.ui.util.HtmlElementUtils;
import com.dj.bms.modules.security.vo.ResourceCategoryVO;
import com.dj.bms.modules.security.vo.ResourceVO;

/**
 * 资源类别 List 标签
 * 
 * @author zcq
 * @date 2020-03-14
 */
@SuppressWarnings("serial")
public class ResourceCategoryListTag extends AbstractListTag {

	@Override
	protected TableTagThSupport getTableTagThSupport() {
		return () -> "操作";
	}

	@Override
	protected TableTagTdSupport getTableTagTdSupport() {
		String contextPath = super.getContextPath();
		StringBuilder sb = new StringBuilder();
		return object -> {
			ResourceCategoryVO resourceCategoryVO = (ResourceCategoryVO) object;
			sb.append("<a href=\"" + contextPath + "/admin/security/resource/category/edit?id=" + resourceCategoryVO.getResourceCategoryId() + "\" class=\"btn btn-xs btn-warning\">编辑</a>");
			sb.append("\t\n");
			sb.append("<a href=\"javascript:void(0);\" class=\"btn btn-xs btn-danger\">删除</a>");
			sb.append("\t\n");
			String href = contextPath + "/admin/security/resource/category/remove?id= "+ resourceCategoryVO.getResourceCategoryId();
			sb.append(HtmlElementUtils.convertScript("dialog.deleteConfirm("+ href +")"));
			return sb.toString();
		};
	}

}
