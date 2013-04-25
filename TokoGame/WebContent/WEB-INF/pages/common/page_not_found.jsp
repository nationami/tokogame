<%--
  This page will be displayed to user when the requested url
  is invalid or the page cannot be found

  $Date: 2013-04-18 13:09:46 +0700 (Thu, 18 April 2013) $
  $Revision: 1215 $
  $LastChangedBy: mardy $

  @author mardy
--%>
<%@include file="/WEB-INF/pages/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Page not found encountered">
	<stripes:layout-component name="content">
		<div class="content-wrapper middle-part">
			<h2>Our apologies ...</h2>
			<h3>The page you requested cannot be displayed</h3>
			<div><img src="${contextPath}/img/PageNotFound.jpg" width="600px" height="500px" align="middle"></img></div>
		</div>
	</stripes:layout-component>
</stripes:layout-render>