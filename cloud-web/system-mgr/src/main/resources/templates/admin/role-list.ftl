<#include "../inc/_meta.ftl">
<title>角色管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 角色管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray">
		<span class="l">
			<a class="btn btn-primary radius" href="javascript:;" onclick="layer_show('添加角色','/admin/role-edit.html','800')"><i class="Hui-iconfont">&#xe600;</i> 添加角色</a>
		</span>
		<span class="r">共有数据：<strong>${roleList?size}</strong> 条</span> </div>
	<table class="table table-border table-bordered table-hover table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="6">角色管理</th>
			</tr>
			<tr class="text-c">
				<th width="40">ID</th>
				<th width="10%">角色名</th>
				<th>用户列表</th>
				<th width="25%">描述</th>
				<th width="20%">操作</th>
			</tr>
		</thead>
		<tbody>
			<#list roleList as vo>
			<tr class="text-c">
				<td>${vo.roleId}</td>
				<td>${vo.roleName}</td>
				<td><a href="#">admin</a></td>
				<td>${vo.roleDesc!}</td>
				<td class="f-14">
                    <a title="分配菜单" href="javascript:;" onclick="layer_show('分配菜单','/admin/assign-menu.html?id=${vo.roleId}')" style="text-decoration:none"><i class="Hui-iconfont">分配菜单</i></a>
                    <a title="分配权限" href="javascript:;" onclick="layer_show('分配权限','/admin/assign-perms.html?id=${vo.roleId}')" style="text-decoration:none"><i class="Hui-iconfont">分配权限</i></a>
                    <a title="禁用" href="javascript:;" onclick="admin_role_del('禁用','/admin/role-edit.html')" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>
                    <a title="编辑" href="javascript:;" onclick="layer_show('角色编辑','/admin/role-edit.html?id=${vo.roleId}')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
					<a title="删除" href="javascript:;" onclick="admin_role_del(this,'1')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
			</#list>
		</tbody>
	</table>
</div>
<#include "../inc/_footer.ftl">

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="/h-lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript">
    $(function(){
        $('.table').dataTable({
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable":false,"aTargets":[0]}// 制定列不参与排序
            ]
        });

    });

/*管理员-角色-删除*/
function admin_role_del(obj,id){
	layer.confirm('角色删除须谨慎，确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
</script>
</body>
</html>