<%@page import="net.sf.ssi.domain.Log"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../Common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>日志管理</title>
<link rel="stylesheet" href="${base}/resources/css/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="${base}/resources/css/print.css" type="text/css" media="print"/>
<!--[if lt IE 8]>
<link rel="stylesheet" href="${base}/resources/css/ie.css" type="text/css" media="screen, projection"/>
<![endif]-->
<link rel="stylesheet" href="${base}/resources/css/link-icons/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="${base}/resources/css/buttons/screen.css" type="text/css" media="screen, projection"/>
<script type="text/javascript" src="${base}/resources/script/jquery-min.js"></script>
<script type="text/javascript" src="${base}/resources/script/ssi.js"></script>
<script language="javascript" type="text/javascript" src="${base}/resources/script/my97/WdatePicker.js"></script>
</head>
<body>
<div class="container">
	<div class="column span-24">
		<div class="pageheader"  style="height: 90px;">
			<h1>ikms Logo</h1>
			<h6>My Knowledge Management System &#169;version 1.0</h6>
		</div>
	</div>
	<div class="column span-24">
		<div class="pageheader">
			分页：
		</div>
	</div>
	<%
		List<Log> logs = (List<Log>)request.getAttribute("logs");
		for(int i=1;i<=logs.size();i++){
	%>
	<div class="column span-24">
		<div class="pagecontent" style="height: 40px;">
			<div class="span-3"><div class="pageheader"><%=logs.get(i).getCreateTime().toString()%></div></div>
			<div class="span-20"><div class="pageleft"><%=logs.get(i).getLogTitle() %></div></div>
		</div>
	</div>
	<%} %>
	<div class="column span-24">
		<div class="pageheader">
			分页：
		</div>
	</div>
	<div class="column span-24">
		<div class="pageheader">
		<h6>Copyright &#169; 2003-2011 ikms.sourceforge.net All rights reserved <br/></h6>
		基于JQuery 1.6.x + Spring3 MVC REST + Spring 3.0.x + Mybatis 3.0.x + MySQL 5.0.x/5.x + Tomcat 6.0.x/7.0.x 构建<br/>
		<a href="${httpBase}about.html">About</a>  
		<a href="http://oxidy.javaeye.com">Author Blog</a>
		<a href="http://ikms.googlecode.com">Google Code</a> 
		<a href="http://ikms.sourceforge.net">Sourceforge.net Home</a> <br/>
		浏览器详细参数：<span id="browserFull"></span>
		</div>
	</div>
</div>
</body>
</html>