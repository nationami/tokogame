<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Detail Pembayaran">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-void" title="Void Confirmation">
  			<stripes:form action="/action/pembayaran" id="batal_form">
  				Are you sure want to cancel the retur?
  				<input type="hidden" name="pkDetail" id="pkDetailVoid"/>
  				<input type="hidden" name="retur.fkBelanja" id="fkBelanjaVoid"/>
  			</stripes:form>
  		</div>
  		<div id="dialog-confirm" title="Retur Belanja">
  			<stripes:form action="/action/pembayaran" id="retur_form">
	  		<table border="0">
	  			<tr>
		  			<td>
		  				<label>Nama</label>
		  			</td>
		  			<td>
		  				<label id="itemName"></label>
		  				<input type="hidden" name="retur.fkBelanja" id="fkBelanja"/>
		  				<input type="hidden" name="retur.fkItem" id="fkItem"/>
		  				<input type="hidden" name="hargaItem" id="hargaItem"/>
		  				<input type="hidden" name="pkDetail" id="pkDetail"/>
		  			</td>
	  			</tr>
	  			<tr>
		  			<td>
		  				<label>Qty</label>
		  			</td>
		  			<td>
		  				<input type="number" name="retur.returQty" required="required" size="10" class="validation-number" max="1" min="1" id="qtyField" />
		  			</td>
	  			</tr>
	  			<tr>
	  				<td valign="top">
		  				<label>Alasan</label>
		  			</td>
		  			<td>
		  				<textarea name="retur.reason" cols="30" rows="3" required="required"></textarea>
		  			</td>
	  			</tr>
	  			<tr>
	  				<td width="80px">
	  					&nbsp;
		  			</td>
		  			<td>
		  				<input type="submit" name="retur" value="Submit"/>
		  				<input type="button" name="cancel" value="Cancel" formnovalidate="formnovalidate" class="cancel"/>
		  			</td>
	  			</tr>
	  		</table>
	  		
			</stripes:form>
  		</div>
  		
		<div>
			<stripes:form action="/action/pembayaran" id="bayar_form">
			<div style="height: 600px;">
				<c:set var="totalHarga" value="0"></c:set>
				<c:set var="totalRetur" value="0"></c:set>
				<c:set var="totalQty" value="0"></c:set>
				<table align="center" id="cart_list" style="width: 100%;" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.detailBuyingItem}" var="buyingItem" varStatus="loop" >
						<tr>
							<td>	
								${buyingItem.pk_item}
							</td>
							<td>	
								${buyingItem.fk_belanja}
							</td>
							<td>	
								${buyingItem.pk_belanja_detail}
							</td>
							<td class="item_name">	
								${buyingItem.item_name}
							</td>
							<td>
								&mdash;	
							</td>
							<td>
								<c:if test="${empty buyingItem.fileSize}">&mdash;</c:if>
								${buyingItem.file_size}	
							</td>
							<td class="item_qty">
								${buyingItem.current_qty}
							</td>
							<td class="item_harga" style="text-align: right;">
								${buyingItem.harga_belanja}	
							</td>
							<td style="text-align: right;">
								${buyingItem.current_qty*buyingItem.harga_belanja}	
							</td>
							<td>
								<c:if test="${buyingItem.current_qty>0}">
								<span>	
									<a href="#" onclick="return false;" class="retur">Retur</a>
								</span>
								</c:if>
								<c:if test="${buyingItem.is_retur==1}">
								<span>
									<a href="#" onclick="return false;" class="void">Void</a>
								</span>
								</c:if>
							</td>
						</tr>
						<c:set var="primaryBelanja" value="${buyingItem.fk_belanja}"></c:set>
						<c:set var="totalQty" value="${buyingItem.current_qty+totalQty}"></c:set>
						<c:set var="totalHarga" value="${(buyingItem.belanja_qty*buyingItem.harga_belanja)+totalHarga}"></c:set>
						<c:set var="totalRetur" value="${(buyingItem.retur_qty*buyingItem.harga_belanja)+totalRetur}"></c:set>
					</c:forEach>
				</table>
				<table style="width: 100%; text-align: right;" cellpadding="1" cellspacing="5" border="0">
						<tr>
							<td width="80" style="padding-right: 10px;">Total Beli</td>
							<td style="border: 1px solid #000000; background-color: white;" width="250">
								<input type="hidden" name="penjualan.jualQty" value="${totalQty}"/>
								<input type="hidden" name="penjualan.fkBelanja" value="${primaryBelanja}"/>
								<input type="text" name="penjualan.totalBeli" value="${totalHarga}" size="40" style="text-align: right;" class="validation-number" readonly="readonly"/>	
							</td>
							<td style="padding-right: 10px;">Total Retur</td>
							<td style="border: 1px solid #000000; background-color: white;" width="250">
								<input type="text" name="penjualan.totalRetur" value="${totalRetur}" size="40" style="text-align: right;" class="validation-number" readonly="readonly"/>	
							</td>
							<td style="padding-right: 10px;">
								Sub Total	
							</td>
							<td style="border: 1px solid #000000; background-color: white;" width="250">
								<input type="text" name="penjualan.totalBelanja" value="${totalHarga-totalRetur}" size="40" style="text-align: right;" class="validation-number" readonly="readonly"/>	
							</td>
						</tr>
						<tr>
							<td style="padding-right: 10px;" colspan="5">
								Bayar	
							</td>
							<td style="border: 1px solid #000000; background-color: white;" width="250">
								<input type="text" name="penjualan.totalBayar" value="${totalHarga-totalRetur}" id="totalBayarValue" size="40" style="text-align: right;" class="validation-number"/>	
							</td>
						</tr>
						<tr>
							<td style="padding-right: 10px;" colspan="5">
								Kembali	
							</td>
							<td style="border: 1px solid #000000; background-color: white;" width="250">
								<input type="text" name="penjualan.totalKembali" value="0" size="40" style="text-align: right;" class="validation-number" readonly="readonly"/>	
							</td>
						</tr>
				</table>
			</div>
			<div align="right">
				<span>
				<c:choose>
					<c:when test="${totalHarga-totalRetur>0}">
						<input type="submit" value="         Bayar        " name="bayar" width="30px" id="bayar" min="100000">
					</c:when>
					<c:otherwise>
						<input type="button" value="         Bayar        " name="bayar" width="30px" disabled="disabled">
					</c:otherwise>
				</c:choose>
				</span>
				<span>
						<input type="submit" value="         Cancel       " name="show" width="30px" id="back">
				</span>
			</div>
		</div>
		</stripes:form>
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
				
				$('#dialog-void').dialog({
					modal: true,
					autoOpen: false,
					open: function(event, ui) { $(".ui-dialog-titlebar-close").hide(); },
					width:'400px',
					buttons: {
						"Submit" : function(){
							$("#batal_form").attr("action","pembayaran"+"?cancelRetur=");
							$('#batal_form').submit();
						},
						Cancel : function(){
							$(this).dialog("close");
						}
					}
					
				});
				
				
				$('.cancel').click(function(){
					$('#dialog-confirm').dialog('close');
				});
				
				$('.void').click(function(){
					var pkDetail = $(this).parent().parent().parent().children().eq(3).html();
					var pkBelanja = $(this).parent().parent().parent().children().eq(2).html();
					$('#fkBelanjaVoid').val(pkBelanja);
					$('#pkDetailVoid').val(pkDetail);
					$('#dialog-void').dialog('open');
				});
				
				$('.retur').click(function(){
					var qty = $(this).parent().parent().parent().find('.item_qty').html();
					var name = $(this).parent().parent().parent().find('.item_name').html();
					var harga = $(this).parent().parent().parent().find('.item_harga').html();
					var pkItem = $(this).parent().parent().parent().children().eq(1).html();
					var pkBelanja = $(this).parent().parent().parent().children().eq(2).html();
					var pkDetail = $(this).parent().parent().parent().children().eq(3).html();
					$('#itemName').html(name);
					$('#fkBelanja').val(pkBelanja);
					$('#fkItem').val(pkItem);
					$('#pkDetail').val(pkDetail);
					$('#hargaItem').val(harga);
					
					$('#qtyField').attr("max", parseInt(qty));
					
					$('#dialog-confirm').dialog('open');
				});
				
				$("#bayar_form").validate({
				    rules: {
				    	totalBayar: {
				            min: "${totalHarga-totalRetur}"
				        }
				    }
				});
				
				$('#cart_list').xytable({
					colModel: [   
								{name:'pkItem', label:'ID', field:'pk_item', hidden:true},
								{name:'fkBelanja', label:'belanja', field:'fkBelanja', hidden:true},
								{name:'pkDetail', label:'detail', field:'pkDetail', hidden:true},
								{name:'nama', field:'nama', label: 'Nama'},        					        
					            {name:'publisher', label:'Publisher', field:'publisher'},
					            {name:'size', label:'File Size', field:'size'},
					            {name:'qty', label:'Qty', field:'qty'},
					            {name:'harga', label:'Harga', field:'harga'},
					            {name:'jumlah', label:'Jumlah', field:'jumlah'},
					            {name:'action', label:'Action', field:'action', width: 150}
					        ],
					 pager: {
					            id:'pager_cart',
					            base: '${contextPath}/action/pembayaran',
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