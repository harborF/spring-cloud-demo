<!DOCTYPE html>
<html>
 <head> 
  <meta charset="UTF-8" /> 
  <title>新增员工</title> 
  <link rel="stylesheet" href="/assets/js/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="/assets/css/global.css" media="all">
  <link rel="stylesheet" href="/assets/js/font-awesome/css/font-awesome.min.css">
 </head> 
 <body> 
  <div class="admin-main">  
   <form class="layui-form" action="/employee/add">  
    <div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">姓名</label>
		<div class="formControls col-xs-8 col-sm-9">
		   <input type="text" name="name" placeholder="员工姓名" lay-verify="required" class="input-text">
		</div>
	</div> 
    <div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">手机</label>
		<div class="formControls col-xs-8 col-sm-9">
		   <input type="text" name="mobile" placeholder="手机号码" class="input-text">
		</div>
	</div>
    <div class="row cl">
		<label class="form-label col-xs-4 col-sm-3">邮箱</label>
		<div class="formControls col-xs-8 col-sm-9">
		   <input type="text" name="email" placeholder="邮箱" class="input-text">
		</div>
	</div>
	<div class="row cl">
     <label class="form-label col-xs-4 col-sm-3">所在部门</label>
     <div class="formControls col-xs-8 col-sm-9">
      <select id="departmentId" name="departmentId" lay-verify="required" asnycselect="/department/options" lay-filter="department"> <option value="">请选择部门</option> </select> 
     </div> 
    </div>
    <div class="row cl">
     <label class="form-label col-xs-4 col-sm-3">职位</label>
     <div class="formControls col-xs-8 col-sm-9">
      <select id="positionId" name="positionId" lay-verify="required" asnycselect="/position/options" lay-filter="position"> <option value="">请选择职位</option> </select> 
     </div> 
    </div>
		     
    <div class="row cl">
     <div class="formControls col-xs-8 col-sm-9">
        <input type="button"  class="layui-btn layui-btn-normal J_ajaxSubmit" value="保存"/>
        <input type="reset" class="layui-btn layui-btn-primary" value="重置"/>
     </div> 
    </div> 
   </form> 
  </div> 
 </body>
 <script type="text/javascript" src="/assets/js/layui/layui.js"></script>
<script>
    var actionType = 'employee-add';
    var API_BASE_PATH = window.top.basePathMap['organisation-service'];
	layui.config({
		version : "1.0.0",
		base : '/assets/js/modules/'
	}).use('organisation');
	
	function onFinishCallback(){
		layui.form.render('checkbox');
	}
</script>
</html>