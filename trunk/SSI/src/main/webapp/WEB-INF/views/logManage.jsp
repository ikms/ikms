<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Common.jsp"%>
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
<script language="javascript" type="text/javascript" src="${base}/resources/script/my97/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#browser").html(browser());
	$("#browserFull").html(navigator.userAgent);
});
function browser(){
	var bInfo="未知浏览器";
	var Sys = {};
    var ua = navigator.userAgent.toLowerCase();
    var s;
    (s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
    (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
    (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
    (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

    //以下进行测试
    if (Sys.ie) bInfo = 'Microsoft Internet Explorer ' + Sys.ie;
    if (Sys.firefox) bInfo = 'Mozilla Firefox ' + Sys.firefox;
    if (Sys.chrome) bInfo = 'Google Chrome ' + Sys.chrome;
    if (Sys.opera) bInfo = 'Opera ' + Sys.opera;
    if (Sys.safari) bInfo = 'Apple Safari ' + Sys.safari;
    
	return bInfo;
}
</script>
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
		<div class="pagecontent">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>日期：</td>
					<td><input type="text" class="title Wdate" name="date" id="id_date" value="" onfocus="WdatePicker()"/></td>
				</tr>
				<tr>
					<td>主题：</td>
					<td><input type="text" class="title span-16" name="date" id="id_date" value=""></td>
				</tr>
				<tr>
					<td>内容：</td>
					<td><textarea name="logContent" id="id_logContent" rows="5" cols="20" class="span-16"></textarea></td>
				</tr>
				<tr>
					<td colspan="2">
						<button id="id_submit" type="submit" class="button positive" onclick="return checkpage();">
							<img src="${base}/resources/css/buttons/icons/tick.png" alt=""/> 保   存
						</button>
					</td>
				</tr>
			</table>
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
		浏览器：<span id="browser"></span><br/>
		浏览器详细参数：<span id="browserFull"></span>
		</div>
	</div>
</div>
</body>
</html>