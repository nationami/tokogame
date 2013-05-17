<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Pembelian Item">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="Delete Confirmation">Are you sure want to delete?</div>
		<div>
			<div class="right-part">
				<a href="${contextPath}/action/pembelian?add="><img alt="image" src="${contextPath}/img/plus.png" width="50px" height="50px" border="0" title="Add"></a>
				<input type="hidden" name="primaryId"  id="primary_id">
			</div>
			<div>
				<table align="center" id="pembelian_list" style="width: 100%" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.listPembelian}" varStatus="loop" var="beli" begin="${actionBean.offset}" end="${actionBean.offset+9}" step="1">
						<tr>
							<td>${beli.pk_pembelian}</td>
							<td>${beli.nota}</td>
							<td>${beli.supplier}</td>
							<td><fmt:formatDate value="${beli.tanggal_beli}" pattern="dd-MMMM-yyyy HH:mm:ss"/></td>
							<td>${beli.item_list}</td>
							<td>
								<span>
									<a href="${contextPath}/action/pembelian?edit=&pembelian.pkPembelian=${beli.pk_pembelian}">Edit</a>
								</span>
								<span>
									<a href="#" onclick="openDialog('dialog-confirm',${beli.pk_pembelian});return false;">Delete</a>
								</span>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pager_pembelian"></div>
			
		</div>
	</div>	
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {
				$('#dialog-confirm').dialog({
					modal: true,
					autoOpen: false,
					buttons: {
						"Delete" : function(){
							window.location = '${contextPath}/action/pembelian?delete=&pembelian.pkPembelian='+$("#primary_id").val();
						},
						Cancel : function(){
							$(this).dialog("close");
						}
					}
					
				});
				
				$('#pembelian_list').xytable({
					colModel: [   
								{name:'pkPembelian', label:'ID', field:'pkPembelian', hidden:true}, 
								{name:'nota', field:'nota', label: 'Nota',width: 300},        					        
					            {name:'suplier', label:'Suplier', field:'suplier',width: 250},
					            {name:'tanggal', label:'Tanggal', field:'tanggal',width: 300},
					            {name:'item', label:'Item', field:'item'},
					            {name:'action', label:'Action', field:'action',width: 120}
					        ],
					 pager: {
					            id:'pager_pembelian',
					            base: '${contextPath}/action/pembelian',
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