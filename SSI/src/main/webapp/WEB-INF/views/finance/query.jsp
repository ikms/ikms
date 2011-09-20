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
<script type="text/javascript">
$(document).ready(function(){
	$("#browserFull").html(navigator.userAgent);
});
</script>
<style type="text/css">
ul {border: 0;margin: 0;padding: 0;}
#pagination-flickr li {border: 0;margin: 0;padding: 0;	font-size: 11px;list-style: none;}
#pagination-flickr a {border: solid 1px #DDDDDD;margin-right: 2px;}
#pagination-flickr .previous-off,#pagination-flickr .next-off {color: #666666;display: block;float: left;font-weight: bold;	padding: 3px 4px;}
#pagination-flickr .next a,#pagination-flickr .previous a {	font-weight: bold;	border: solid 1px #FFFFFF;}
#pagination-flickr .active {color: #ff0084;	font-weight: bold;display: block;float: left;padding: 4px 6px;}
#pagination-flickr a:link,#pagination-flickr a:visited {color: #0063e3;display: block;float: left;padding: 3px 6px;text-decoration: none;}
#pagination-flickr a:hover {border: solid 1px #666666;}
.span-back{float: right;}
</style>
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
		<table>
			<thead>
				<tr>
					<th>
					<input type="button" class="btn_gl" value="添加日志" onclick="toMethod('${base}','log','toAdd');"/>
					<a class="span-back">返回</a> 
					</th>
				</tr>
			<thead>
		</table>
		<table>
			<thead>
				<tr height="35px;">
					<th>日期</th>
					<th>日志标题</th>
					<th>操作</th>
				</tr>
			</thead>
			<tfoot>
				<tr align="center">
					<td colspan="2">
						<ul id="pagination-flickr">
							<li class="previous-off">«Previous</li>
							<li class="active">1</li>
							<li><a href="?page=2">2</a></li>
							<li><a href="?page=3">3</a></li>
							<li><a href="?page=4">4</a></li>
							<li><a href="?page=5">5</a></li>
							<li><a href="?page=6">6</a></li>
							<li><a href="?page=7">7</a></li>
							<li class="next"><a href="?page=2">Next »</a></li>
						</ul>
					</td>
				</tr>
			</tfoot>
			<c:forEach items="${logs}" var="log">
			<tr height="32px;">
				<td width="20%"><fmt:formatDate value="${log.createTime}" pattern="yyyy-MM-dd"/></td>
				<td><c:out value="${log.logTitle}" escapeXml="false"/></td>
				<td width="15%">
					<a href="toView/${log.logId}.html">view</a> 
					<a href="toEdit/${log.logId}.html">edit</a> 
					<a href="toDelete/${log.logId}.html">delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../include/foot.jsp" flush="false"></jsp:include>
</div>
</body>
</html>