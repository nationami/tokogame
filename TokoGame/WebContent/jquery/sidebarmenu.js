$(function(){
	$('.nav li').click(function(){
		$(this).parent().find('.active').removeClass('active');
		$(this).addClass('active');
	});
	
});