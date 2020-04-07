<#include "../inc/_meta.ftl">
<title>菜单管理</title>
<link rel="stylesheet" href="/h-lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
</head>
<body>
 <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员管理 <span class="c-gray en">&gt;</span> 菜单管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
 <table class="table">
     <tr>
         <td width="200" class="va-t"><ul id="menu-tree" class="ztree"></ul></td>
         <td class="va-t">
             <iframe id="menuIFrame" Name="menuIFrame" FRAMEBORDER=0 SCROLLING=AUTO width=100% height=390px SRC="/admin/menu-edit.html"></iframe>
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
            showLine: false,
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
                var zTree = $.fn.zTree.getZTreeObj("menu-tree");
                if (treeNode.isParent) {
                    zTree.expandNode(treeNode,true,true,true);
                    $("#menuIFrame").attr("src","/admin/menu-edit.html");
                    return false;
                } else {
                    $("#menuIFrame").attr("src","/admin/menu-edit.html?id="+treeNode.id);
                    return true;
                }
            }
        }
    };

    $(function(){
        $.fn.zTree.init($("#menu-tree"), setting, getMenuTree());
    });

    function getMenuTree() {
        var treeNodes = [];
        $.ajax({
            url: "/admin/menu-tree.html", async: false, success: function (result) {
                $.each(result.data, function (i, field) {
                    treeNodes.push({"id": field.treeId, "name": field.resTitle, "pId": field.parentId, "open": i==0});
                });
            }, dataType: 'json'
        });
        return treeNodes;
    }
</script>
</html>
