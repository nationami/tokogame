<%@ include file="/WEB-INF/pages/taglibs.jsp" %>
<stripes:layout-render name="/WEB-INF/pages/layout.jsp" title="Opname">
  	<stripes:layout-component name="content">
  	<div id="content-wrapper">
  		<div id="dialog-confirm" title="User Information">
  			<stripes:form action="/action/opname" id="valid_form">
  			Apakah ingin diproses lebih lanjut? 
			</stripes:form>
  		</div>
		<div>
		<stripes:form action="/action/opname" id="opname_form">
			<div style="height: 600px;">
				
				<table align="center" id="opname_list" style="width: 100%;" cellpadding="0" cellspacing="1">
					<c:forEach items="${actionBean.listItem}" var="items" varStatus="loop">
						<tr>
							<td>${items.pkItem}</td>
							<td class="hargaItem">${items.harga}</td>
							<td>${items.itemName}</td>
							<td class="qty">${items.itemQty}</td>
							<td class="fisik"><input type="text" class="validation-number" name="fisik" /></td>
							<td class="selisih">0</td>
							<td class="harga">0</td>
							<td class="jumlah">0</td>
						</tr>
					</c:forEach>
				</table>
				<table style="width: 100%; text-align: right;" cellpadding="1" cellspacing="1">
						<tr>
							<td>
								Total	
							</td>
							<td style="border: 1px solid #000000; background-color: white;" width="250">
								<input type="text" readonly="readonly" size="40" id="totalHarga" style="text-align: right;" name="opname.totalBiaya"/>	
							</td>
						</tr>
				</table>
			</div>
			<div align="left">
				<input type="hidden" id="totalSelisih" name="opname.totalSelisih"/>			
				<input type="submit" value="         Proses        " name="proses" width="30px" id="proses">	
			</div>
			</stripes:form>
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
				
				
				$('.fisik').keyup(function(e){
					//get event function press
					var code;
					if(!e) var e = window.event;
					if(e.keyCode) code = e.keyCode;
					else if(e.which) code = e.which;
					
					//regex just accept number
					var pola = "[0-9]";
					var rx = new RegExp(pola);
					var obj = $(this).find('input').val();
					if(obj.match(rx) || code == 8 || code == 46){
						var qty = $(this).parent().find('.qty').html();
						var selisih = obj-qty;
						$(this).parent().find('.selisih').html(selisih);
						if(selisih<0){
							var hargaItem = $(this).parent().find('.hargaItem').html();
							var harga = (Math.abs(selisih))*hargaItem;
							$(this).parent().find('.harga').html(0-hargaItem);
							$(this).parent().find('.jumlah').html(0-harga);
						}
						
						var rowCount = ($('#opname_list tbody tr').length);
						var totalHarga = 0;
						var totalSelisih = 0;
						
						for(var i=0;i<rowCount;i++){
							var jumlah = $('#opname_list tbody').children().eq(i).find('.jumlah').html();
							var selisih = $('#opname_list tbody').children().eq(i).find('.selisih').html();
							totalHarga = totalHarga + parseInt(jumlah);
							totalSelisih = totalSelisih + parseInt(selisih);
						}
						
						$('#totalHarga').val(totalHarga);
						$('#totalSelisih').val(totalSelisih);
					}
				});
				
				$('#opname_list').xytable({
					colModel: [   
								{name:'pkItem', label:'ID', field:'pk_item', hidden:true},
								{name:'hargaItem', label:'Harga Item', field:'hargaItem', hidden:true},
								{name:'nama', field:'nama', label: 'Nama Item'},
								{name:'qty', label:'Qty', field:'qty'},
								{name:'fisik', label:'Fisik', field:'fisik'},
					            {name:'selisih', label:'Selisih', field:'selisih'},
					            {name:'harga', label:'Harga Jual', field:'harga',width: 250},
					            {name:'jumlah', label:'Jumlah', field:'jumlah',width: 270}
					        ],
					 pager: {
					            id:'pager_opname',
					            base: '${contextPath}/action/opname',
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