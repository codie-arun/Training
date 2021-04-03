<%@page import="java.util.Enumeration" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="/WEB-INF/mylisttag.tld" prefix="productlist" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Thanks for shopping</h1>

	<productlist:list  />
	
	<form action="Confirm.do" method="post">
		<input type="hidden" name="formid" value="confirm">
		
		<input type="submit" value="Confirm my order">
	</form>
	
	<form action="pdf.do" method="post">
		<input type="hidden" name="formid" value="pdf">
		
		<input type="submit" value="Download Pdf">
	</form>
	
	<form action="excel.do" method="post">
		<input type="hidden" name="formid" value="excel">
		
		<input type="submit" value="Download Excel">
	</form>
	
	<form action="mail.do" method="post">
		<input type="hidden" name="formid" value="mail">
		
		<input type="submit" value="Send Mail">
	</form>
	
	<form action="pay.do" method="post">
		<input type="hidden" name="formid" value="pay">
		
		<input type="submit" value="Checkout to Pay">
	</form>

</body>
</html>