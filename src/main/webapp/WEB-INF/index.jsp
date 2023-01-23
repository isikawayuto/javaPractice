<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("error") != null){	
	%>
	<h1 style="color:red">ログイン失敗</h1>
		<form action="LoginServlet" method="post" class="form">
				<h2>メールアドレスとパスワードを入力してください</h2>
				<input type="text" name="mail" value="<%=request.getParameter("mail") %>">
				<input type="password" name="pw">
				<input type="submit" value="ログイン">
				<a href="RegisterFormServlet">新規登録</a>
		</form>
	<%
		} else {
	%>
		<form action="LoginServlet" method="post" class="form">
				<h2>メールアドレスとパスワードを入力してください</h2>
				<input type="text" name="mail">
				<input type="password" name="pw">
				<input type="submit" value="ログイン">
				<a href="RegisterFormServlet">新規登録</a>
		</form>
	<%
		}
	%>
</body>
</html>