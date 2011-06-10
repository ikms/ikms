<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户注册</title>
<!-- Framework CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/print.css" type="text/css" media="print"/>
<!--[if lt IE 8]>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ie.css" type="text/css" media="screen, projection"/>
<![endif]-->
</head>
<body>
	<div class="container showgrid">
		<div class="span-12">
			<form id="id_regUserFrm" action="signup.html" method="post">
				<fieldset>
            		<legend>用户注册</legend>
            		<p>
						<label for="id_userName">用户名：</label>
						<input type="text" class="title" name="userName" id="id_userName" value=""/><br/>
						<label for="id_password">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
						<input type="password" class="title" name="password" id="id_password" value=""/><br/>
					</p>
					<p>
						<button type="submit" class="button positive">
							<img src="${pageContext.request.contextPath}/resources/css/icons/tick.png" alt=""/> 注 册
						</button>
					</p>
					
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>