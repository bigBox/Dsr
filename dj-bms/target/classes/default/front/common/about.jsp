<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<div class="row">
    <div class="col-md-9">
        <div class="panel panel-default">
            <div class="panel-heading">
                <a href="/">主页</a> / About
            </div>
            <div class="panel-body" style="color: #333;">
                <h1 style="margin-top: 0px;">About BMS</h1>
                <br>BMS 是技术与资讯的社区，您可以在这里发表自己正在做的有趣事物。
                <br>
                <br>为了保持这里的良好氛围，BMS 有自己的明确规则：
                <br>
                <br>• 禁止分享或讨论任何涉及版权盗用的内容
                <br>
                <br>• 禁止未经原作者授权的内容转载
                <br>
                <br>• 虽不反对水贴，但也请尽量不要水贴
                <br>
                <br>• 尊重和鼓励原创
                <br>
                <br>• 分享自己见解的同时请对他人保持友善
                <br>
                <br>• 这里禁止发布人身攻击、仇恨、暴力、侮辱性的言辞、暴露他人隐私的“人肉贴”
                <br>
                <br>• 遵守中国的法律
                <br>
                <br>为了获得访问 BMS 的最佳体验，我们推荐使用 <a href="http://chrome.google.com/" target="_blank">Google Chrome</a> 或
                <a href="http://www.getfirefox.com/" target="_blank">Mozilla Firefox</a> 浏览器。
            </div>
        </div>
    </div>
</div>
<%@ include file="../layout/footer.jsp" %>