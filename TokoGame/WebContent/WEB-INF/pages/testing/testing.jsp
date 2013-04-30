<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Product Detail">
  	<stripes:layout-component name="content">
	  	<div id="content-wrapper">

	  		
	  		<!-- menu center -->
	  		<div class="">
	  			<div>
	  					<button onclick="playPause()">Play/Pause</button> 
	  					<br/>
					    <video id="videoDetail">
					    	<source src="${contextPath}/video/LF-LC_An_Inside_Look.mp4" type="video/mp4"> 
					      	Your broser does not support the html 5 video
					    </video>  							
						
				</div>
	  		</div>
	  		
	  		
	  		
	  	</div>
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			
			var myvideo = document.getElementById("videoDetail");
			
			function playPause(){
				if(myvideo.paused){
					myvideo.play();
				}
				else{
					myvideo.pause();
				}
			}
			
		</script>
		
		<style type="text/css">       
		    
    
    	</style>
	</stripes:layout-component>
	
</stripes:layout-render>