<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Kategori Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div class="inputBox">
			<div class="menu-header">
				Input Konfigurasi
			</div>
	  		<stripes:form action="/action/konfigurasi" id="login_form">
	  		<table border="0">
	  			<tr>
		  			<td>
		  				<label>Nama</label>
		  			</td>
		  			<td>
		  				<input type="text" name="konfigurasi.nama" value="${actionBean.konfigurasi.nama}" autofocus="autofocus" required="required"/>
		  				<input type="hidden" name="konfigurasi.pkKonfigurasi" value="${actionBean.konfigurasi.pkKonfigurasi}"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Alamat</label>
		  			</td>
		  			<td>
		  				<input type="text" name="konfigurasi.alamat" value="${actionBean.konfigurasi.alamat}" required="required"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Telepon</label>
		  			</td>
		  			<td>
		  				<input type="text" name="konfigurasi.telepon" value="${actionBean.konfigurasi.telepon}" required="required" class="validation-number"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Header</label>
		  			</td>
		  			<td>
		  				<input type="text" name="konfigurasi.header" value="${actionBean.konfigurasi.header}" required="required"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Banner</label>
		  			</td>
		  			<td>
		  				<stripes:file name="imageFile"/>
		  				<input type="hidden" name="konfigurasi.bannerName" value="${actionBean.konfigurasi.bannerName}"/>
		  				<input type="hidden" name="konfigurasi.bannerPath" value="${actionBean.konfigurasi.bannerPath}"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Kata Hiasan Struk</label>
		  			</td>
		  			<td>
		  				<textarea name="konfigurasi.kataHiasan" cols="30" rows="5">${actionBean.konfigurasi.kataHiasan}</textarea>
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