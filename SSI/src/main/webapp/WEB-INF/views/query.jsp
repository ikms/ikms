<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="Common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellpadding="1">
		<tr>
			<td>用户编码</td>
			<td>用户名</td>
			<td>密码</td>
			<td>创建日期</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.userId }</td>
			<td>${user.userName }</td>
			<td>${user.userPassword }</td>
			<td><fmt:formatDate value="${user.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			<td><a href="${base}/usercenter/getInfo3/${user.userId}.html">View</a></td>
		</tr>
		</c:forEach>
	</table>
        
</body>
</html>