<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
  <link rel="stylesheet" href="/layui/css/layui.css">
  <!--https://www.layui.com/demo/admin.html-->
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">layui 后台布局</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
    	<#list appMenuList as vo>
            <li class="layui-nav-item"><a href="javascript:;">${vo.appName}</a></li>
        </#list>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
    <#list appMenuList as vo>
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
      <#list vo.childrenRes as voo>
        <#if voo.childrenRes??>
          <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">${voo.resTitle}</a>
            <dl class="layui-nav-child">
              <#list voo.childrenRes as leaf>
                  <dd><a href="${leaf.resUrl!}">${leaf.resTitle}</a></dd>
              </#list>
            </dl>
          </li>
        </#if>
      </#list>
      </ul>
    </#list>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">内容主体区域</div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
<script src="/layui/layui.all.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>
