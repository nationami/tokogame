<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Login">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
		<div class="content">
		<div class="loginBox">
			<div class="menu-header">
				Member Login
			</div>
			<stripes:errors></stripes:errors>
			<stripes:messages/>
			<stripes:form action="/action/login" id="login_form">
				<table border="0" align="center">
					<tr>
						<td>Username  </td>
						<td><input type="text" name="user" autofocus="autofocus" required="required"></td>
					</tr>
					<tr>
						<td>Password  </td>
						<td><input type="password" name="pass" required="required"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="login" value="Login"></td>
					</tr>
				</table>
			</stripes:form>
		</div>	
		</div>
		
	</div>	
	</stripes:layout-component>
</stripes:layout-render>