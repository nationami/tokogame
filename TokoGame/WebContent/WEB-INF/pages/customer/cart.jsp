<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Cart">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="User Information">
  			<stripes:form action="/action/cart" id="user_form">
  			Apakah ingin diproses lebih lanjut? 
  			<input type="hidden" name="user.role" value="${sessionScope.__role}"/>
  			<c:if test="${sessionScope.__role=='PERSONAL'}">
  			<br/>
  			Tolong masukkan biodata singkat berikut :
  			</c:if>
  			<br/>
  			<br/>
	  		<table border="0">
	  		<c:if test="${sessionScope.__role=='PERSONAL'}">
	  			<tr>
		  			<td>
		  				<label>Nama</label>
		  			</td>
		  			<td>
		  				<input type="text" name="user.name" autofocus="autofocus" required="required"/>
		  				<input type="hidden" name="user.active" value="0"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Handphone</label>
		  			</td>
		  			<td>
		  				<input type="text" name="user.handphone" required="required"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Alamat</label>
		  			</td>
		  			<td>
		  				<textarea name="user.address" cols="30" rows="3" required="required"></textarea>
		  			</td>
	  			</tr>
	  		</c:if>	
	  			<tr>
	  				<td width="80px">
	  					&nbsp;
		  			</td>
		  			<td>
		  				<input type="submit" name="submit" value="Submit"/>
		  				<input type="button" name="cancel" value="Cancel" formnovalidate="formnovalidate" id="cancel"/>
		  			</td>
	  			</tr>
	  		</table>
	  		
			</stripes:form>
  		</div>
		<div>
			<div style="height: 600px;">
				<c:set var="totalHarga" value="0"></c:set>
				<table align="center" id="cart_list" style="width: 100%;" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.buyingItem}" var="buyingItem" varStatus="loop" >
						<tr>
							<td>	
								${buyingItem.pkItem}
							</td>
							<td>	
								<a href="${contextPath}/action/cart?batal=&idx=${loop.index}"><img alt="image" src="${contextPath}/img/trash_icon.png" width="20px" height="20px" border="0"></a>
							</td>
							<td>	
								${buyingItem.itemName}
							</td>
							<td>
								&mdash;	
							</td>
							<td>
								<c:if test="${empty buyingItem.fileSize}">&mdash;</c:if>
								${buyingItem.fileSize}	
							</td>
							<td>
								${buyingItem.qty}	
							</td>
							<td style="text-align: right;">
								${buyingItem.harga}	
							</td>
						</tr>
						<c:set var="totalHarga" value="${buyingItem.harga+totalHarga}"></c:set>
					</c:forEach>
				</table>
				<table style="width: 100%; text-align: right;" cellpadding="1" cellspacing="1">
						<tr>
							<td>
								Total Harga	
							</td>
							<td style="border: 1px solid #000000; background-color: white;" width="250">
								${totalHarga}	
							</td>
						</tr>
				</table>
			</div>
			<div align="right">
				<c:choose>
					<c:when test="${totalHarga>0}">
						<input type="button" value="         Bayar        " name="bayar" width="30px" id="bayar">
					</c:when>
					<c:otherwise>
						<input type="button" value="         Bayar        " name="bayar" width="30px" disabled="disabled">
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>	
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {
				$('#dialog-confirm').dialog({
					modal: true,
					autoOpen: false,
					open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
					width:'400px'
					
				});
				
				$('#bayar').click(function(){
					$('#dialog-confirm').dialog('open');
				});
				
				$('#cancel').click(function(){
					$('#dialog-confirm').dialog('close');
				});
				
				$('#cart_list').xytable({
					colModel: [   
								{name:'pkItem', label:'ID', field:'pk_item', hidden:true},
								{name:'batal', field:'batal', label: 'Batal',width: 20},
								{name:'nama', field:'nama', label: 'Nama'},        					        
					            {name:'publisher', label:'Publisher', field:'publisher'},
					            {name:'size', label:'File Size', field:'size'},
					            {name:'qty', label:'Qty', field:'qty'},
					            {name:'harga', label:'Harga', field:'harga',width: 250}
					        ],
					 pager: {
					            id:'pager_cart',
					            base: '${contextPath}/action/cart',
					            param: {},
					            page: '${actionBean.page}',
					            records: '${actionBean.size}',
					            rows: 10
					         },
					        sorter: false,		
					        multiple: false,				
				            checkRow: false
				        	
				});
				
					
				
			});
			
		</script>
	</stripes:layout-component>
</stripes:layout-render>