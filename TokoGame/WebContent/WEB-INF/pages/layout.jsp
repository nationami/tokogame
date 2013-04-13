<%@include file="taglibs.jsp"%>
<stripes:layout-definition>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- ********************Title********************* -->
<title>Toko Game | ${title} </title>

<!-- *****************Link For CSS***************** -->
<link href="${contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background-image: url('${contextPath}/img/paper1.png')">
	<div id="header-container">
		<label>Toko Game</label>
	</div>
	
	<div id="body-container">
		<stripes:layout-component name="content"/>	
	</div>
	
	<div id="footer-container">
		<label>Date & Time :&nbsp;<fmt:formatDate type="both" pattern = "dd MMMM yyyy HH:mm:ss" value="${actionBean.today}"/></label>
	</div>
</body>
</html>
</stripes:layout-definition>