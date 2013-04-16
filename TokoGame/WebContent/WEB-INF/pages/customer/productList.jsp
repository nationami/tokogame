<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Home">
  	<stripes:layout-component name="content">
	  	<div id="content-wrapper">
			<div class="left-sided">
				<table border="1" cellspacing="0" cellpadding="0" width="100px">
					<thead>
					<tr>
						<th>
							Koleksi
						</th>
					</tr>
					</thead>
					
					<tbody>
					<c:forEach items="${actionBean.listKoleksi}" var="koleksi">
					<tr>
						<td>
							${koleksi.koleksiName}
						</td>
					</tr>
					</tbody>
					</c:forEach>
				</table>	
			</div>
			<div>
			
			</div>			
		</div>	
	</stripes:layout-component>
</stripes:layout-render>