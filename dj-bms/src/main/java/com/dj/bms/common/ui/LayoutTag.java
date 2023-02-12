package com.dj.bms.common.ui;

/**
 * 布局标签
 * 
 * @author zcq
 * @date 2020-03-11
 */
@SuppressWarnings("serial")
public class LayoutTag extends AbstractBaseTag {

	@Override
	protected String getBodyContentString(String bodyContent) {
		StringBuilder sb = new StringBuilder();
		sb.append("<!doctype html>");
		sb.append("\t\n");
		sb.append("<html lang=\"zh-CN\">");
		sb.append("\t\n");
		sb.append("<head>");
		sb.append("\t\n");
		sb.append("<meta charset=\"UTF-8\">");
		sb.append("\t\n");
		sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		sb.append("\t\n");
		sb.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">");
		sb.append("\t\n");
		sb.append("<title>BMS后台管理系统</title>");
		sb.append("\t\n");
		sb.append("<link rel=\"icon\" href=\""+ getContextPath() +"/admin/resource/images/favicon.ico\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + getContextPath() + "/resources/libs/bootstrap-v3.4.1/dist/css/bootstrap.min.css\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + getContextPath() + "/resources/libs/font-awesome-v4.7.0/css/font-awesome.min.css\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + getContextPath() + "/resources/libs/Ionicons-v2.0.0/css/ionicons.min.css\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + getContextPath() + "/resources/libs/AdminLTE-v2.4.18/dist/css/AdminLTE.min.css\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + getContextPath() + "/resources/libs/AdminLTE-v2.4.18/dist/css/skins/_all-skins.min.css\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + getContextPath() + "/resources/libs/bootstrap-datepicker-v1.9.0/dist/css/bootstrap-datepicker.min.css\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + getContextPath() + "/resources/libs/cropper-v3.1.3/cropper.min.css\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"" + getContextPath() + "/resources/libs/wangEditor/wangEditor.min.css\">");
		sb.append("\t\n");
		sb.append("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/libs/jquery-v3.4.1/dist/jquery.min.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/libs/bootstrap-v3.4.1/dist/js/bootstrap.min.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/libs/AdminLTE-v2.4.18/dist/js/adminlte.min.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/libs/bootstrap-datepicker-v1.9.0/dist/js/bootstrap-datepicker.min.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/libs/bootstrap-paginator-1.0.2/bootstrap-paginator.min.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/libs/bootbox-v5.3.2/bootbox.min.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/libs/cropper-v3.1.3/cropper.min.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/libs/wangEditor/wangEditor.min.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/js/dialog.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/js/list.js\"></script>");
		sb.append("\t\n");
		sb.append("<script src=\"" + getContextPath() + "/resources/js/avatar.js\"></script>");
		sb.append("\t\n");
		sb.append("</head>");
		sb.append("\t\n");
		sb.append("<body class=\"hold-transition skin-blue sidebar-mini\">");
		sb.append("\t\n");
		sb.append("<div class=\"wrapper\">");
		sb.append("\t\n");
		sb.append(bodyContent);
		sb.append("\t\n");
		sb.append("</div>");
		sb.append("\t\n");
		sb.append("</body>");
		sb.append("\t\n");
		sb.append("</html>");
		return sb.toString();
	}
	
}
