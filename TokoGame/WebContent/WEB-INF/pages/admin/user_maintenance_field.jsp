<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<script type="text/javascript">
		//function checkNumber jika memakukan non angka maka akan langsung dihapus
	  	function checkNumber(obj){
	  		var pola = "^";
	  		pola += "[0-9]*";
	  		pola += "$";
	  		rx = new RegExp(pola);
	  		
	  		if(!obj.value.match(rx)){
	  			if(obj.lastMatched){
	  				obj.value = obj.lastMatched;
	  			}
	  			else{
	  				obj.value = "";
	  			}
	  		}
	  		else{
	  			obj.lastMatched = obj.value;
	  		}
	  	}
		//function checkIt jika memasukan non angka maka akan langsung keluar msgbox
	  	function checkIt(evt){
	  		evt = (evt) ? evt : window.event
	  		var charCode = (evt.which) ? evt.which : evt.keyCode
	  		if (charCode > 31 && (charCode < 48 || charCode > 57)){
	  			alert("Isi field handphone dengan angka");
	  			return false;
	  		}
	  		return true;
	  	}
</script>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="User Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div class="inputBox">
			<div class="menu-header">
				Input User
			</div>
	  		<stripes:form action="/action/userMaintenance" id="login_form">
	  		<table border="0">
	  			<tr>
		  			<td>
		  				<label>User Login</label>
		  			</td>
		  			<td>
		  				<input type="text" name="user.userLogin" value="${actionBean.user.userLogin}" autofocus="autofocus" required="required"/>
		  				<input type="hidden" name="user.userId" value="${actionBean.user.userId}"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Name</label>
		  			</td>
		  			<td>
		  				<input type="text" name="user.name" value="${actionBean.user.name}" autofocus="autofocus" required="required"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Password</label>
		  			</td>
		  			<td>
		  				<input type="password" name="user.password" value=""></input>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>No. Handphone</label>
		  			</td>
		  			<td>
		  				<input type="text" name="user.handphone" maxlength="12" onkeyup="return checkNumber(this);" value="${actionBean.user.handphone}" autofocus="autofocus" required="required"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Role</label>
		  			</td>
		  			<td>
		  				<c:choose>
		  					<c:when test="${actionBean.user.role == 'ADMIN' || actionBean.user.role == null}">
				  				<select id="role" name="user.role">
			        				<option value="ADMIN" selected="selected">ADMIN</option>
				        			<option value="OPERATOR">OPERATOR</option>
				        			<option value="MEMBER">MEMBER</option>
		    					</select>
	    					</c:when>
	    					<c:when test="${actionBean.user.role == 'OPERATOR'}">
				  				<select id="role" name="user.role">
			        				<option value="ADMIN">ADMIN</option>
				        			<option value="OPERATOR" selected="selected">OPERATOR</option>
				        			<option value="MEMBER">MEMBER</option>
		    					</select>
	    					</c:when>
	    					<c:when test="${actionBean.user.role == 'MEMBER'}">
				  				<select id="role" name="user.role">
			        				<option value="ADMIN">ADMIN</option>
				        			<option value="OPERATOR">OPERATOR</option>
				        			<option value="MEMBER" selected="selected">MEMBER</option>
		    					</select>
	    					</c:when>
	    					
    					</c:choose>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Active</label>
		  			</td>
		  			<td>
		  				<c:choose>
		  					<c:when test="${actionBean.user.active == '1'}">
		  						<input type="checkbox" name="user.active" checked="checked"></input>
		  					</c:when>
		  					<c:otherwise>
		  						<input type="checkbox" name="user.active"></input>
		  					</c:otherwise>
		  				</c:choose>
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