<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="List Product">
  	<stripes:layout-component name="content">
	  	<div id="content-wrapper">
	  	<stripes:form beanclass="${actionBean.class}" id="main_form">
	  		<!-- hidden value -->
	  		<stripes:hidden name="koleksiId" id="koleksiId"/>
	  		<stripes:hidden name="kategoriId" id="kategoriId"/>
	  		<stripes:hidden name="itemId" id="itemId"/>
	  	
	  		<!-- menu left sidebar -->
			<div class="left-sided">
				<div class="menu-header">
					Koleksi
				</div>
				<div class="menu-content">
					<ul class="nav">
						<li>
							<a href="${contextPath}/action/productList?koleksiId=0&kategoriId=${actionBean.kategoriId}" id="koleksi0">All</a>
						</li>
						<c:forEach items="${actionBean.listKoleksi}" var="koleksi">
						<li>
							<a href="${contextPath}/action/productList?koleksiId=${koleksi.pkKoleksi}&kategoriId=${actionBean.kategoriId}" id="koleksi${koleksi.pkKoleksi}">${koleksi.koleksiName}</a>
						</li>
						</c:forEach>
					</ul>
				</div>
				
				<div>&nbsp;</div>
				
				<div class="menu-header">
					Kategori
				</div>
				<div class="menu-content">
					<ul class="nav" >
						<li>
							<a href="${contextPath}/action/productList?koleksiId=${actionBean.koleksiId}&kategoriId=0" id="kategori0">All</a>
						</li>
						<c:forEach items="${actionBean.listKategori}" var="kategori">
						<li>
							<a href="${contextPath}/action/productList?koleksiId=${actionBean.koleksiId}&kategoriId=${kategori.pkKategori}" id="kategori${kategori.pkKategori}">${kategori.kategoriName}</a>
						</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			
			<!-- main content -->
			<div class="main-content">
				<div>
					<span>
						<img alt="image" src="${contextPath}/img/shopping_banner.png" width="100%" height="175px" border="0">
					</span>
				</div>
				<div class="top-gap">
					<span>
						<label>Search : </label>
						<input type="text" name="valueSearch" size="30" value="${actionBean.valueSearch}"/>
						<input type="submit" name="show" value="Submit"/>
					</span>
					<span class="right-part">
						<div id="button-set">
						    <stripes:radio id="1" name="criteria" value="new"/><label for="1">New</label>
						    <stripes:radio id="2" name="criteria" value="best"/><label for="2">Best</label>
						</div>
					</span>
				</div>
				<div class="top-gap">
					<table align="center" id="product_list" style="width: 100%" cellpadding="0" cellspacing="1">
						<c:forEach items="${actionBean.listItem}" var="item" varStatus="loop" begin="${actionBean.offset}" end="${actionBean.offset+9}" step="1">
							<tr class="item-click">
								<td>	
									${item.pkItem}
								</td>
								<td>
									<a href="#">Beli</a>
								</td>
								<td>	
									${item.itemName}
								</td>
								<td>	
									&mdash;
								</td>
								<td>	
									<fmt:formatDate value="${item.updatedDate}" pattern="dd-MMMM-yyyy"/>
								</td>
								<td>	
									<c:if test="${empty item.fileSize}">&mdash;</c:if>
									${item.fileSize}
								</td>
								<td>	
									${item.harga}
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div id="pager_product"></div>
			</div>
			
		</stripes:form>	
		</div>	
	</stripes:layout-component>
	
	<stripes:layout-component name="init">
		<script>
			$(function() {
				$('#product_list').xytable({
					colModel: [   
								{name:'itemId', label:'ID', field:'itemId', hidden:true}, 
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
				
				//alert($('#main_form').attr('action'));
				
				$("#1").click(function(){
					$('#main_form').submit();
					
				});
				
				$("#2").click(function(){
					$('#main_form').submit();
					
				});
				
				if('${actionBean.criteria}'!=""){
					if('${actionBean.criteria}'=="new"){
						$('#1').next().addClass('ui-state-active');
					}
					else if('${actionBean.criteria}'=="best"){
						$('#2').next().addClass('ui-state-active');
					}
				}
				
				$(".item-click").click(function(){
					$("#main_form").attr("action",$("#main_form").attr("action")+"?viewDetail=");
					$('#main_form').submit();
				});
				
			});
		</script>
	</stripes:layout-component>
</stripes:layout-render>