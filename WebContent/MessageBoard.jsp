<%@page import="entity.BoardInside"%>
<%@page import="java.util.List"%>
<%@page import="entity.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/MessageBoard.css" rel="stylesheet">
<title>一緒に走ろう！仮</title>
</head>

<%
List<BoardInside> list = (List<BoardInside>) request.getAttribute("list");
%>


<body>

	<main>
		<div class="clearfix">
			<header>
				<h1>走れる人を探そう</h1>
			</header>

		</div>

		<div class="pagename">
			<h2></h2>
		</div>
		<%for (int i=0;i<list.size();i++){
			BoardInside bi = list.get(i); %>
		} この掲示板の掲示板IDは<%=bi.getBoardid() %>です
		<%} %>


		<footer>
			<p>CopyRight UutyanShiroRider All Right Reserved
		</footer>

	</main>

</body>
</html>