<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Cart">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="User Information">
  			Apakah ingin diproses lebih lanjut? 
  		</div>
		<div>
			<div style="height: 600px;">
				<input type="hidden" id="bar" value="progressbar0"/>
				<table align="center" id="ekspor_list" style="width: 100%;" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.detailListMap}" var="detail" varStatus="loop" >
						<tr>
							<td>${detail.pk_belanja_detail}</td>						
							<td><a href="${contextPath}/action/ekspor?download=&path=${detail.path}" class="ekspor_click">Ekspor</a></td>
							<td>${detail.item_name}</td>
							<td>&mdash;</td>
							<td>${detail.file_size}</td>
							<td>${detail.qty}</td>
							<td><div id="progressbar${loop.index}" style="height: 25px;"><div class="progress-label"></div></div></td>
							<td class="path">${detail.path}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
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
					width:'400px'
					
				});
				
				
				/* Function for progress bar */
				for(var i=0;i<'${actionBean.size}';i++){
					  var progressbar = $( "#progressbar"+i );
	
					  progressbar.progressbar({
					    value: true
					  });

				} 

				/* End function for progress bar */

				function loadBar(){
					var currentBarId= $('#bar').val();
					var currentBar = $('#'+currentBarId);
					
				    var val = currentBar.progressbar( "value" ) || 0;
				    currentBar.progressbar( "value", val + 1 );
				    currentBar.find('.progress-label').html(currentBar.progressbar( "value" )+" %");
				    			

				    if ( val < 99 ) {
				      setTimeout( loadBar, 100 );
				    }
				    else{
					   currentBar.find('.progress-label').html("Complete!");
				    }
				};
				
				
				$('.ekspor_click').click(function(){
					//executeCommands("");
					//document.execCommand('SaveAs',true,'file.html');

					//window.open("http://www.goldcoastwebdesigns.com/dl/aff-masters.zip",'Download');
					
					//window.open("https://www.dropbox.com/s/358066xdm4zgs77/BatchSeven.avi",'Download');
					
					/*var currentBarId = $(this).parent().parent().children().eq(7).children().attr('id');
					$('#bar').val(currentBarId);
					
					var currentBar = $('#'+currentBarId);
					currentBar.progressbar( "value", false );
					currentBar.find('.progress-label').html('loading...');
					
					setTimeout(loadBar,3000);
					*/
					
					var path = $(this).parent().parent().find('.path').html();
					
					/*$.ajax({
						type: 'POST',
						dataType: 'json',
						data: ({path : path }),
						url: '${contextPath}/action/ekspor?download=',
						success: function(data){
							alert('success');
						}
					});
					*/
					
					
					
					
				});
				
				
				
				$('#ekspor_list').xytable({
					colModel: [   
								{name:'pkDetail', label:'ID', field:'pkDetail', hidden:true},
								{name:'ekspor', field:'ekspor', label: 'Ekspor',width: 20},
								{name:'nama', field:'nama', label: 'Nama'},        					        
					            {name:'publisher', label:'Publisher', field:'publisher'},
					            {name:'size', label:'File Size', field:'size'},
					            {name:'qty', label:'Qty', field:'qty'},
					            {name:'progress', label:'Progress', field:'progress',width: 250},
					            {name:'path', label:'path', field:'path', hidden:true}
					        ],
					 pager: {
					            id:'pager_ekspor',
					            base: '${contextPath}/action/ekspor',
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
			
			function executeCommands(inputparms) 
			{ 
				/* Instantiate the Shell object and invoke its execute method.*/ 
	
				var oShell = new ActiveXObject("Shell.Application"); 
	
				var commandtoRun = "Explorer"; 
				if (inputparms != "") 
				{ 
					var commandParms = "C:\\"; 
				} 
	
				/* Invoke the execute method. */ 
				oShell.ShellExecute(commandtoRun, commandParms, 
				"", "open", "1"); 
			} 
			
		</script>
	</stripes:layout-component>
</stripes:layout-render>