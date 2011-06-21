<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>ikms</title>
<link rel="stylesheet" href="${base}/resources/css/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="${base}/resources/css/print.css" type="text/css" media="print"/>
<!--[if lt IE 8]>
<link rel="stylesheet" href="${base}/resources/css/ie.css" type="text/css" media="screen, projection"/>
<![endif]-->
<link rel="stylesheet" href="${base}/resources/css/link-icons/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="${base}/resources/css/buttons/screen.css" type="text/css" media="screen, projection"/>
</head>
<body>
<div class="container">
	<div class="column span-24">
		<div class="pageheader"  style="height: 90px;">
			<h1>ikms Logo</h1>
			<h6>My Knowledge Management System &#169;version 1.0</h6>
		</div>
	</div>
	<div class="column span-15">
		<div class="pageleft" style="height: 400px;">
			<h3>demo List</h3>
			<ul>
				<li><a href="${httpBase}showcase.html">ikms-showcase</a></li>
				<li><a href="#">博客管理系统</a></li>
				<li><a href="#">日志管理系统</a></li>
				<li><a href="#">财务管理系统</a></li>
			</ul>
		</div>
	</div>
	<div class="column span-9 last">
		<div class="pagecontent" style="height: 400px;">
			<h3>用户登录</h3>
			<p>
              <label for="id_accountName">帐号:</label><br>
              <input type="text" class="title" name="accountName" id="id_accountName" value="">
            </p>
			<p>
              <label for="id_accountPassword">密码:</label><br>
              <input type="password" class="title" name="accountPassword" id="id_accountPassword" value="">
            </p>
            <p align="right">
              <button id="id_submit" type="submit" class="button positive" onclick="return checkpage();">
				<img src="${pageContext.request.contextPath}/resources/css/buttons/icons/tick.png" alt=""/> 登  录
			  </button>
            </p>
		</div>
	</div>
	<div class="column span-24">
		<div class="pageheader">
		<h6>Copyright &#169; 2003-2011 ikms.sourceforge.net All rights reserved <br/></h6>
		基于JQuery 1.6.x + Spring3 MVC REST + Spring 3.0.x + Mybatis 3.0.x + MySQL 5.0.x/5.x + Tomcat 6.0.x/7.0.x 构建<br/>
		<a href="${httpBase}about.html">About</a>  
		<a href="http://oxidy.javaeye.com">Author Blog</a>
		<a href="http://ikms.googlecode.com">Google Code</a> 
		<a href="http://ikms.sourceforge.net">Sourceforge.net Home</a> 
		</div>
	</div>
</div>
</body>
</html> 