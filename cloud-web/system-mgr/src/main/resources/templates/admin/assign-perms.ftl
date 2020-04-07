<#include "../inc/_meta.ftl">
<title>角色管理</title>
</head>
<body>
	<form class="layui-form" action="/api/role/assignment">  
	   <input type="hidden" name="roleId" id="idinput" />
	   <input type="hidden" name="type" value="uri" />
	   <div id="options" dataLoad="/api/resource/role_relations?type=uri&roleId={id}" template-id="option_tpl" onFinishCallback="onDataLoadFinish">
	   </div>
		<div class="layui-form-item"> 
          <div class="layui-input-block" style="padding: right:30px;"> 
           <input type="button"  class="layui-btn layui-btn-normal J_ajaxSubmit" value="保存"/>
          </div> 
    </div> 
	</form>
</body>
<#include "../inc/_footer.ftl">

<script type="text/html" id="option_tpl">
	{{# layui.each(d, function(index, item){ }}
       <fieldset class="layui-elem-field">
			<legend>{{ item.moduleName }}</legend>
			<ul class="layui-field-box layui-form option-items">
                {{# layui.each(item.roleResources, function(index, item2){ }}
				<li>
                  <input type="checkbox" name="assignmentIds" value="{{item2.id}}" lay-skin="primary" title="{{item2.name}}" {{item2.assigned ? 'checked' : ''}}>
                </li>
                {{# }); }}
			</ul>
		</fieldset>
	{{# }); }}
</script>
<script type="text/javascript" src="../../assets/js/layui/layui.js"></script>
<script>
	layui.config({
		version : "1.0.0",
		base : '../../assets/js/modules/'
	}).use('role');
	
	function onDataLoadFinish(data){
		layui.form.render('checkbox');
		var id = layui.oneplatform.getQueryParams('id');
		layui.jquery('#idinput').val(id);
	}
</script>

</html>