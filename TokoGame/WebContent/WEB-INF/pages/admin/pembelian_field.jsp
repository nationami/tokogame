<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Pembelian Item">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div class="inputBox">
			<div class="menu-header">
				Input Pembelian
			</div>
	  		<stripes:form action="/action/pembelian" id="pembelian_form">
	  		<table border="0">
	  			<tr>
		  			<td width="100px">
		  				<label>Nota</label>
		  			</td>
		  			<td>
		  				<input type="text" name="pembelian.nota" value="${actionBean.pembelian.nota}" autofocus="autofocus" required="required"/>
		  				<input type="hidden" name="pembelian.pkPembelian" value="${actionBean.pembelian.pkPembelian}"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Suplier</label>
		  			</td>
		  			<td>
		  				<input type="text" name="pembelian.supplier" value="${actionBean.pembelian.supplier}" required="required"/>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Tanggal</label>
		  			</td>
		  			<td>
		  				<input type="text" name="tanggal" size="20" readonly="readonly" id="datepicker" required="required" value="<fmt:formatDate value="${actionBean.pembelian.tanggalBeli}" pattern="dd-MMMM-yyyy"/>"/>
		  				<input type="text" name="waktu" size="10" readonly="readonly" id="timepicker" required="required" value="${actionBean.waktu}"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td colspan="2">
		  				<fieldset class="info-fieldset">
							<legend>Item</legend>
							<div style="overflow: scroll; height: 190px">
							<table align="center" id="item_list" style="width: 100%" cellpadding="0" cellspacing="1">
								<c:if test="${empty actionBean.listPembelianDetail}">
								<tr>
									<td>1</td>
									<td>
										<select name="itemVal">
											<option value="">-Please Select-</option>
											<c:forEach items="${actionBean.listItem}" var="item">
												<option value="${item.pkItem},${item.itemQty}">${item.itemName}</option>
											</c:forEach>
										</select>
									</td>
									<td><input type="text" name="qty" class="validation-number" required="required" value=""></td>
									<td>
										<input type="text" name="harga" class="validation-number" required="required" value="">
									</td>
									<td>
										<input type="text" name="keterangan" value="">
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
								
								
								<c:if test="${not empty actionBean.listPembelianDetail}">
								<c:forEach items="${actionBean.listPembelianDetail}" var="detail" varStatus="loop">
								<tr>
									<td>${loop.index}</td>
									<td>
										<select name="itemVal">
											<option value="">-Please Select-</option>
											<c:forEach items="${actionBean.listItem}" var="item">
												<c:choose>
													<c:when test="${item.pkItem==detail.fkItem}">
													<option value="${item.pkItem},${item.itemQty}" selected="selected">${item.itemName}</option>
													</c:when>
													<c:otherwise>
													<option value="${item.pkItem},${item.itemQty}">${item.itemName}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</td>
									<td><input type="text" name="qty" class="validation-number" required="required" value="${detail.pembelianQty}"></td>
									<td>
										<input type="text" name="harga" class="validation-number" required="required" value="${detail.hargaPembelian}">
									</td>
									<td>
										<input type="text" name="keterangan" value="${detail.keterangan}">
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
								{name:'pkPembelian', label:'ID', field:'pkPembelian', hidden:true}, 
								{name:'item', field:'item', label: 'Item'},        					        
					            {name:'qty', label:'Qty', field:'qty'},
					            {name:'harga', label:'Harga', field:'harga'},
					            {name:'keterangan', label:'Keterangan', field:'keterangan'},
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
				options = options + "<option value="+items[i].pkItem+","+items[i].itemQty+">"+items[i].itemName+"</option>";
			}
			
			$('#item_list tbody').append(
				"<tr _idx="+idx+">"+
					"<td class='count center'>"+nextNo+"</td>"+
					"<td style='display: none;'>"+nextIndex+"</td>"+
					"<td><select name='itemVal'>"+
						"<option value=''>-Please Select-</option>"+
						
						options+
						
					"</select></td>"+
					"<td><input type='text' name='qty' class='validation-number' required='required' value=''></td>" +
					"<td>" +
						"<input type='text' name='harga' class='validation-number' required='required' value=''>" +
					"</td>" +
					"<td>" +
						"<input type='text' name='keterangan' value=''>" +
					"</td>" +
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