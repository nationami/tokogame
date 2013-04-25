<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Product Detail">
  	<stripes:layout-component name="content">
	  	<div id="content-wrapper">

	  		
	  		<!-- menu center -->
	  		<div class="">
	  			<div>
					
							 <video id="Video1" controls loop autoplay >
						          <source src="${contextPath}/video/LF-LC_An_Inside_Look.mp4" type="video/mp4" />           
						      </video>
						      
						      <video id="Video2" muted autoplay controls >
						          <source src="${contextPath}/video/LF-LC_An_Inside_Look.mp4" type="video/mp4" />
						          HTML5 Video not supported
						      </video>   							
						
				</div>
	  		</div>
	  		
	  		
	  		
	  	</div>
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {

			});
			
		</script>
		
		<style type="text/css">       
		    #Video1
		    {
		     position:absolute;
		     top: 50px;
		     left:0px;        
		     width:1000px;       
		     border:2px solid blue;
		     display:block;
		     z-index:99;
		     }
		        
		   #Video2
		    {
		     position:absolute;
		     top:80px;
		     left:60px;
		     width:300px;
		     border:2px solid red;        
		     z-index:100;
		    }
    
    	</style>
	</stripes:layout-component>
	
</stripes:layout-render>