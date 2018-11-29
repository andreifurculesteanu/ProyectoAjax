<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function dameProvincias(){
		
		var datos = document.getElementById("comunidad").value;
		
		var xmlhttp;  // objeto XMLHttpRequest
	       if (window.XMLHttpRequest) {  // para IE7+, Firefox, Chrome, Opera, Safari
	           xmlhttp = new XMLHttpRequest();
	       } else {  // para IE6, IE5
	          xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	       }
		
	    xmlhttp.onreadystatechange = function() {
	    	// si el resultado está listo (readyState==4) y la respuesta es correcta (status==200)
	       if (xmlhttp.readyState==4 && xmlhttp.status==200) {
	    	   var respuesta = xmlhttp.responseText;

	    	   
	    	   
	       }
	    }
	    xmlhttp.open("GET","CompruebaUsuario?" + datos ,true);  // crea la conexión con parámetros: método, url, asíncrono?
	    xmlhttp.setRequestHeader("X-Requested-With", "xmlhttprequest");  // establece la cabecera HTTP necesaria
	    xmlhttp.send();  // lanza la solicitud
	}

</script>



</head>
<body onLoad="dameProvincias();">
	
	<h1> Comunidades Autónomas de España </h1>
	
	
	<select id="comunidad" size="5">
	  <option value="Andalucia">Andalucia</option>
	  <option value="Aragon">Asturias</option>
	  <option value="Baleares">Baleares</option>
	  <option value="Canarias">Canarias</option>
	  <option value="Cantabria">Cantabria</option>
	  <option value="Castilla la Mancha">Castilla la Mancha</option>
	  <option value="Castilla y Leon">Castilla y Leon</option>
	  <option value="Cataluña">Cataluña</option>
	  <option value="Comunidad Valenciana">Comunidad Valenciana</option>
	  <option value="Extremadura">Extremadura</option>
	  <option value="Galicia">Galicia</option>
	  <option value="Madrid">Madrid</option>
	  <option value="Murcia">Murcia</option>
	  <option value="Navarra">Navarra</option>
	  <option value="Pais Vasco">Pais Vasco</option>
	  <option value="La Rioja">La Rioja</option>
	</select>

</body>
</html>