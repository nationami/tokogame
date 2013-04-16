<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Home">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
		<div class="content">
			<div>
			<a href="${contextPath}/action/productList"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="500px" height="200px" border="0"></a>
			</div>
			<div><label class="label-image">Belanja</label></div>
		</div>
		
		<div class="content">
			<div>
			<a href=""><img alt="image" src="${contextPath}/img/file_transfer.jpg" width="500px" height="200px" border="0"></a>
			</div>
			<div><label class="label-image">Ambil Pesanan</label></div>
		</div>
	</div>	
	</stripes:layout-component>
</stripes:layout-render>