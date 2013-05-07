<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Detail Pembayaran">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="User Information">
  			
  		</div>
		<div>
			<div style="height: 600px;">
				<c:set var="totalHarga" value="0"></c:set>
				<table align="center" id="cart_list" style="width: 100%;" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.detailBuyingItem}" var="buyingItem" varStatus="loop" >
						<tr>
							<td>	
								${buyingItem.pk_item}
							</td>
							<td>	
								${buyingItem.item_name}
							</td>
							<td>
								&mdash;	
							</td>
							<td>
								<c:if test="${empty buyingItem.fileSize}">&mdash;</c:if>
								${buyingItem.file_size}	
							</td>
							<td>
								${buyingItem.qty}	
							</td>
							<td style="text-align: right;">
								${buyingItem.harga}	
							</td>
							<td style="text-align: right;">
								${buyingItem.qty*buyingItem.harga}	
							</td>
							<td>	
								<a href="${contextPath}/action/cart?batal=&idx=${loop.index}">Retur</a>
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
				<span>
				<c:choose>
					<c:when test="${totalHarga>0}">
						<input type="button" value="         Bayar        " name="bayar" width="30px" id="bayar">
					</c:when>
					<c:otherwise>
						<input type="button" value="         Bayar        " name="bayar" width="30px" disabled="disabled">
					</c:otherwise>
				</c:choose>
				</span>
				<span>
						<input type="button" value="         Cancel       " name="cancel" width="30px" id="cancel">
				</span>
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
					$('#totalHarga').val('${totalHarga}');
					$('#dialog-confirm').dialog('open');
				});
				
				$('#cancel').click(function(){
					$('#dialog-confirm').dialog('close');
				});
				
				$('#cart_list').xytable({
					colModel: [   
								{name:'pkItem', label:'ID', field:'pk_item', hidden:true},
								{name:'nama', field:'nama', label: 'Nama'},        					        
					            {name:'publisher', label:'Publisher', field:'publisher'},
					            {name:'size', label:'File Size', field:'size'},
					            {name:'qty', label:'Qty', field:'qty'},
					            {name:'harga', label:'Harga', field:'harga'},
					            {name:'jumlah', label:'Jumlah', field:'jumlah'},
					            {name:'action', label:'Action', field:'action', width: 100}
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