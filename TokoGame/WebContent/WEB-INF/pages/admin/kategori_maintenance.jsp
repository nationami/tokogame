<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Kategori Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="Delete Confirmation">Are you sure want to delete?</div>
		<div>
			<div class="right-part">
				<a href="${contextPath}/action/kategoriMaintenance?add="><img alt="image" src="${contextPath}/img/plus.png" width="50px" height="50px" border="0" title="Add"></a>
				<input type="hidden" name="primaryId"  id="primary_id">
			</div>
			<div>
				<table align="center" id="kategori_list" style="width: 100%" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.listKategori}" var="kategori" varStatus="loop" begin="${actionBean.offset}" end="${actionBean.offset+9}" step="1">
						<tr>
							<td>	
								${kategori.pkKategori}
							</td>
							<td>	
								${kategori.kategoriName}
							</td>
							<td>	
								<c:if test="${empty kategori.kategoriDesc}">&mdash;</c:if>	
								${kategori.kategoriDesc}
							</td>
							<td>
								<span>
									<a href="${contextPath}/action/kategoriMaintenance?edit=&kategori.pkKategori=${kategori.pkKategori}">Edit</a>
								</span>
								<span>
									<a href="#" onclick="openDialog('dialog-confirm',${kategori.pkKategori});return false;">Delete</a>
								</span>	
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pager_kategori"></div>
			
		</div>
	</div>	
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {
				$('#kategori_list').xytable({
					colModel: [   
								{name:'pkKategori', label:'ID', field:'pk_kategori', hidden:true}, 
								{name:'nama', field:'kategori_name', label: 'Nama'},        					        
					            {name:'deskripsi', label:'Deskripsi', field:'kategori_desc'},
					            {name:'action', label:'Action', field:'action',width: 120}
					        ],
					 pager: {
					            id:'pager_kategori',
					            base: '${contextPath}/action/kategoriMaintenance',
					            param: {},
					            page: '${actionBean.page}',
					            records: '${actionBean.size}',
					            rows: 10
					         },
					        sorter: false,		
					        multiple: false,				
				            checkRow: false
				        	
				});
				
				$('#dialog-confirm').dialog({
					modal: true,
					autoOpen: false,
					buttons: {
						"Delete" : function(){
							window.location = '${contextPath}/action/kategoriMaintenance?delete=&kategori.pkKategori='+$("#primary_id").val();
						},
						Cancel : function(){
							$(this).dialog("close");
						}
					}
					
				});
					
				
			});
			
		</script>
	</stripes:layout-component>
</stripes:layout-render>