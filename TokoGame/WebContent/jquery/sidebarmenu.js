$(function(){
	//for give highlight when click the menu list
	$('.nav li').click(function(){
		$(this).parent().find('.active').removeClass('active');
		$(this).addClass('active');
	});
	
	var koleksiId =$('#koleksiId').val();
	var kategoriId =$('#kategoriId').val();
	
	//for highlight the last menu that been choosen if the page refresh
	$('#koleksi'+koleksiId).parent().addClass('active');
	$('#kategori'+kategoriId).parent().addClass('active');
	
});