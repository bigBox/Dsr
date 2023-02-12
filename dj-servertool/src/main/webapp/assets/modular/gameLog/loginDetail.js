layui.use(['layer', 'form', 'table', 'admin', 'ax', 'laydate'], function () {
    var $ = layui.$;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var laydate = layui.laydate;

   
    var TableID = {
        tableId: "TableIDTable"    // 表格id
    };

    /**
	 * 初始化表格的列
	 */
    TableID.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, sort: true, title: 'id'},
            {field: 'roleID', sort: true, title: '角色ID'},
            {field: 'account', sort: true, title: '账号'},
            {field: 'password', sort: true, title: '密码'},
            {field: 'ip', sort: true, title: 'ip'},
            {field: 'type', sort: true, title: '类型'},
            {field: 'logTime', sort: true, title: '时间'},
        ]];
    };

    /**
	 * 点击查询按钮
	 */
    TableID.search = function () {
        var queryData = {};
        queryData['roleID'] = $("#roleID").val();
        table.reload(TableID.tableId, {where: queryData});
    };
    
    //渲染时间选择框
    laydate.render({
        elem: '#date'
    });

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + TableID.tableId,
        url: Feng.ctxPath + '/gameLog/TableIDDetailList',
        page: true,
        height: "full-98",
        cellMinWidth: 100,
        cols: TableID.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        TableID.search();
    });

});
