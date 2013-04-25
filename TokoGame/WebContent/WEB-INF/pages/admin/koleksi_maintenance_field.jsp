<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Koleksi Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div class="inputBox">
			<div class="menu-header">
				Input Koleksi
			</div>
	  		<stripes:form action="/action/koleksiMaintenance" id="login_form">
	  		<table border="0">
	  			<tr>
		  			<td>
		  				<label>Nama Koleksi</label>
		  			</td>
		  			<td>
		  				<input type="text" name="koleksi.koleksiName" value="${actionBean.koleksi.koleksiName}" autofocus="autofocus" required="required"/>
		  				<input type="hidden" name="koleksi.pkKoleksi" value="${actionBean.koleksi.pkKoleksi}"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Deskripsi</label>
		  			</td>
		  			<td>
		  				<textarea name="koleksi.koleksiDesc" cols="30" rows="10">${actionBean.koleksi.koleksiDesc}</textarea>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
		  			</td>
		  			<td>
		  				<input type="submit" name="save" value="Save"/>
		  				<input type="submit" name="cancel" value="Cancel" formnovalidate="formnovalidate"/>
		  			</td>
	  			</tr>
	  		</table>
			</stripes:form>
		</div>	
	</div>	
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		
	</stripes:layout-component>
</stripes:layout-render>