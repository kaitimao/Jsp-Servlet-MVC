<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Insert title here</title>
</head>
<body>
	
	<form action="Login_servlet" method="Post">
		帳號:  <input type="text" name="account">
		<br />
		密碼: <input type="text" name="password" />
		<input type="submit" value="確定" />
		<!-- EL語句，後面驗證表單時，驗證錯誤反回信息-->
	  	${error}
	</form>
		
	<form action="AddToDb" method="post">
		<input type="submit" name="todb" value="新增帳號"  />
		
	</form>
	
</body>
</html>