layui.use(['layer', 'form', 'table', 'admin', 'ax', 'laydate'], function () {
    var $ = layui.$;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var laydate = layui.laydate;

   
    var Resource = {
        tableId: "resourceTable"    // 表格id
    };

    /**
	 * 初始化表格的列
	 */
    Resource.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, sort: true, title: 'id'},
            {field: 'roleID', sort: true, title: '角色ID'},
            {field: 'typeDesc', sort: true, title: '资源类型'},
            {field: 'resourceID', sort: true, title: '资源ID'},
            {field: 'resourceName', sort: true, title: '资源名称'},
            {field: 'count', sort: true, title: '数量'},
            {field: 'change', sort: true, title: '流水值'},
            {field: 'bill', sort: true, title: '流水类型'},
            {field: 'desc', sort: true, title: '说明'},
            {field: 'logTime', sort: true, title: '时间'},
        ]];
    };

    /**
	 * 点击查询按钮
	 */
    Resource.search = function () {
        var queryData = {};
        queryData['roleID'] = $("#roleID").val();
        table.reload(Resource.tableId, {where: queryData});
    };
    
    //渲染时间选择框
    laydate.render({
        elem: '#date'
    });

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + Resource.tableId,
        url: Feng.ctxPath + '/gameLog/resourceBillList',
        page: true,
        height: "full-98",
        cellMinWidth: 100,
        cols: Resource.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        Resource.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
		        Resource.openAddResource();
	});

});
