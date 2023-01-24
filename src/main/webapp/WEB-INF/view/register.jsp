<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"href="css/form.css">
<title>Insert title here</title>
</head>
<body>
<div>
	<% 
		String error = request.getParameter("error");
		if(error != null){
			Account ac = (Account)session.getAttribute("input_data");
			
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>アカウント登録</h3>
		<form action="Confirm" method="post">
			名前：<input type="text" name="name" value="<%=ac.getName()%>"><br>
		年齢：<input type="text" name="age" value="<%=ac.getAge()%>"><br>
		性別：<input type="radio" name="gender" value="男">男
			  <input type="radio" name="gender" value="女">女<br>
		誕生日：<input type="date" name="birthday" value="<%=ac.getBirthday()%>"><br>
		住所：<input type="text" name="address" value="<%=ac.getAddress()%>"><br>
		電話番号：<input type="text" name="tel" value="<%=ac.getTel()%>"><br>
		メール：<input type="text" name="mail" value="<%=ac.getMail()%>"><br>
		パスワード：<input type="password" name="password"><br>
				<input type="submit" value="送信">
		
		</form>
	<%	
		} else {
	%>
	<h3>アカウント登録</h3>
	<form action="Confirm" method="post">
		名前：<input type="text" name="name"><br>
		年齢：<input type="text" name="age"><br>
		性別：<input type="radio" name="gender" value="男">男
			  <input type="radio" name="gender" value="女">女<br>
		誕生日：<input type="date" name="birthday"><br>
		住所：<input type="text" name="address"><br>
		電話番号：<input type="text" name="tel"><br>
		メール：<input type="text" name="mail"><br>
		パスワード：<input type="password" name="password"><br>
			<input type="submit" value="送信">
	</form>
	<% } %>
	<a href="TopServlet">戻る</a>
</div>
</body>
</html>