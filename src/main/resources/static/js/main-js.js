/*<![CDATA[*/

$("#deleteHotel").click(function() {

	alert("Delete clicked");
});

$("#primary").click(function() {

	alert("primary clicked");
});

/* ]]> */


<script type="text/javascript" th:inline="javascript">
/*<![CDATA[*/

function getContextPath() {
var ctx = window.location.pathname,
path = '/' !== ctx ? ctx.substring(0, ctx.indexOf('/', 1) + 1) : ctx;
return path + (/\/$/.test(path) ? '' : '/');
}	
	
	
$("#primary").click(function() {

alert("primary clicked");
});

function change(object, name, pricePerNight,id){
alert(name+" "+pricePerNight+" "+id);
$.ajax({
	type : "DELETE",
	data : {
		'id' : id
	}
url : getContextPath() + "/hotels/"
});
}
	
/*]]>*/
</script>