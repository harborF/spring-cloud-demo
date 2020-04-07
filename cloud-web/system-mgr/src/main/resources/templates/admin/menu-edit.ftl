<#include "../inc/_meta.ftl">
<title>新增菜单</title>
</head>
<body>
<div class="page-container">
    <form id="form" class="form form-horizontal" method="post" action="/admin/menu-save.html">
        <input type="hidden" name="treeId" value="${(vo.treeId)!}"/>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">新增根节点</label>
            <div class="formControls col-xs-6 col-sm-6">
                <input type="checkbox" value="true" lay-skin="switch" lay-text="是|否"/>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">所属模块</label>
            <div class="formControls col-xs-6 col-sm-6">
                <select id="moduleId" name="appId">
                    <#if appList?? && (appList?size > 0)>
                    <#list appList as voo>
                    <option value="${voo.appId}" <#if vo??&&vo.appId==voo.appId>selected</#if> >${voo.appName}</option>
                    </#list>
                    </#if>
                </select>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">父级菜单</label>
            <div class="formControls col-xs-6 col-sm-6">
                <select name="parentId" class="input-text">
                    <option value="0">根节点</option>
                    <#if menuList?? && (menuList?size > 0)>
                    <#list menuList as voo>
                    <option value="${voo.treeId}" <#if vo??&&vo.parentId==voo.treeId>selected</#if> >${voo.appName}---${voo.resTitle}</option>
                    </#list>
                    </#if>
                </select>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">菜单名称</label>
            <div class="formControls col-xs-6 col-sm-6">
                <input type="text" class="input-text" name="resTitle" placeholder="请输入菜单名称" value="${(vo.resTitle)!}"/>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">菜单链接</label>
            <div class="formControls col-xs-6 col-sm-6">
                <input type="text" class="input-text" name="resUrl" placeholder="请输入菜单链接地址" value="${(vo.resUrl)!}"/>
            </div>
        </div>

        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input type="button" id="btnSubmit" class="btn btn-primary radius" value="保存"/>
                <input type="reset" class="btn btn-primary radius" value="重置"/>
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

    $(function () {
        $("#btnSubmit").click(function () {
            $.postFormJson('form', function (result) {
                if (result.code == 0) {
                    alert("成功");

					var index = parent.layer.getFrameIndex(window.name);
					parent.$('.btn-refresh').click();
					parent.layer.close(index);
                } else {
                    alert(result.msg);
                }
            });
        });
    });
</script>
</html>
