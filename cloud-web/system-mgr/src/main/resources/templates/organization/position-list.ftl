<!DOCTYPE html>
<html>
 <head> 
  <meta charset="UTF-8" /> 
  <title>职位管理</title> 
  <link rel="stylesheet" href="/assets/js/layui/css/layui.css" media="all" /> 
  <link rel="stylesheet" href="/assets/css/global.css" media="all" /> 
  <link rel="stylesheet" href="/assets/js/font-awesome/css/font-awesome.min.css" /> 
  <link rel="stylesheet" href="/assets/css/table.css" /> 
  <style type="text/css">
 ul{padding-left: 15px;width: 100%;float:left;}
 li{float:left;width: 19%;display: inline;height: 40px; }
</style> 
 </head> 
 <body> 
  <fieldset class="layui-elem-field"> 
   <legend>新增职位</legend> 
   <form id="addform" action="/position/add" class="layui-form" style="margin: 10px;"> 
    <div class="layui-inline"> 
     <input class="input-text" name="name" placeholder="职位名称" />
    </div> 
    <div class="layui-inline"> 
     <input type="button" class="layui-btn layui-btn-normal J_ajaxSubmit" onSuccessCallback="reloadPage"  value="新增" /> 
    </div> 
   </form> 
  </fieldset> 
  <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;"> 
   <legend>职位列表</legend> 
  </fieldset> 
  <div>
      <ul class="layui-field-box layui-form option-items" dataload="/position/list" template-id="option_tpl"></ul>
  </div>  
  <script type="text/html" id="option_tpl">
	{{# layui.each(d, function(index, item){ }}
		 <li>{{item.name}} <button class="layui-btn layui-btn-danger layui-btn-xs">删除</button></li>
	   </ul>
	{{# }); }}
</script> 
  <script type="text/javascript" src="/assets/js/layui/layui.js"></script> 
  <script>
    var API_BASE_PATH = window.top.basePathMap['organisation-service'];
	layui.config({
		version : "1.0.0",
		base : '/assets/js/'
	}).use('oneplatform');
	
	function reloadPage(data){
		setTimeout(function(){window.location.reload();},500);
	}
</script> 
 </body>
</html>