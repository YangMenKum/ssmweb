/**查询demo
 * @author by yangkun
 * @date 2018/7/9 0009 下午 9:44
 * @Description
 */
$(document).ready(function () {
    $("#usertable").bootstrapTable({
        url: "/ssmweb/user/userTable.do",
        method: "post",
        striped: true,			              //奇偶行渐色表（*）
        pagination: true,                   //是否显示分页（*）
        sidePagination: "server",          //分页方式：client客户端分页，server服务端分页（*）
        pageSize: 2,                        //每页的记录行数（*）
        pageList: [2,5, 10, 15, 20],        //可供选择的每页的行数（*）
        dataType: "json",                  //指定数据传输类型是json格式（*）
        queryParams: function (params) {
            return {
                limit: params.limit,   //页面大小
                offset: params.offset, //页码
                others: 'test'        // 其他参数
            };
        },
        columns: [
            {
                title: 'id',
                field: 'id'
            }, {
                title: 'email',
                field: 'email'
            }, {
                title: 'username',
                field: 'username'
            }, {
                title: 'regTime',
                field: 'regTime'
            }, {
                title: 'regIp',
                field: 'regIp'
            }]
    });
});