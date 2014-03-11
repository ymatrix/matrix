<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<title>后台登陆页面</title>
	<%@ include file="../common/header.jsp"%> 
	
	<script>
		$(function(){
			$('#win').window({
				title:'管理员登录',
				width:400,
				height:240,
				collapsible:false,
				minimizable:false,
				maximizable:false,
				resizable:false,
				modal:true
			});
			
			$('input').keydown(function(e){
				if(e.keyCode==13){
					loginFormSubmit();
				}
			});
		})
		
		function loginFormSubmit() {
			$('#loginForm').form('submit', {
			    url:"AdminAction/login.do",
			    onSubmit: function(){
			        // do some check
			        // return false to prevent submit;
			        if($("[name='username']").val()==""){
			        	$("#tip").html("用户名不允许为空！");
			        	return false;
			        }
			        if($("[name='password']").val()==""){
			        	$("#tip").html("密码不允许为空！");
			        	return false;
			        }
			        if($("[name='randcode']").val()==""){
			        	$("#tip").html("验证码不允许为空！");
			        	return false;
			        }
			    },
			    success:function(data){
			    	 var result = eval('('+data+')');
	                 if (result.success){
	                	 location.href = "admin/index.jsp";
	                 }else{
	                	 $("#tip").html(result.msg);
	                 } 
			    }
			});
		}
	</script>
	<style type="text/css">
		body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td{margin:0;padding:0;}
		table{border-collapse:collapse;border-spacing:0;}
		body, button, input, select, textarea {font:12px/1.5 "\5B8B\4F53",Tahoma,arial;}
		fieldset,img,button{border:none;}
		img,input,select{vertical-align:middle;}
		ol,ul{list-style:none;}
		caption,th{text-align:left;}
		h1,h2,h3,h4,h5,h6{font-size:100%;font-weight:normal;}
		q:bofore,q:after{content:"";}
		abbr,acronym{border:0;}
		.UserForm{padding:20px;}
		.UserForm fieldset{border:1px solid #ccc;}
		.UserForm fieldset legend{font-size:13px;color:#444;font-weight:bold; border: 1px solid #D8D8D8;margin-left:10px;padding:2px 5px;background-color: #F9F9F9;}
		.UserForm ul{padding:10px 0;}
		.UserForm ul li{height:35px;line-height:35px;}
		.UserForm ul li strong{font-weight:normal;display:inline-block;width:80px;padding-right:10px;text-align:right;}
		.UserForm ul li div{display: inline;}
		.Formtext{background:no-repeat scroll left top #FFFFFF;border:1px solid #A7A6AA;height: 23px;padding: 1px 2px;line-height: 24px;width:160px;margin-right:5px;}
		.Formtext:focus{ background-color:#FFFFD9;}
		.fl{float:left;display:inline;}
		.fr{float:right;display:inline;}
		.hidden{display:none;}
		.clr{clear:both;height:0;font-size:0;line-height:0;}
		.ml5{margin-left:5px;}
		.ml10{margin-left:10px;}
		.mt10{margin-top:10px;}
		.mb10{margin-bottom:10px;}
	</style>
  </head>
  
  <body>
	  <div id="win" iconCls="icon-ok" title="My Window">  
	  	 <div class="easyui-layout" fit="true">
			<div region="center" border="false" class="UserForm" style="padding:10px;background:#fff;">
			  <form id="loginForm" method="post">
				 <ul>
				  <li><strong>用户名:</strong><input type="text" class="Formtext" name="username"/></li>
		       	  <li><strong>密码:</strong><input type="password" class="Formtext" name="password"/></li>
		          <li><strong>验证码:</strong><input name="randcode" class="Formtext" type="text"/><a href="javascript:void(0)" onclick="document.getElementById('imgVcode').src='<%=basePath%>ValidateCodeAction/validate.do?' + (new Date()).getTime();" title="看不清？点击更换验证码"><img src="ValidateCodeAction/validate.do" id="imgVcode" height="30" width="70" alt="看不清？点击更换验证码" /></a></li> 
			 	 </ul>
			  </form>
			  <div id="tip" style="margin-left:90px;color:red">&nbsp</div>
			  <div class="fr mt10 toolbar">
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="loginFormSubmit()" iconCls="icon-ok">登录</a>
			  	<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
			  </div>
			</div>
		 </div>
	  </div>  
 
  </body>
</html>