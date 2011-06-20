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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons/screen.css" type="text/css" media="screen, projection"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/jquery-min.js"></script>
<script type="text/javascript">
function checkpage(){
	var userName = $("#id_userName").val();
	$("#id_submit").disabled = true;
	if(userName==""){
		alert("用户名为空");
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<div class="container">
		<div class="column span-24">
			<div class="notice">
				用户注册模块Demo
			</div>
		</div>
		<div class="column span-6">
			<div class="info">
				菜单区域<br/>
				菜单区域<br/>
				菜单区域<br/>
				菜单区域<br/>
				菜单区域<br/>
				菜单区域<br/>
				菜单区域<br/>
				菜单区域<br/>
			</div>
		</div>
		<div class="column span-18 last">
			<div class="span-12">
				<form id="id_regUserFrm" action="signup.html" method="post">
					<fieldset>
	            		<legend>用户注册</legend>
	            		<p>
							<label for="id_userAccount">用户账户：</label>
							<input type="text" class="title" name="userAccount" id="id_userAccount" value=""/><br/>
							
							<label for="id_userName">用户姓名：</label>
							<input type="text" class="title" name="userName" id="id_userName" value=""/><br/>
							
							<label for="id_password">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
							<input type="password" class="title" name="userPassword" id="id_userPassword" value=""/><br/>
						</p>
						<p>
							<button id="id_submit" type="submit" class="button positive" onclick="return checkpage();">
								<img src="${pageContext.request.contextPath}/resources/css/buttons/icons/tick.png" alt=""/> 注 册
							</button>
						</p>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>