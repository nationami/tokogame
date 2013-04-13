<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Welcome">
  	<stripes:layout-component name="content">
		<stripes:form action="/action/home" id="welcome_form">
			<div class="div-button"><input type="submit" name="personal" value="Personal" class="button-welcome"/></div>
			<div class="div-button"><input type="submit" name="member" value="Member" class="button-welcome"/></div>
		</stripes:form>	
	</stripes:layout-component>
</stripes:layout-render>