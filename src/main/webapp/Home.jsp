<%@page import="com.ty.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<% List<User> usersdetalies = (List<User>)request.getAttribute("users"); %>
	<table border="1px">
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	<th>PhoneNumber</th>
	</tr>
	<%for(User user:usersdetalies){ %>
	<tr>
	<td><%= user.getId()%></td>
	<td><%= user.getName() %></td>
	<td><%= user.getEmail() %></td>
	<td><%= user.getPhoneNumber() %></td>
	</tr>
	
	<%} %>
	</table>
</body>
</html>