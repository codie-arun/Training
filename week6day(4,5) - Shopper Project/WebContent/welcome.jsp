<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <%= session.getAttribute("uname") %></h1>
	<form action="logout.do" method="post">
	<input type="hidden" name="formid" value="logout">
		
		<input type="submit" value="logout...">
	</form>
	
	
	<form action="shopping.do" method="post">
		<input type="hidden" name="formid" value="shopping">
		<input type="hidden" name="category" value="grocery">
		<input type="submit" value="Go to shop">
	
	</form>
	
	
</body>
</html>