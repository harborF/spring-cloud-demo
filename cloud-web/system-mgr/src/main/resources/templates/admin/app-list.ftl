<#include "../inc/_meta.ftl">
<title>模块列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 模块列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
		<a href="javascript:;" onclick="admin_add('添加模块','/admin/app-edit.html','800','500')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加模块</a>
		</span>
        <span class="r">共有数据：<strong>${appList?size}</strong> 条</span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th scope="col" colspan="9">员工列表</th>
        </tr>
        <tr class="text-c">
            <th width="40">ID</th>
            <th width="150">模块名</th>
            <th width="130">加入时间</th>
            <th width="100">是否已启用</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
			<#list appList as vo>
            <tr class="text-c">
                <td>${vo.appId}</td>
                <td>${vo.appName}</td>
                <td>${vo.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td class="td-status"><span class="label label-success radius">已启用</span></td>
                <td class="td-manage"><a style="text-decoration:none" onClick="admin_stop(this,${vo.appId})" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>
                    <a title="编辑" href="javascript:;" onclick="admin_edit('管理员编辑','/admin/app-edit.html?id=${vo.appId}','800','500')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</body>
<#include "../inc/_footer.ftl">

<script type="text/javascript" src="/h-lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="/h-lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/h-lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    function admin_add(title,url,w,h){
        layer_show(title,url,w,h);
    }

    function admin_edit(title,url,w,h){
        layer_show(title,url,w,h);
    }

    function admin_stop(obj,id){
        layer.confirm('确认要停用吗？',function(index){
            //此处请求后台程序，下方是成功后的前台处理……

            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_start(this,id)" href="javascript:;" title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已禁用</span>');
            $(obj).remove();
            layer.msg('已停用!',{icon: 5,time:1000});
        });
    }

    /*管理员-启用*/
    function admin_start(obj,id){
        layer.confirm('确认要启用吗？',function(index){
            //此处请求后台程序，下方是成功后的前台处理……


            $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,id)" href="javascript:;" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6,time:1000});
        });
    }
</script>
</html>