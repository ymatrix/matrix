<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="common/jquery-easyui-1.3.5/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="common/jquery-easyui-1.3.5/themes/icon.css">
	<script type="text/javascript" src="common/jquery-easyui-1.3.5/jquery.min.js"></script>
	<script type="text/javascript" src="common/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
  </head>
</html>