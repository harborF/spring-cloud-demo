<#include "../inc/_meta.ftl">
<title>角色管理</title>
</head>
<body>
<div class="page-container">
<form class="form form-horizontal" id="form" action="/admin/assign-menu-save.html">
    <input type="hidden" name="roleId" id="roleId"/>
    <dl class="row cl">
    <#list menuList as vo>
        <dl class="permission-list">
            <dt>
                <label><input type="checkbox" value="">${vo.resTitle}</label>
            </dt>
            <dd>
                <#if vo.childrenRes??>
                <#list vo.childrenRes as vvo>
                <dl class="cl permission-list2">
                    <dt>
                        <label class="">
                            <input type="checkbox" value="${vvo.treeId}" <#if (vvo.roleId)??>checked</#if>>${vvo.resTitle}</label>
                    </dt>
                    <dd>
                        <label class=""><input type="checkbox" value="1" name="add">添加</label>
                        <label class=""><input type="checkbox" value="2" name="update">修改</label>
                        <label class=""><input type="checkbox" value="3" name="delete">删除</label>
                        <label class=""><input type="checkbox" value="4" name="view">查看</label>
                        <label class=""><input type="checkbox" value="5" name="verify">审核</label>
                    </dd>
                </dl>
                </#list>
                </#if>
            </dd>
        </dl>
    </#list>
    </div>

    <div class="row cl">
        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
            <button type="submit" class="btn btn-success radius" id="btnSave"><i class="icon-ok"></i> 确定</button>
        </div>
    </div>
</form>
</div>
</body>
<#include "../inc/_footer.ftl">
<script type="text/javascript" src="/h-lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="/h-lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="/h-lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $(function(){
        $(".permission-list dt input:checkbox").click(function(){
            $(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function(){
            var l =$(this).parent().parent().find("input:checked").length;
            var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if($(this).prop("checked")){
                $(this).closest("dl").find("dt input:checkbox").prop("checked",true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
            }
            else{
                if(l==0){
                    $(this).closest("dl").find("dt input:checkbox").prop("checked",false);
                }
                if(l2==0){
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
                }
            }
        });

        $("#form").validate({
            rules:{
                roleName:{
                    required:true,
                },
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $.postJson($("#form").attr('action'), serializeReqData(), function (result) {
                    if (result.code == 0){
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                    }else {
                        alert(result.msg);
                    }
                });
            }
        });
    });

    function serializeReqData() {
        var jsReqData = [];
        $(".permission-list dt input:checkbox:checked").each(function (idx, item) {
            var permList = [];
            $(this).parents(".permission-list").find("dd").find("input:checkbox:checked").each(function (n, value) {
                permList.push($(this).val());
            });
            jsReqData.push({authKey: $(this).val(), permList: permList});
        });

        return JSON.stringify({roleId: $("#roleId").val(), permList:jsReqData});
    }
</script>
</html>