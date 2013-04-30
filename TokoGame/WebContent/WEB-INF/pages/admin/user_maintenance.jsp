<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="User Maintenance">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="Delete Confirmation">Are you sure want to delete?</div>
		<div>
			<div align="right">
				<a href="${contextPath}/action/userMaintenance?add="><img alt="image" src="${contextPath}/img/plus.png" width="50px" height="50px" border="0" title="Add"></a>
				<input type="hidden" name="primaryId"  id="primary_id">
			</div>
			<div>
				<table align="center" id="user_list" style="width: 100%" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.listUser}" var="user" varStatus="loop" begin="${actionBean.offset}" end="${actionBean.offset+9}" step="1">
						<tr>
							<td>	
								${user.userId}
							</td>
							<td>	
								${user.userLogin}
							</td>
							<td>	
								<c:if test="${empty user.role}">&mdash;</c:if>	
								${user.role}
							</td>
							<td>
								${user.active}
							</td>
							<td>
								<span>
									<a href="${contextPath}/action/userMaintenance?edit=&user.userId=${user.userId}">Edit</a>
								</span>
								<span>
									<a href="#" onclick="openDialog('dialog-confirm',${user.userId});return false;">Delete</a>
								</span>	
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div id="pager_user"></div>
			
		</div>
	</div>	
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {
				$('#user_list').xytable({
					colModel: [   
								{name:'userId', label:'ID', field:'userId', hidden:true}, 
								{name:'userLogin', field:'userLogin', label: 'UserLogin'},        					        
					            {name:'role', label:'Role', field:'role'},
					            {name:'active', label:'Active', field:'active'},
					            {name:'action', label:'Action', field:'action',width: 120}
					        ],
					 pager: {
					            id:'pager_user',
					            base: '${contextPath}/action/userMaintenance',
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
							window.location = '${contextPath}/action/userMaintenance?delete=&user.userId='+$("#primary_id").val();
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