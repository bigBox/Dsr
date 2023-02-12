layui.use([ 'layer', 'form', 'admin', 'laydate', 'ax' ], function() {
	var $ = layui.jquery;
	var $ax = layui.ax;
	var form = layui.form;
	var admin = layui.admin;
	var laydate = layui.laydate;
	var layer = layui.layer;
	// 保存按钮点击事件
	$('#btnShutdown').click(function() {
		var ajax = new $ax(Feng.ctxPath + "/system/shutdown_server");
		var result = ajax.start();
		if(result != null && result == ""){
			alert("停服成功");
		}
	});

});