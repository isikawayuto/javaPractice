<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="dto.Account"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="css/form.css">
<title>ログイン</title>
</head>
<body>
<div>
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){
			Account ac = (Account)session.getAttribute("data");
	%>
	<h1 style="color:red">ログイン失敗</h1>
		<form action="login" method="post" class="form">
				<h2>メールアドレスとパスワードを入力してください</h2>
				<input type="text" name="mail" value="<%=request.getParameter("mail") %>">
				<input type="password" name="pw">
				<input type="submit" value="ログイン">
				<a href="NewCustomer">新規登録</a>
		</form>
	<%
		} else {
	%>
		<form action="login" method="post" class="form">
				<h2>メールアドレスとパスワードを入力してください</h2>
				<input type="text" name="mail">
				<input type="password" name="pw">
				<input type="submit" value="ログイン">
				<a href="NewCustomer">新規登録</a>
		</form>
	<%
		}
	%>
</div>
</body>
</html>
