<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Kategori Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div class="inputBox">
			<div class="menu-header">
				Input Kategori
			</div>
			<stripes:errors></stripes:errors>
			<stripes:messages/>
	  		<stripes:form action="/action/kategoriMaintenance" id="login_form">
	  		<table border="0">
	  			<tr>
		  			<td>
		  				<label>Nama Kategori</label>
		  			</td>
		  			<td>
		  				<input type="text" name="kategori.kategoriName" value="${actionBean.kategori.kategoriName}" autofocus="autofocus" required="required"/>
		  				<input type="hidden" name="kategori.pkKategori" value="${actionBean.kategori.pkKategori}"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Koleksi</label>
		  			</td>
		  			<td>
		  				<stripes:select name="listBoxKoleksi" multiple="multiple" size="10" id="listBoxKoleksi">
							<stripes:options-collection collection="${actionBean.listKoleksi}" value="pkKoleksi" label="koleksiName"/>
						</stripes:select>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Deskripsi</label>
		  			</td>
		  			<td>
		  				<textarea name="kategori.kategoriDesc" cols="30" rows="10">${actionBean.kategori.kategoriDesc}</textarea>
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
<script>
	$(document).ready(function() {
		$('#listBoxKoleksi').multiselect2side({
			selectedPosition: 'right',
			moveOptions: false,
			labelsx: 'Available',
			labeldx: 'Selected',
			autoSort: true,
			autoSortAvailable: true,
			
			});
	});
</script>