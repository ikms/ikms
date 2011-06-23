<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo</title>
</head>
<body>
方法一：
<%
	out.print("=="+request.getAttribute("pramId")+"==");
%>
<br/>
方法二：
==${pramId}==
<br/>
方法一与方法二等效
</body>
</html>