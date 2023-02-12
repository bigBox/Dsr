layui.use(['layer', 'form', 'table', 'admin', 'ax', 'laydate'], function () {
    var $ = layui.$;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var laydate = layui.laydate;

 // 表格id
    var item1 = {
        tableId: "item1"    
    };
    var item2 = {
    		tableId: "item2" 
    };
    var item3 = {
    		tableId: "item3" 
    };
    var item4 = {
    		tableId: "item4" 
    };
    var item5 = {
    		tableId: "item5" 
    };
    var item6 = {
    		tableId: "item6" 
    };
    var item100 = {
    		tableId: "item100" 
    };

    /**
	 * 初始化表格的列
	 */
    item1.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'ItemId', sort: true, title: '道具ID'},
            {field: 'ItemName', sort: true, title: '道具名称'},
            {field: 'Count', sort: true, title: '数量'},
        ]];
    };
    item2.initColumn = function () {
    	return [[
    		{type: 'checkbox'},
    		{field: 'ItemId', sort: true, title: '道具ID'},
    		{field: 'ItemName', sort: true, title: '道具名称'},
    		{field: 'Count', sort: true, title: '数量'},
    		]];
    };
    item3.initColumn = function () {
    	return [[
    		{type: 'checkbox'},
    		{field: 'ItemId', sort: true, title: '道具ID'},
    		{field: 'ItemName', sort: true, title: '道具名称'},
    		{field: 'Count', sort: true, title: '数量'},
    		]];
    };
    item4.initColumn = function () {
    	return [[
    		{type: 'checkbox'},
    		{field: 'ItemId', sort: true, title: '道具ID'},
    		{field: 'ItemName', sort: true, title: '道具名称'},
    		{field: 'Count', sort: true, title: '数量'},
    		]];
    };
    item5.initColumn = function () {
    	return [[
    		{type: 'checkbox'},
    		{field: 'ItemId', sort: true, title: '道具ID'},
    		{field: 'ItemName', sort: true, title: '道具名称'},
    		{field: 'Count', sort: true, title: '数量'},
    		]];
    };
    item6.initColumn = function () {
    	return [[
    		{type: 'checkbox'},
    		{field: 'ItemId', sort: true, title: '道具ID'},
    		{field: 'ItemName', sort: true, title: '道具名称'},
    		{field: 'Count', sort: true, title: '数量'},
    		]];
    };
    item100.initColumn = function () {
    	return [[
    		{type: 'checkbox'},
    		{field: 'ItemId', sort: true, title: '道具ID'},
    		{field: 'ItemName', sort: true, title: '道具名称'},
    		{field: 'Count', sort: true, title: '数量'},
    		]];
    };
    
    /**
	 * 点击查询按钮
	 */
    item1.search = function () {
        var queryData = {};
        queryData['roleID'] = $("#roleID").val();
        queryData['col'] = 1;
        table.reload(item1.tableId, {where: queryData});
    };
    item2.search = function () {
    	var queryData = {};
    	queryData['roleID'] = $("#roleID").val();
    	queryData['col'] = 2;
    	table.reload(item2.tableId, {where: queryData});
    };
    item3.search = function () {
    	var queryData = {};
    	queryData['roleID'] = $("#roleID").val();
    	queryData['col'] = 3;
    	table.reload(item3.tableId, {where: queryData});
    };
    item4.search = function () {
    	var queryData = {};
    	queryData['roleID'] = $("#roleID").val();
    	queryData['col'] = 4;
    	table.reload(item4.tableId, {where: queryData});
    };
    item5.search = function () {
    	var queryData = {};
    	queryData['roleID'] = $("#roleID").val();
    	queryData['col'] = 5;
    	table.reload(item5.tableId, {where: queryData});
    };
    item6.search = function () {
    	var queryData = {};
    	queryData['roleID'] = $("#roleID").val();
    	queryData['col'] = 6;
    	table.reload(item6.tableId, {where: queryData});
    };
    item100.search = function () {
    	var queryData = {};
    	queryData['roleID'] = $("#roleID").val();
    	queryData['col'] = 100;
    	table.reload(item100.tableId, {where: queryData});
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + item1.tableId,
        url: Feng.ctxPath + "/player/readItem",
        page: false,
        height: "full-98",
        cellMinWidth: 100,
        cols: item1.initColumn()
    });
    var tableResult = table.render({
    	elem: '#' + item2.tableId,
    	url: Feng.ctxPath + "/player/readItem",
    	page: false,
    	height: "full-98",
    	cellMinWidth: 100,
    	cols: item2.initColumn()
    });
    var tableResult = table.render({
    	elem: '#' + item3.tableId,
    	url: Feng.ctxPath + "/player/readItem",
    	page: false,
    	height: "full-98",
    	cellMinWidth: 100,
    	cols: item3.initColumn()
    });
    var tableResult = table.render({
    	elem: '#' + item4.tableId,
    	url: Feng.ctxPath + "/player/readItem",
    	page: false,
    	height: "full-98",
    	cellMinWidth: 100,
    	cols: item4.initColumn()
    });
    var tableResult = table.render({
    	elem: '#' + item5.tableId,
    	url: Feng.ctxPath + "/player/readItem",
    	page: false,
    	height: "full-98",
    	cellMinWidth: 100,
    	cols: item5.initColumn()
    });
    var tableResult = table.render({
    	elem: '#' + item6.tableId,
    	url: Feng.ctxPath + "/player/readItem",
    	page: false,
    	height: "full-98",
    	cellMinWidth: 100,
    	cols: item6.initColumn()
    });
    var tableResult = table.render({
    	elem: '#' + item100.tableId,
    	url: Feng.ctxPath + "/player/readItem",
    	page: false,
    	height: "full-98",
    	cellMinWidth: 100,
    	cols: item100.initColumn()
    });

    
    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
    	item1.search();
    	item2.search();
    	item3.search();
    	item4.search();
    	item5.search();
    	item6.search();
    	item100.search();
    });
});
