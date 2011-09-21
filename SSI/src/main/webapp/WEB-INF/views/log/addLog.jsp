<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>日志管理</title>
<link rel="stylesheet" href="${ctx}/resources/css/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="${ctx}/resources/css/print.css" type="text/css" media="print"/>
<!--[if lt IE 8]>
<link rel="stylesheet" href="${ctx}/resources/css/ie.css" type="text/css" media="screen, projection"/>
<![endif]-->
<link rel="stylesheet" href="${ctx}/resources/css/link-icons/screen.css" type="text/css" media="screen, projection"/>
<link rel="stylesheet" href="${ctx}/resources/css/buttons/screen.css" type="text/css" media="screen, projection"/>
<script type="text/javascript" src="${ctx}/resources/script/jquery-min.js"></script>
<script type="text/javascript" src="${ctx}/resources/script/ssi.js"></script>
<script language="javascript" type="text/javascript" src="${ctx}/resources/script/my97/WdatePicker.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#browserFull").html(navigator.userAgent);
});
//将一个表单的数据返回成JSON对象  
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};
function pageCheck(){
	var checkInfo = "";
	var id_createDate = $("#id_createDate").val();
	var id_logTitle = $("#id_logTitle").val();
	var id_logContent = $("#id_logContent").val();
	checkInfo = "<ul>";
	if(id_createDate==''){
		checkInfo = checkInfo + "<li>日期不能为空！</li>"; 
	}
	if(id_logTitle==''){
		checkInfo = checkInfo + "<li>主题不能为空！</li>"; 
	}
	if(id_logContent==''){
		checkInfo = checkInfo + "<li>内容不能为空！</li>"; 
	}
	checkInfo = checkInfo +"</ul>";
	if(checkInfo!='<ul></ul>'){
		$("#checkInfo").html(checkInfo);
		$("#checkInfo").css("display","");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<div class="container">
	<div class="column span-24">
		<div class="pageheader"  style="height: 90px;">
			<h1><span onclick="toURI('${ctx}')">ikms Logo</span></h1>
			<h6>My Knowledge Management System &#169;version 1.0</h6>
		</div>
	</div>
	<div class="column span-24">
		<div class="pagecontent">
			<div class="error" style="display: none;" id="checkInfo"></div>
			<form id="id_addLogFrm" method="POST" action="${httpBase}log/add.html">
				<table id="id_addLog" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>日期：</td>
						<td><input type="text" class="title Wdate" name="createDate" id="id_createDate" value="" onfocus="WdatePicker()"/></td>
					</tr>
					<tr>
						<td>主题：</td>
						<td><input type="text" class="title span-16" name="logTitle" id="id_logTitle" value=""></td>
					</tr>
					<tr>
						<td>内容：</td>
						<td><textarea name="logContent" id="id_logContent" rows="5" cols="20" class="span-16"></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="button" class="btn_gl" id="id_submit" name="save" value="返 回" onclick="toURI('${ctx}')"/>
							<input type="submit" class="btn_gl" id="id_submit" name="save" value="保 存" onclick="return pageCheck();"/>
						</td>
					</tr>
				</table>
			</form>
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