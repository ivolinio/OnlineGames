$().ready(function(){
	
	$("textarea").val('');
		$("#reset").click(function(){
		$("#textarea").val("");
		$("#textarea").slideUp(500).delay(300).slideDown(500)
		
		//alert("All the choices are reset");
	});
	$('#select').on('click', function(){
		var currentValue = $("#textarea").val();
		var toAdd = $('#list').val();
		
		if(currentValue != undefined && currentValue != "")
		{
			toAdd = currentValue  + "\n" + toAdd;
		}
		$("#textarea").val(toAdd);
		
	});
	
	// upload image
	window.addEventListener('load', function() {
  document.querySelector('input[type="file"]').addEventListener('change', function() {
      if (this.files && this.files[0]) {
          var img = document.querySelector('img');  // $('img')[0]
          img.src = URL.createObjectURL(this.files[0]); // set src to blob url
          img.onload = imageIsLoaded;
      }
  });
});

function imageIsLoaded() { 
  alert(this.src);  // blob url
  // update width and height ...
}
});



