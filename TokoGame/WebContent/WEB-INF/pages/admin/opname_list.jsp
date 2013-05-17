<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Opname">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="Delete Confirmation">Are you sure want to delete?</div>
		<div>
			<div class="right-part">
				<a href="${contextPath}/action/opname?add="><img alt="image" src="${contextPath}/img/plus.png" width="50px" height="50px" border="0" title="Add"></a>
				<input type="hidden" name="primaryId"  id="primary_id">
			</div>
			<div>
				<table align="center" id="main_opname_list" style="width: 100%" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.listOpname}" varStatus="loop" var="opname" begin="${actionBean.offset}" end="${actionBean.offset+9}" step="1">
						<tr>
							<td>${opname.pkOpname}</td>
							<td><fmt:formatDate value="${opname.tanggalOpname}" pattern="dd-MMMM-yyyy HH:mm:ss"/></td>
							<td>${opname.totalSelisih}</td>
							<td>${opname.totalBiaya}</td>
							<td>
								<span>
									<a href="${contextPath}/action/opname?cetak=&opname.pkOpname=${opname.pkOpname}">Cetak</a>
								</span>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pager_main_opname_list"></div>
			
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
							window.location = '${contextPath}/action/opname?delete=&promoMain.pkPromoMain='+$("#primary_id").val();
						},
						Cancel : function(){
							$(this).dialog("close");
						}
					}
					
				});
				
				$('#main_opname_list').xytable({
					colModel: [   
								{name:'pkOpname', label:'ID', field:'pkOpname', hidden:true}, 
					            {name:'tanggal', label:'Tanggal Opname', field:'tanggal'},
					            {name:'totalSelisih', label:'Total Selisih', field:'totalSelisih'},
					            {name:'totalBiaya', label:'Total Biaya', field:'totalBiaya'},
					            {name:'action', label:'Action', field:'action',width: 120}
					        ],
					 pager: {
					            id:'pager_main_opname_list',
					            base: '${contextPath}/action/opname',
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