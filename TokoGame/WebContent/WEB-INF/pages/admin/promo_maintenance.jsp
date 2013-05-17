<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Promo Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="Delete Confirmation">Are you sure want to delete?</div>
		<div>
			<div class="right-part">
				<a href="${contextPath}/action/promoMaintenance?add="><img alt="image" src="${contextPath}/img/plus.png" width="50px" height="50px" border="0" title="Add"></a>
				<input type="hidden" name="primaryId"  id="primary_id">
			</div>
			<div>
				<table align="center" id="promo_list" style="width: 100%" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.listPromoMainMap}" var="promoMain" varStatus="loop" begin="${actionBean.offset}" end="${actionBean.offset+9}" step="1">
						<tr>
							<td>	
								${promoMain.pk_promo_main}
							</td>
							<td>	
								${promoMain.promo_name}
							</td>
							<td>	
								<c:if test="${empty promoMain.promo_desc}">&mdash;</c:if>	
								${promoMain.promo_desc}
							</td>
							<td>	
								${promoMain.item_list}
							</td>
							<td>
								<span>
									<a href="${contextPath}/action/promoMaintenance?edit=&promoMain.pkPromoMain=${promoMain.pk_promo_main}">Edit</a>
								</span>
								<span>
									<a href="#" onclick="openDialog('dialog-confirm',${promoMain.pk_promo_main});return false;">Delete</a>
								</span>	
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pager_promo"></div>
			
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
							window.location = '${contextPath}/action/promoMaintenance?delete=&promoMain.pkPromoMain='+$("#primary_id").val();
						},
						Cancel : function(){
							$(this).dialog("close");
						}
					}
					
				});
				
				$('#promo_list').xytable({
					colModel: [   
								{name:'pkPromoMain', label:'ID', field:'pkPromoMain', hidden:true}, 
								{name:'nama', field:'promo_name', label: 'Nama'},        					        
					            {name:'deskripsi', label:'Deskripsi', field:'promo_desc'},
					            {name:'item', label:'Item', field:'item'},
					            {name:'action', label:'Action', field:'action',width: 120}
					        ],
					 pager: {
					            id:'pager_promo',
					            base: '${contextPath}/action/promoMaintenance',
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