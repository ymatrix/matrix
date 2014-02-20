<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>后台登陆页面</title>
	<%@ include file="../common/header.jsp"%> 
    <link rel="stylesheet" type="text/css" href="common/css/all.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script>
		$(function(){
			$('#win').window({
				title:'管理员登录',
				width:400,
				height:230,
				collapsible:false,
				minimizable:false,
				maximizable:false,
				resizable:false,
				modal:true
			});
		})
		function loginFormSubmit() {
			$('#loginForm').form('submit', {
				url : 'adminAction!validateLogin.action'
			});
		}
	</script>
  </head>
  
  <body>
	  <div id="win" iconCls="icon-save" title="My Window">  
	  	 <div class="easyui-layout" fit="true">
			<div region="center" border="false" class="UserForm" style="padding:10px;background:#fff;">
			  <form id="loginForm" method="post">
				 <ul>
				  <li><strong>用户名:</strong><input type="text" class="Formtext" name="name"/></li>
		       	  <li><strong>密码:</strong><input type="password" class="Formtext" name="password"/></li>
		          <li><strong>验证码:</strong><input name="randcode" class="Formtext" type="text"/><a href="javascript:void(0)" onclick="document.getElementById('imgVcode').src='<%=basePath%>ValidateCodeAction.action?' + (new Date()).getTime();" title="看不清？点击更换验证码"><img src="ValidateCodeAction.action" id="imgVcode" height="30" width="70" alt="看不清？点击更换验证码" /></a></li> 
			 	 </ul>
			  </form>
			  <div class="fr mt10 toolbar">
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="loginFormSubmit()" iconCls="icon-ok">登录</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
			  </div>
			</div>
		 </div>
	  </div>  
 
  </body>
</html>
