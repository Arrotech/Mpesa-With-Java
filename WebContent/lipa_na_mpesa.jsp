<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lipa Na Mpesa</title>
<link rel="stylesheet" type="text/css" href="css/phone.css">
</head>
<body>
	<form method="post" action="LipaNaMpesaPayment">
		<h2>Enter Paybill Number</h2>
		<label for="phonenum">Paybill (format: 174379):</label><br />
		<input id="PartyB" name="PartyB" type="text" required>

		<input type="submit" value="Send">
	</form>
</body>
</html>