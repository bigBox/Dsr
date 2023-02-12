layui.use([ 'layer', 'form', 'admin', 'laydate', 'ax' ], function() {
	var $ = layui.jquery;
	var $ax = layui.ax;
	var form = layui.form;
	var admin = layui.admin;
	var laydate = layui.laydate;
	var layer = layui.layer;

	// 搜索按钮点击事件
	$('#btnSearch').click(function() {
		var roleID = $("#p_roleID").val();
		// 获取用户信息
		var ajax = new $ax(Feng.ctxPath + "/player/readRole?roleID=" + roleID);
		var result = ajax.start();
		setResult(result);
	});
	
	function setResult(result){
		document.getElementById('roleID').innerHTML = result.data.roleInfo.roleId;
		$("#roleName").val(result.data.roleInfo.roleName);
		document.getElementById('level').innerHTML = result.data.roleInfo.level;
		document.getElementById('gold').innerHTML = result.data.roleInfo.gold;
		document.getElementById('diamond').innerHTML = result.data.roleInfo.diamond;
		document.getElementById('ecology').innerHTML = result.data.roleInfo.ecology;
		document.getElementById('guildId').innerHTML = result.data.roleInfo.guildId;
		document.getElementById('signature').innerHTML = result.data.roleInfo.signature;
	}
	
	// 保存按钮点击事件
	$('#btnSave').click(function() {
		var roleID = document.getElementById('roleID').innerHTML;
		if(roleID == null || roleID == ""){
			return;
		}
		var param = "roleID="+roleID;
		param += "&roleName="+$("#roleName").val();
		param += "&level="+document.getElementById('level').innerHTML;
		param += "&gold="+document.getElementById('gold').innerHTML;
		param += "&diamond="+document.getElementById('diamond').innerHTML;
		param += "&ecology="+document.getElementById('ecology').innerHTML;
		param += "&guildId="+document.getElementById('guildId').innerHTML;
		param += "&signature="+document.getElementById('signature').innerHTML;
		var ajax = new $ax(Feng.ctxPath + "/player/writeRole?" + param);
		var result = ajax.start();
		setResult(result);
		alert("保存成功");
	});

});