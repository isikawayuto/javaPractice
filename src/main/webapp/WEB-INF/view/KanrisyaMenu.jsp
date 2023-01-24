<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Account"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者画面</title>
</head>
<body>
	<% 
		Account ac = (Account)session.getAttribute("admin");		
	%>
	<h1>管理者トップページ</h1>
	<a href="Logout">ログアウト</a>
</body>
</html>
