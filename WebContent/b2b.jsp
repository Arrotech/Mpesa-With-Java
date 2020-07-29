<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>B2B</title>
<link rel="stylesheet" type="text/css" href="css/phone.css">
</head>
<body>
	<form method="post" action="B2B">
		<h2>Enter Account Number</h2>
		<label for="phonenum">Account Number (format: 176349):</label><br />
		<input id="PartyB" name="PartyB" type="tel" pattern="^\d{3}\d{3}\d{3}\d{3}$" required>

		<input type="submit" value="Send">
	</form>
</body>
</html>