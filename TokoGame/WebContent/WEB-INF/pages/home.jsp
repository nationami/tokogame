<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Home">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="Code Information">
  			Kode pembelian anda "${actionBean.code}" mohon diingat untuk melakukan pembayaran di kasir.
  		</div>	
		<div class="content">
			<div>
			<a href="${contextPath}/action/productList"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="500px" height="200px" border="0"></a>
			</div>
			<div><label class="label-image">Belanja</label></div>
		</div>
		
		<div class="content">
			<div>
			<a href="${contextPath}/action/authentication"><img alt="image" src="${contextPath}/img/file_transfer.jpg" width="500px" height="200px" border="0"></a>
			</div>
			<div><label class="label-image">Ambil Pesanan</label></div>
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
					width:'400px',
					buttons: {
						"Ok" : function(){
							$(this).dialog("close");
						}
					}
					
				});
				
				if('${actionBean.code}'!=''){
					$('#dialog-confirm').dialog('open');
				}
			});
		</script>	
	</stripes:layout-component>
</stripes:layout-render>