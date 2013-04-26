<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Product Detail">
  	<stripes:layout-component name="content">
	  	<div id="content-wrapper">
	  		<!-- menu left sidebar -->
			<div class="left-sided" style="padding-left: 100px;">
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
							<video id="video_detail" class="video-js vjs-default-skin" controls preload="none" width="640" height="264"
								      data-setup="{}">
							    <source src="${contextPath}/video/LF-LC_An_Inside_Look.mp4" type='video/mp4' />
							    <source src="http://video-js.zencoder.com/oceans-clip.webm" type='video/webm' />
							    <source src="http://video-js.zencoder.com/oceans-clip.ogv" type='video/ogg' />
							    <track kind="captions" src="captions.vtt" srclang="en" label="English" />
							 </video>						
						</li>
						<li>
							<fieldset class="info-fieldset">
								<legend>Informasi Produk</legend>
								Ini merupakan game terbaru dengan daya tarik yang tinggi.
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
							testing							
						</li>
						<li></li>
						<li></li>
						<li></li>
						<li class="center-button" style="padding: 18px 0px 0px 0px">
							Harga : Rp50000,-
						</li>
						<li class="center-button" style="padding: 0px">
							<input type="submit" value="         Beli        " name="beli" width="30px">							
						</li>
					</ul>
				</div>
	  		</div>
	  		
	  	</div>
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {

			});
			
		</script>
	</stripes:layout-component>
	
</stripes:layout-render>