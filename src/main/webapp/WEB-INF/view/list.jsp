<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Human" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一覧表示</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID</td>
			<th>名前</th>
			<th>年齢</th>
			<th>性別</th>
			<th>誕生日</th>
			<th>住所</th>
			<th>電話番号</th>
			<th>メール</th>
		</tr>
	<%
	List<Human> list = (ArrayList<Human>)request.getAttribute("list");
	for(Human h : list) {
	%>
		<tr>
			<td><%=h.getId() %></td>
			<td><%=h.getName() %></td>
			<td><%=h.getAge() %></td>
			<td><%=h.getGender() %></td>
			<td><%=h.getBirthday() %></td>
			<td><%=h.getAddress() %></td>
			<td><%=h.getTel() %></td>
			<td><%=h.getMail() %></td>
		</tr>
	<%} %>
	</table>
</body>
</html>