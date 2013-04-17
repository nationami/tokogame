<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="List Product">
  	<stripes:layout-component name="content">
	  	<div id="content-wrapper">
	  		<!-- menu left sidebar -->
			<div class="left-sided">
				<div class="menu-header">
					Koleksi
				</div>
				<div class="menu-content">
					<ul class="nav">
						<li>
							<a href="#">testing</a>
						</li>
						<li>
							<a href="#">testing2</a>
						</li>
					</ul>
				</div>
				
				<div>&nbsp;</div>
				
				<div class="menu-header">
					Kategori
				</div>
				<div class="menu-content">
					<ul class="nav">
						<li>
							<a href="#">testing</a>
						</li>
						<li>
							<a href="#">testing2</a>
						</li>
					</ul>
				</div>
			</div>
			
			<!-- main content -->
			<div class="main-content">
				<div>
					<span>
						<img alt="image" src="${contextPath}/img/shopping_banner.png" width="600px" height="150px" border="0">
					</span>
				</div>
				<div>&nbsp;</div>
				<div>
					<table align="center" id="product_list" width: 100%;">
						
					</table>
				</div>
			</div>
			
		</div>	
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {
				$('#product_list').xytable({
					colModel: [   
								{name:'itemId', label:'ID', field:'item_id', hidden:true}, 
								{name:'beli', field:'beli', label: 'Beli',width: 80},
								{name:'nama', field:'nama', label: 'Nama'},        					        
					            {name:'publisher', label:'Publisher', field:'publisher'},
					            {name:'update', label:'Update', field:'update'},
					            {name:'size', label:'File Size', field:'size'},
					            {name:'harga', label:'Harga', field:'harga'}
					        ],
					 pager: {
					            id:'pager_product',
					            base: '${contextPath}/action/productList',
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