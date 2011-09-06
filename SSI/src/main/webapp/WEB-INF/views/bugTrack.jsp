<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BugTrack-Bug跟踪管理系统</title>
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
<script type="text/javascript">
$(document).ready(function(){
	$("#browserFull").html(navigator.userAgent);
});
</script>
</head>
<body>
<div class="container">
	<div class="column span-24">
		<div class="pageheader"  style="height: 90px;">
			<h1><span onclick="toURI('${base}')">ikms Logo</span></h1>
			<h6>My Knowledge Management System &#169;version 1.0</h6>
		</div>
	</div>
			<div class="column span-24">
				<div class="pagecontent">
					选择项目：
					<select name="project">
						<option value="201101">题库管理系统</option>
						<option value="201102">外语听力题库</option>
						<option value="201103">成绩分析</option>
						<option value="201104">理化生考试</option>
						<option value="201105">家用学习</option>
					</select>
					选择开发者：
					<select name="developer">
						<option value="zhangyj">张永佳</option>
					</select>
				</div>
			</div>
			<div class="column span-18">
			<div class="pageheader">
			dfasdfasdf
			</div>
			</div>
			<div class="column span-6 last">
			<div class="pageheader">
			asdfasdfasdf
			</div>
			</div>
	<div class="column span-24">
		<div class="pageheader">
		<h6>Copyright &#169; 2003-2011 ikms.sourceforge.net All rights reserved <br/></h6>
		基于JQuery 1.6.x + Spring3 MVC REST + Spring 3.0.x + Mybatis 3.0.x + MySQL 5.0.x/5.x + Tomcat 6.0.x/7.0.x 构建<br/>
		<a href="${httpBase}about.html">About</a>  
		<a href="http://oxidy.javaeye.com" target="_blank">Author Blog</a>
		<a href="http://ikms.googlecode.com" target="_blank">Google Code</a> 
		<a href="http://ikms.sourceforge.net" target="_blank">Sourceforge.net Home</a> <br/>
		浏览器详细参数：<span id="browserFull"></span>
		</div>
	</div>
</div>
</body>
</html>