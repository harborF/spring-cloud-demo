<#include "../inc/_meta.ftl">
<title>新增权限</title>
</head>
<body>
<div class="page-container">
    <form class="form form-horizontal" action="/admin/perm-save.html">
        <input type="hidden" value="${(perm.treeId!)}">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">权限类型</label>
            <div class="formControls col-xs-6 col-sm-6">
                <input type="radio" name="type" value="uri" title="接口" checked="">接口
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">所属模块</label>
            <div class="formControls col-xs-6 col-sm-6">
                <select id="moduleId" name="moduleId" lay-verify="required" asnycSelect="/api/module/options" lay-filter="module_select">
                    <option value="">请选择模块</option>
                </select>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">选择接口</label>
            <div class="formControls col-xs-6 col-sm-6">
                <select id="name_select" lay-filter="name_select">
                    <option value="">请选择接口</option>
                </select>
            </div>
        </div>
        <div class="row cl">
            <label id="code_label" class="form-label col-xs-4 col-sm-2">接口名称</label>
            <div class="formControls col-xs-6 col-sm-6">
                <input type="text" id="nameinput" class="input-text" name="name" placeholder="请输入权限名称"/>
            </div>
        </div>
        <div class="row cl">
            <label id="code_label" class="form-label col-xs-4 col-sm-2">接口链接</label>
            <div class="formControls col-xs-6 col-sm-6">
                <input type="text" id="resourceinput" class="input-text" name="resource" placeholder="请输入接口链接,可以使用通配符,如:/user/*"/>
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
                if(result.code == 0){
                    alert("成功");

                    var index = parent.layer.getFrameIndex(window.name);
					parent.$('.btn-refresh').click();
					parent.layer.close(index);
                }else {
                    alert(result.msg);
                }
            });
        });
    });

    layui.config({
        version: "1.0.0",
        base: '../../assets/js/modules/'
    }).use('resource', function () {
        layui.form.on('radio(type)', function (data) {
            var $ = layui.jquery;
            if (data.value === 'uri') {
                $('#code_label').html('接口链接');
            } else {
                $('#code_label').html('权限编码');
            }
        });
    });
</script>
</html>