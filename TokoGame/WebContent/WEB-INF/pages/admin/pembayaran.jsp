<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Pembayaran">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="User Information">
  			
  		</div>
		<div>
			<div style="height: 600px;">
				<c:set var="totalHarga" value="0"></c:set>
				<table align="center" id="cart_list" style="width: 100%;" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.buyingItem}" var="buyingItem" varStatus="loop" begin="${actionBean.offset}" end="${actionBean.offset+9}" step="1">
						<tr>
							<td>	
								${buyingItem.pk_belanja}
							</td>
							<td>	
								${buyingItem.kode_belanja}
							</td>
							<td>	
								${buyingItem.name}
							</td>
							<td>	
								${buyingItem.handphone}
							</td>
							<td>	
								${buyingItem.address}
							</td>
							<td>
								${buyingItem.total_item}	
							</td>
							<td>
								${buyingItem.total_harga}	
							</td>
							<td>
								${buyingItem.status}	
							</td>
							<td>
								<span>
									<a href="${contextPath}/action/pembayaran?detail=&belanja.pkBelanja=${buyingItem.pk_belanja}">Detail</a>
								</span>
								<c:if test="${buyingItem.status=='BAYAR'}">
								<span>
									<a href="#">Cetak</a>
								</span>	
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pager_cart"></div>
			
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
				
				
				$('#cart_list').xytable({
					colModel: [   
								{name:'pkBelanja', label:'ID', field:'pk_belanja', hidden:true},
								{name:'kodeBelanja', field:'kodeBelanja', label: 'Kode Pembelian'},
								{name:'nama', field:'nama', label: 'Nama'},
								{name:'handphone', field:'handphone', label: 'Handphone'},
								{name:'alamat', field:'alamat', label: 'Alamat'},
								{name:'totalItem', field:'totalItem', label: 'Total Item'},        					        
					            {name:'totalHarga', label:'Total Harga', field:'totalHarga'},
					            {name:'status', label:'Status', field:'status'},
					            {name:'action', label:'Action', field:'action',width: 150}
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