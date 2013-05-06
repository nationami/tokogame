<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Koleksi Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="Delete Confirmation">Are you sure want to delete?</div>
		<div>
			<div align="right">
				<a href="${contextPath}/action/koleksiMaintenance?add="><img alt="image" src="${contextPath}/img/plus.png" width="50px" height="50px" border="0" title="Add"></a>
				<input type="hidden" name="primaryId"  id="primary_id">
			</div>
			<div>
				<table align="center" id="koleksi_list" style="width: 100%" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.listKoleksi}" var="koleksi" varStatus="loop" begin="${actionBean.offset}" end="${actionBean.offset+9}" step="1">
						<tr>
							<td>	
								${koleksi.pkKoleksi}
							</td>
							<td>	
								${koleksi.koleksiName}
							</td>
							<td>	
								<c:if test="${empty koleksi.koleksiDesc}">&mdash;</c:if>	
								${koleksi.koleksiDesc}
							</td>
							<td>
								<span>
									<a href="${contextPath}/action/koleksiMaintenance?edit=&koleksi.pkKoleksi=${koleksi.pkKoleksi}">Edit</a>
								</span>
								<span>
									<a href="#" onclick="openDialog('dialog-confirm',${koleksi.pkKoleksi});return false;">Delete</a>
								</span>	
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pager_koleksi"></div>
			
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
					buttons: {
						"Delete" : function(){
							window.location = '${contextPath}/action/koleksiMaintenance?delete=&koleksi.pkKoleksi='+$("#primary_id").val();
						},
						Cancel : function(){
							$(this).dialog("close");
						}
					}
					
				});
				
				$('#koleksi_list').xytable({
					colModel: [   
								{name:'pkKoleksi', label:'ID', field:'pk_koleksi', hidden:true}, 
								{name:'nama', field:'nama', label: 'Nama'},        					        
					            {name:'deskripsi', label:'Deskripsi', field:'deskripsi'},
					            {name:'action', label:'Action', field:'action',width: 120}
					        ],
					 pager: {
					            id:'pager_koleksi',
					            base: '${contextPath}/action/koleksiMaintenance',
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