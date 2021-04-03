<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/myproducttags.tld" prefix="producttag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Decor Shop</h1>
	<form action="shop.do" method="post">
		<input type="hidden" name="formid" value="shop">
		<input type="hidden" name="category" value="invoice">
		
		<producttag:item category="<%=request.getParameter(\"category\")%>" />
		
		
		
		
		<input type="submit" value="Invoice">
	</form>


</body>
</html>