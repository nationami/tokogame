$(function(){
/* handle the date and time */	
	var seconds = new Date().getSeconds();
	var minutes = new Date().getMinutes();
	var hours = new Date().getHours();
	
	//set the second for clock
	$("#sec").html(( seconds < 10 ? "0" : "" ) + seconds);
	//set the minute for clock
	$("#min").html(( minutes < 10 ? "0" : "" ) + minutes);
	//set the hours for clock
	$("#hours").html(( hours < 10 ? "0" : "" ) + hours);
	
	var monthNames = [ "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" ]; 
	var dayNames= ["Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"];
	
	var newDate = new Date();
	// Extract the current date from Date object
	newDate.setDate(newDate.getDate());
	// Output the day, date, month and year   
	//$('#date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());
	$('#date').html(newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());
	
	setInterval( function() {
		// Create a newDate() object and extract the seconds of the current time on the visitor's
		var seconds = new Date().getSeconds();
		// Add a leading zero to seconds value
		$("#sec").html(( seconds < 10 ? "0" : "" ) + seconds);
		},1000);
		
	setInterval( function() {
		// Create a newDate() object and extract the minutes of the current time on the visitor's
		var minutes = new Date().getMinutes();
		// Add a leading zero to the minutes value
		$("#min").html(( minutes < 10 ? "0" : "" ) + minutes);
	    },1000);
		
	setInterval( function() {
		// Create a newDate() object and extract the hours of the current time on the visitor's
		var hours = new Date().getHours();
		// Add a leading zero to the hours value
		$("#hours").html(( hours < 10 ? "0" : "" ) + hours);
		
		var newDate = new Date();
		// Extract the current date from Date object
		newDate.setDate(newDate.getDate());
		// Output the day, date, month and year   
		//$('#date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());
		$('#date').html(newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());
		
	    }, 1000);	
	
/* End handle the date and time */
	
/* Make the style of button */
	$( "input[type=submit], input[type=button], button" ).button();

/* End make the style of button */
	
/* Make button set */
	$("#button-set" ).buttonset();
	
/* End make button set */	
	
});

/* Function to open the dialog */	
function openDialog(name, primary){
	$('#primary_id').val(primary);
	$('#'+name).dialog("open");
};
/* End function to open the dialog */

