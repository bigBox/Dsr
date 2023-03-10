<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp" %>
<div class="row">
    <div class="col-md-9">
        <div class="panel panel-default">
            <div class="panel-heading">
                <a href="/">主页</a> / API
            </div>
            <div class="panel-body" style="color: #333;">
                <h2>用户的主题</h2>
                <p>
                    <strong>请求URL：</strong>
                </p>
                <ul>
                    <li><code style="color: rgb(221, 17, 68);">http://localhost:8282/api/user/topic</code></li>
                </ul>
                <p>
                    <strong>请求方式：</strong>
                </p>
                <ul>
                    <li>GET</li>
                </ul>
                <p>
                    <strong>参数：</strong>
                </p>
                <div style="width: 100%; overflow-x: auto;">
                    <table class="table table-condensed">
                        <thead>
                        <tr>
                            <th>参数名</th>
                            <th>必选</th>
                            <th>类型</th>
                            <th>说明</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>name</td>
                            <td>否</td>
                            <td>string</td>
                            <td>用户名</td>
                        </tr>
                        <tr>
                            <td>p</td>
                            <td>否</td>
                            <td>string</td>
                            <td>分页</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../layout/footer.jsp" %>