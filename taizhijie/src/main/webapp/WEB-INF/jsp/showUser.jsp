<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="commons/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>测试</title>
<%@include file="commons/common-css.jsp"%>
<%@include file="commons/common-script.jsp"%>
</head>
<body>
	<h1>Hello, world!</h1>

	<div id="aa">a</div>

	${user.userName} |
	<spring:message code="test.t" />
	|
</body>
</html>
