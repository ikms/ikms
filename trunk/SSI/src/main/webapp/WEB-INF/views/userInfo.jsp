<%@page import="net.sf.ssi.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
方法一：
<%
	out.print("=="+request.getAttribute("user")+"==");
%>
<br/>
方法二：
==${user}==
<br/>
方法一与方法二等效
</body>
</html>