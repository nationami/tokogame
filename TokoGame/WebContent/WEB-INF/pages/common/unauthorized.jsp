<%--
  This page will be displayed to user when user not authorized access the URL

  $Date: 2011-02-10 12:53:34 +0700 (Thu, 10 Feb 2011) $
  $Revision: 1438 $
  $LastChangedBy: sabri $

  @author sabri
--%>
<%@include file="/WEB-INF/pages/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="unauthorized user try to access ...">
	<stripes:layout-component name="content">
		<div class="content-wrapper">
			<div style="width: 100%; padding: 100px 0px 100px 0px; text-align: center; display: block;">
				YOU ARE NOT AUTHORIZED TO VIEW THIS PAGE<br></br>Click <stripes:link href="/action/login" event="logout" class="font_blue">here</stripes:link> to continue
			</div>
		</div>
	</stripes:layout-component>
</stripes:layout-render>