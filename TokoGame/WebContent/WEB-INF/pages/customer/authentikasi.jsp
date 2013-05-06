<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Login">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
		<div class="content">
		<div class="autentikasiBox">
			<div class="menu-header">
				Autentikasi
			</div>
			<stripes:errors></stripes:errors>
			<stripes:messages/>
			<stripes:form action="/action/authentication" id="login_form">
				<table border="0" align="center">
					<tr>
						<td>Kode Pembelian</td>
						<td><input type="text" name="belanja.kodeBelanja" autofocus="autofocus" required="required" size="40"></td>
					</tr>
					<tr>
						<td>Kode Autentikasi</td>
						<td><input type="text" name="belanja.kodeAutentikasi" required="required" size="40"></td>
					</tr>
					<tr>
						<td></td>
						<td align="right"><input type="submit" name="proses" value="Proses"></td>
					</tr>
				</table>
			</stripes:form>
		</div>	
		</div>
		
	</div>	
	</stripes:layout-component>
</stripes:layout-render>