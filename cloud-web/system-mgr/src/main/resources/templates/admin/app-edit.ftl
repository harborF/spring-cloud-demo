<#include "../inc/_meta.ftl">
  <title>编辑模块</title>
 </head> 
 <body>
 <article class="page-container">
     <form class="form form-horizontal" id="form-app-edit" action="/admin/app-save.html">
         <input type="hidden" name="id" value="${(app.appId)!}"/>
         <div class="row cl">
             <label class="form-label col-xs-4 col-sm-3">模块名</label>
             <div class="formControls col-xs-8 col-sm-9">
                 <input type="text" name="appName" value="${(app.appName)!}" placeholder="中文、字母、数字、下划线" lay-verify="required" class="input-text">
             </div>
         </div>
         <div class="row cl">
             <label class="form-label col-xs-4 col-sm-3">模块标识</label>
             <div class="formControls col-xs-8 col-sm-9">
                 <input type="text" class="input-text" readonly="readonly">
             </div>
         </div>
         <div class="row cl">
             <label class="form-label col-xs-4 col-sm-3">模块路由</label>
             <div class="formControls col-xs-8 col-sm-9">
                 <input type="text" name="routeName" placeholder="api转发路径" class="input-text">
             </div>
         </div>
         <div class="row cl">
             <label class="form-label col-xs-4 col-sm-3">内部模块</label>
             <div class="formControls col-xs-8 col-sm-9">
                 <input type="checkbox" name="internal" value="true" lay-skin="switch" lay-text="否|是"/>
             </div>
         </div>
         <div class="row cl">
             <label class="form-label col-xs-4 col-sm-3">可跨域uris</label>
             <div class="formControls col-xs-8 col-sm-9">
                 <input type="text" name="corsUris" placeholder="可跨域uris(多个;隔开)" class="input-text">
             </div>
         </div>
         <div class="row cl">
             <label class="form-label col-xs-4 col-sm-3">API地址</label>
             <div class="formControls col-xs-8 col-sm-9">
                 <input type="text" name="apidocUrl" placeholder="Swagger API地址" class="input-text">
             </div>
         </div>

         <div class="row cl">
             <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                 <input type="submit" id="btnSubmit" class="btn btn-primary radius" value="保存"/>
                 <input type="reset" class="btn btn-primary radius" value="重置"/>
             </div>
         </div>
     </form>
 </article>
 </body>
<#include "../inc/_footer.ftl">
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
</script>
</html>