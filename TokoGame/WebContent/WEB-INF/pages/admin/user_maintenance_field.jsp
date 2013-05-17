<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<script type="text/javascript">
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
		
		$(document).ready(function(){
			$('#login_form').validate({
				rules:{
					handphone:{
						digits: true,
						minlength:10
					}
			},
			messages: {
				handphone: {
					required : "kolom harus diisi",
					minlength : "Minimal 10 digit"
				}
			}
		});
		});
		
		function limitlength(obj, length){
			var maxlength=length
			if (handphone.value.length<maxlength)
			//obj.value=obj.value.substring(0, maxlength)
			alert(handphone.value.length)	
		}
		
		function validatePhone(field,alertxt){
			with(field){
				if(value.length > 10){
					alert(alertxt);
					return false;
				}
				for (i=0;i<value.length;i++){
					if(parseInt(value[i])== NaN){
						alert(alertxt);
						return false;
					}
				}
				return true;
			}
		}
		function validateForm(thisform){
			if(validatePhone(handphone,"Invalid phone number")== false){
				handphone.focus();
				return false;
			}
		}
</script>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="User Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div class="inputBox">
			<div class="menu-header">
				Input User
			</div>
			<stripes:errors></stripes:errors>
			<stripes:messages/>
	  		<stripes:form action="/action/userMaintenance" id="login_form">
	  		<table border="0">
	  			<tr>
		  			<td>
		  				<label>User Login</label>
		  			</td>
		  			<td>
		  				<c:if test="${actionBean.user.pkUser != null}">
		  					<input type="text" name="user.userLogin" value="${actionBean.user.userLogin}" autofocus="autofocus" required="required" disabled="disabled"/>
		  				</c:if>
		  				<c:if test="${actionBean.user.pkUser == null}">
		  					<input type="text" name="user.userLogin" value="${actionBean.user.userLogin}" autofocus="autofocus" required="required"/>
		  				</c:if>
		  				<input type="hidden" name="user.pkUser" value="${actionBean.user.pkUser}"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Name</label>
		  			</td>
		  			<td>
		  				<input type="text" name="user.name" value="${actionBean.user.name}" required="required"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Password</label>
		  			</td>
		  			<td>
		  				<c:choose>
		  					<c:when test="${actionBean.user.pkUser !=null}">
		  						<input type="password" name="user.password" value=""/>
		  					</c:when>
		  					<c:when test="${actionBean.user.pkUser == null}">
		  						<input type="password" name="user.password" value="" required="required"/>
		  					</c:when>
		  				</c:choose>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>No. Handphone</label>
		  			</td>
		  			<td>
		  				<input type="text" id="handphone" name="user.handphone" maxlength="12" onkeypress="return checkNumber(this)"
		  				value="${actionBean.user.handphone}" required="required" class="validation-number"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>E-mail</label>
		  			</td>
		  			<td>
		  				<input type="email" id="email" name="user.email" value="${actionBean.user.email}" required="required"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Address</label>
		  			</td>
		  			<td>		  			
		  				<textarea id="address" name="user.address" cols="17" rows="5" required>${actionBean.user.address}</textarea>  
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
		  						<input type="checkbox" name="user.active" checked="checked" value="1"></input>
		  					</c:when>
		  					<c:when test="${actionBean.user.active == null || actionBean.user.active == '0'}">
		  						<input type="checkbox" name="user.active" value="0"></input>
		  					</c:when>
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