<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reversal</title>
<link rel="stylesheet" type="text/css" href="css/phone.css">
</head>
<body>
	<form method="post" action="Reversal">
		<h2>Transaction Status</h2>
		<label for="phonenum">Transaction Id (format: OGS81HCFJ4):</label><br />
		<input id="TransactionID" name="TransactionID" type="text"  required>

		<input type="submit" value="Send">
	</form>
</body>
</html>