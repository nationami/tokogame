<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Promo Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div class="inputBox">
			<div class="menu-header">
				Input Promo
			</div>
	  		<stripes:form action="/action/promoMaintenance" id="promo_form">
	  		<table border="0">
	  			<tr>
		  			<td width="100px">
		  				<label>Nama Promo</label>
		  			</td>
		  			<td>
		  				<input type="text" name="promoMain.promoName" value="${actionBean.promoMain.promoName}" autofocus="autofocus" required="required"/>
		  				<input type="hidden" name="promoMain.pkPromoMain" value="${actionBean.promoMain.pkPromoMain}"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Deskripsi</label>
		  			</td>
		  			<td>
		  				<textarea name="promoMain.promoDesc" cols="30" rows="5">${actionBean.promoMain.promoDesc}</textarea>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Active</label>
		  			</td>
		  			<td>
		  				<c:choose>
		  					<c:when test="${actionBean.promoMain.promoActive == '1'}">
		  						<input type="checkbox" name="promoMain.promoActive" checked="checked" value="1"></input>
		  					</c:when>
		  					<c:when test="${actionBean.promoMain.promoActive == null || actionBean.promoMain.promoActive == '0'}">
		  						<input type="checkbox" name="promoMain.promoActive" value="1"></input>
		  					</c:when>
		  				</c:choose>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td colspan="2">
		  				<fieldset class="info-fieldset">
							<legend>Item</legend>
							<div style="overflow: scroll; height: 190px">
							<table align="center" id="item_list" style="width: 100%" cellpadding="0" cellspacing="1">
								<c:if test="${empty actionBean.listPromoDetail}">
								<tr>
									<td>1</td>
									<td>
										<select name="fkItem">
											<option value="">-Please Select-</option>
											<c:forEach items="${actionBean.listItem}" var="item">
												<option value="${item.pkItem}">${item.itemName}</option>
											</c:forEach>
										</select>
									</td>
									<td><input type="text" name="nilaiDiskon" class="validation-number" required="required" value=""></td>
									<td>
										<select name="jenisDiskon">
											<option value="">-Please Select-</option>
											<option value="PERSEN">Persen</option>
											<option value="RUPIAH">Rupiah</option>
										</select>
									</td>
									<td>	
										<span>
											<img alt="icon" src="${contextPath}/img/add.png" width="20px" height="20px" border="0" title="add item" class="addItem" onclick="javascript:addItem();return false"/>
										</span>
										<span>
											<img alt="icon" src="${contextPath}/img/delete.png" width="20px" height="20px" border="0" title="delete item" class="deleteItem" onclick="javascript:deleteItem(0);return false"/>
										</span>
									</td>
								</tr>
								</c:if>
								
								<c:if test="${not empty actionBean.listPromoDetail}">
									<c:forEach items="${actionBean.listPromoDetail}" var="detail" varStatus="loop">
										<tr>
										<td>${loop.index}</td>
										<td>
											<select name="fkItem">
												<option value="">-Please Select-</option>
												<c:forEach items="${actionBean.listItem}" var="item">
													<c:choose>
														<c:when test="${item.pkItem==detail.fkItem}">
														<option value="${item.pkItem}" selected="selected">${item.itemName}</option>
														</c:when>
														<c:otherwise>
														<option value="${item.pkItem}">${item.itemName}</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>
										</td>
										<td><input type="text" name="nilaiDiskon" class="validation-number" value="${detail.nilaiDiskon}" required="required"></td>
										<td>
											<select name="jenisDiskon">
												<option value="">-Please Select-</option>
												<c:choose>
													<c:when test="${detail.jenisDiskon=='PERSEN'}">
														<option value="PERSEN" selected="selected">Persen</option>
														<option value="RUPIAH">Rupiah</option>
													</c:when>
													<c:when test="${detail.jenisDiskon=='RUPIAH'}">
														<option value="PERSEN">Persen</option>
														<option value="RUPIAH" selected="selected">Rupiah</option>
													</c:when>
												</c:choose>
											</select>
										</td>
										<td>	
											<span>
												<img alt="icon" src="${contextPath}/img/add.png" width="20px" height="20px" border="0" title="add item" class="addItem" onclick="javascript:addItem();return false"/>
											</span>
											<span>
												<img alt="icon" src="${contextPath}/img/delete.png" width="20px" height="20px" border="0" title="delete item" class="deleteItem" onclick="javascript:deleteItem(0);return false"/>
											</span>
										</td>
									</tr>	
								</c:forEach>
								</c:if>
								
							</table>
							</div>
						</fieldset>							
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					&nbsp;
		  			</td>
		  			<td>
	  					&nbsp;
		  			</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					&nbsp;
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
	<script>
		$(function() {
				$('#item_list').xytable({
					colModel: [   
								{name:'pkPromoMain', label:'ID', field:'pkPromoMain', hidden:true}, 
								{name:'item', field:'item', label: 'Item'},        					        
					            {name:'nilaiDiskon', label:'Nilai Diskon', field:'nilaiDiskon'},
					            {name:'satuanDiskon', label:'Satuan Diskon', field:'satuanDiskon'},
					            {name:'action', label:'Action', field:'action',width: 70}
					        ],
					        sorter: false,		
					        multiple: false,				
					        mapToForm: false,
				            checkRow: false
				        	
				});
				
				/*$(window).load(function(){
		            $("#item_list tbody").mCustomScrollbar({
		            	scrollButtons:{
		            		enable:true
		            	}
		            });
		        });*/
				
		});	
		
		function addItem(){
			var rowCount = ($('#item_list tr').length)-1;
			var nextIndex = rowCount+1;
			var nextNo = rowCount+1;
			var idx = nextNo-1;
			var options = "";
			var items = JSON.parse('${actionBean.jsonItem}');
			for(var i=0;i<items.length;i++){
				options = options + "<option value="+items[i].pkItem+">"+items[i].itemName+"</option>";
			}
			
			
			$('#item_list tbody').append(
				"<tr _idx="+idx+">"+
					"<td class='count center'>"+nextNo+"</td>"+
					"<td style='display: none;'>"+nextIndex+"</td>"+
					"<td><select name='fkItem'>"+
						"<option value=''>-Please Select-</option>"+
						
						options+
						
					"</select></td>"+
					"<td><input type='text' name='nilaiDiskon' class='validation-number'></td>"+
					"<td><select name='jenisDiskon'>"+
						"<option value=''>-Please Select-</option>"+
						"<option value='PERSEN'>Persen</option>"+
						"<option value='RUPIAH'>Rupiah</option>"+
					"</select></td>"+
					"<td>"+	
						"<span>                              "+
							"<img alt='icon' src='${contextPath}/img/add.png' width='20px' height='20px' border='0' title='add item' class='addItem' onclick='javascript:addItem();return false'/>"+
						"</span>                             "+
						"<span>                              "+
							"<img alt='icon' src='${contextPath}/img/delete.png' width='20px' height='20px' border='0' title='delete item' class='deleteItem' onclick='javascript:deleteItem("+idx+");return false'/>"+
						"</span>                             "+
					"</td>"+
				"</tr>"
			);
			
			$('.validation-number').numeric();
		};
		
		function deleteItem(idx){
			$("#item_list tr[_idx='"+idx+"']").remove();
			var rowCount = ($('#item_list tr').length)-1;
			for(var i=0;i<rowCount;i++){
				$('#item_list tbody').children().eq(i).attr("_idx",i);
				$('#item_list tbody').children().eq(i).children().eq(0).html(i+1);
				$('#item_list tbody').children().eq(i).children().eq(1).html(i+1);
			}
		};
	</script>	
	</stripes:layout-component>
</stripes:layout-render>