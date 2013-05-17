<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Admin Home">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
		<div class="content">
			<!-- First Line -->
			<div class="icon-gap">
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/userMaintenance"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">User</label>
					</span>
				</div>
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/pembayaran"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Bayar</label>
					</span>
				</div>
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/productList"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Laporan</label>
					</span>
				</div>
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/pembelian"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Beli</label>
					</span>
				</div>
			</div>
			
			
			<!-- Second Line -->
			<div class="icon-gap">
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/productList"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Item</label>
					</span>
				</div>
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/kategoriMaintenance"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Kategori</label>
					</span>
				</div>
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/koleksiMaintenance"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Koleksi</label>
					</span>
				</div>
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/opname"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Opname</label>
					</span>
				</div>
			</div>
			
			<!-- Third Line -->
			<div class="icon-gap">
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/promoMaintenance"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Promo</label>
					</span>
				</div>
				<div class="icon-menu-inline">
					<span>
						<a href="${contextPath}/action/konfigurasi"><img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="100px" height="100px" border="0"></a>
					</span>
					<span class="icon-menu-block"></span>
					<span>
						<label class="label-image">Konfigurasi</label>
					</span>
				</div>
			</div>
			
			
		</div>
		
	</div>	
	</stripes:layout-component>
</stripes:layout-render>