<#include "../inc/_meta.ftl">
<title>权限管理</title>
<link rel="stylesheet" href="/h-lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 权限管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<table class="table">
    <tr>
        <td width="200" class="va-t"><ul id="perm-tree" class="ztree"></ul></td>
        <td class="va-t">
            <iframe id="permIFrame" Name="permIFrame" FRAMEBORDER=0 SCROLLING=AUTO width=100% height=390px SRC="/admin/perm-edit.html"></iframe>
        </td>
    </tr>
</table>
</body>
<#include "../inc/_footer.ftl">
<script type="text/javascript" src="/h-lib/zTree/v3/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript">
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: true,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable:true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: function(treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("perm-tree");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode,true,true,true);
                    $("#permIFrame").attr("src","/admin/perm-edit.html?id="+treeNode.id);
                    return false;
                } else {
                    $("#permIFrame").attr("src","/admin/perm-edit.html?id="+treeNode.id);
                    return true;
                }
            }
        }
    };

    $(function(){
        $.fn.zTree.init($("#perm-tree"), setting, getPermTree());
    });

    function getPermTree() {
        var treeNodes = [];
        $.ajax({
            url: "/admin/menu-tree.html?type=perm", async: false, success: function (result) {
                $.each(result.data, function (i, field) {
                    treeNodes.push({"id": field.treeId, "name": field.resTitle, "pId": field.parentId, "open": field.parentId==0});
                });
            }, dataType: 'json'
        });
        return treeNodes;
    }
</script>
</html>
