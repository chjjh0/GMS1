<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<!-- "oracle.jdbc.driver.OracleDriver" -->
<!-- "jdbc:oracle:thin:@localhost:1521:xe","chjjh0", "c1c2" -->
<%
	
%>		
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>userLogin</title>
</head>
<body>
	<form action="userLoginResult.jsp">
		  USERID:<br>
		  <input type="text" name="userid"><br>
		  PASSWORD:<br>
		  <input type="text" name="password"><br><br>
		  <input type="submit" value="CONFIRM">
	</form>
</body>
</html>
		