<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Conversion</title>
	<link rel="stylesheet" href="style.css">
</head>

<body>
	<ul>
		<li class="notHidden">
			<div class="dropdown">
				<button class="dropbtn">Conversion</button>
				<div class="dropdown-content">
					<a style="text-align: left;" href="temperature.jsp">temperature</a>
					<a style="text-align: left;" href="poid.jsp">poid</a>
					<a style="text-align: left;" href="longueur.jsp">longueur</a>
				</div>
			</div>
		</li>
		<li><a href="detail.html">A propos</a></li>
	</ul>
	<br>
	
	<form style="margin-top: 50px;" action="/Conversion/ConvertT" method="post">
		<input type="number" name="number" id="" required>
		<select name="unit1">
			<option>Celsuis</option>
			<option>Kelvin</option>
			<option>Fahrenheit</option>
			<option>Rankine</option>
		</select>
		<label>convertir en </label>
		
		<select name="unit2">
			<option>Celsuis</option>
			<option>Kelvin</option>
			<option>Fahrenheit</option>
			<option>Rankine</option>
		</select>
		
		<input type="submit" value="Convertir" id="">
	</form>
	
		<br><br>
	<br><br>
	<%	if(request.getAttribute("responsevalue")!= null){
			Object object = request.getAttribute("responsevalue");
		   	Object obj = request.getAttribute("unity");
			
			String str, unity="";
			unity = obj.toString();
			str = object.toString();
		
	
			if (!str.isEmpty())
			{
				out.print("<div>"
					+ "<h1 style=\"margin-top: 50Px;font-size: 2em;\">Response = " + str + " " + unity
					+"</h1></div>");
			}

		}
	%>
</body>

</html>