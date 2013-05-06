<%@include file="taglibs.jsp"%>
<stripes:layout-definition>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- ********************Title********************* -->
<title>Toko Game | ${title} </title>

<!-- *****************Link For JQuery***************** -->
<script src="${contextPath}/jquery/jquery-1.9.1.min.js"></script>
<script src="${contextPath}/jquery/jquery-migrate-1.1.1.min.js"></script>
<script src="${contextPath}/jquery/jquery-ui-1.10.2.custom.js"></script>
<script src="${contextPath}/jquery/sidebarmenu.js"></script>

<!-- *****************Link For Xytable***************** -->
<script src="${contextPath}/jquery/xytable/jquery.ba-bbq.min.js"></script>
<script src="${contextPath}/jquery/xytable/jquery.tablesorter.min.js"></script>
<script src="${contextPath}/jquery/xytable/jquery.xycommon.min.js"></script>
<script src="${contextPath}/jquery/xytable/jquery.xytable_new.js"></script>
<link href="${contextPath}/jquery/xytable/xytable.css" rel="stylesheet" type="text/css"/>

<!-- *****************Link For Video***************** -->
<script src="${contextPath}/js/video.js"></script>
<script src="${contextPath}/js/video-quality.js"></script>

<!-- *****************Link For Javascript***************** -->
<script src="${contextPath}/js/common.js"></script>

<!-- *****************Link For CSS***************** -->
<link href="${contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${contextPath}/css/sidebarmenu.css" rel="stylesheet" type="text/css"/>
<link href="${contextPath}/css/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css"/>
<link href="${contextPath}/css/video-js.css" rel="stylesheet" type="text/css" media='all'/>

<stripes:layout-component name="init"/>
</head>
<body style="background-image: url('${contextPath}/img/paper1.png')">
	<div id="header-container">
		<label>Toko Game</label>
		<span class="right-part">
			<a href="${contextPath}/action/cart"><img alt="image" src="${contextPath}/img/cart_icon.png" width="25px" height="25px" border="0" title="Cart" class="icon-btn"></a>&nbsp;
			<img alt="image" src="${contextPath}/img/home_icon.png" width="25px" height="25px" border="0" title="Home" class="icon-btn">&nbsp;
			<img alt="image" src="${contextPath}/img/shutdown.png" width="25px" height="25px" border="0" title="Logout" class="icon-btn">&nbsp;
		</span>
	</div>
	
	<div id="body-container">
		<stripes:layout-component name="content"/>	
	</div>
	
	<div id="footer-container">
		<label>Date & Time :&nbsp;<span id="date"></span>&nbsp;<span id="hours"></span>:<span id="min"></span>:<span id="sec"></span></label>
	</div>
</body>
<stripes:layout-component name="closing"/>
</html>
</stripes:layout-definition>