<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Product Detail">
  	<stripes:layout-component name="content">
	  	<div id="content-wrapper">
	  	<stripes:form action="/action/viewDetail" id="detail_form">
	  		<div align="left" class="title-info">
	  			<h3>${actionBean.item.itemName}</h3>
	  			<stripes:hidden name="itemId"/>
	  			<input type="hidden" name="harga" value="${actionBean.item.harga}"/>
	  		</div>
	  		<!-- menu left sidebar -->
			<div class="left-sided">
	  			<div>
					<ul class="list-down">
						<li>
							<img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="180px" height="180px" border="0">							
						</li>
						<li>
							<img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="180px" height="180px" border="0">							
						</li>
						<li>
							<img alt="image" src="${contextPath}/img/shopping_cart.jpg" width="180px" height="180px" border="0">							
						</li>
					</ul>
				</div>
	  		</div>
	  		
	  		<!-- menu center -->
	  		<div class="left-part video-box">
	  			<div>
					<ul class="list-down">
						<li>
							<video id="video_detail" class="video-js vjs-default-skin" controls preload="auto" width="800" height="360"
								data-setup="{}">
							    <source data-res="480" src="${contextPath}/video/LF-LC_An_Inside_Look.mp4" type='video/mp4' />
							    
							    
							 </video>
						</li>
						<li>
							<fieldset class="info-fieldset">
								<legend>Informasi Produk</legend>
								${actionBean.item.informasiProduk}
							</fieldset>							
						</li>
					</ul>
				</div>
	  		</div>
	  		
	  		<!-- menu right -->
	  		<div class="left-part requirement-padding">
	  			<div>
					<ul class="list-down">
						<li class="reqBox">
							${actionBean.item.informasiLain}							
						</li>
						<li></li>
						<li></li>
						<li></li>
						<li class="center-button" style="padding: 110px 0px 0px 0px">
							<strong>Harga : <fmt:formatNumber type="currency" currencySymbol="Rp" value="${actionBean.item.harga}"/></strong>
						</li>
						<li class="center-button" style="padding: 0px">
							<input type="submit" value="         Beli        " name="beli" width="30px">							
						</li>
					</ul>
				</div>
	  		</div>
	  	</stripes:form>	
	  	</div>
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {

			});
			
		</script>
	</stripes:layout-component>
	
</stripes:layout-render>