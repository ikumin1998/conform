<%@page import="entity.Person"%>
<%@page import="entity.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/AllSeach.css" rel="stylesheet">
<title>掲示板一覧ページ</title>
</head>
<body>
	<%
	List<Board> list = (List<Board>) request.getAttribute("list");
	Person p = null;
	if (session.getAttribute("person") != null) {
		p = (Person) session.getAttribute("person");
	}
	%>


	<main>
		<div class="clearfix">
			<header>
				<h1>走れる人を探そう</h1>
			</header>

		</div>

		<div class="pagename">
			<h2>掲示板一覧</h2>
		</div>
		<%
		if (p != null) {
		%>

		<div class="create">
			<p>
				<a href="CreateBoard.jsp">掲示板を新規作成する</a>
			</p>
		</div>
		<%
		} else {
		%>

		<div class="create">
			<p>投稿を作成するには新規登録が必要です</p>
		</div>
		<%
		}
		%>
		<div class="bigbox">
			<%
			for (int i = 0; i < list.size(); i++) {
				Board b = list.get(i);
			%>
			<div class="one">
				<div class="top">
					<p>
						時間：<%=b.getTime()%></p>
					<p>
						場所：<%=b.getPlace()%></p>
					<p>
						名前：<%=b.getName()%></p>
				</div>
				<div class="top">
					<div class="top1">
						<p>詳細コメント</p><%=b.getComment()%>
					</div>
				</div>
				<div class="top">
					<form action="./SeeBoardDetailServlet" method="post">
						<input type="hidden" value="<%=b.getBoardid()%>" name="id">
						<input type="submit" value="詳細を確認">
					</form>
				</div>
			</div>
			<%
			}
			%>
		</div>




		<div class="Backbtn">
			<ul>
				<li>
					<a href="./TopPage.jsp">トップページへ戻る</a>
				</li>
			</ul>
		</div>



		<footer>
			<p>CopyRight UutyanShiroRider All Right Reserved
		</footer>
	</main>

</body>
</body>
</html>