<%@page import="entity.Person"%>
<%@page import="entity.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/RegistBoardConfirm.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%
	Board board = (Board) request.getAttribute("board");
	Person person = (Person) session.getAttribute("person");
	%>


	<main>
		<div class="clearfix">
			<header>
				<h1>走れる人を探そう</h1>
			</header>
		</div>

		<div class="pagename">
			<h2>新規掲示板作成確認画面</h2>
		</div>

		<div class="elements">
			<div class="element">
				<h3>
					以上の内容で<%=person.getUserName()%>さんの掲示板を作成します
				</h3>
			</div>
			<div class="element">
				<p class="moziue">時間</p>
				<p class="mozi"><%=board.getTime()%></p>
			</div>
			<hr>
			<div class="element">
				<p class="moziue">場所</p>
				<p class="mozi"><%=board.getPlace()%></p>
			</div>
			<hr>
			<div class="element">
				<p class="moziue">自由コメント欄</p>
				<p class="mozi">
					<%
					if (board.getComment().isEmpty()) {
					%>
					未入力
					<%
					} else {
					%>
					<%=board.getComment()%></p>
				<%
				}
				%>

			</div>
		</div>
		<div class=sendbox>
			<div class=send>
				<form action="./AddBoardServlet" method="post">
					<input type="hidden" name="time" value="<%=board.getTime()%>">
					<input type="hidden" name="place" value="<%=board.getPlace()%>">
					<input type="hidden" name="comment" value="<%=board.getComment()%>">
					<input type="hidden" name="id" value="<%=person.getId()%>">
					<input class="btn" type="submit" value="新規登録">
				</form>
			</div>

			<div class="send">
				<form action="./CreateBoardServlet.jsp" method="post">
					<input type="hidden" name="time" value="<%=board.getTime()%>">
					<input type="hidden" name="place" value="<%=board.getPlace()%>">
					<input type="hidden" name="comment" value="<%=board.getComment()%>">
					<input type="hidden" name="id" value="<%=person.getId()%>">
					<input class="btn" type="submit" value="入力画面へ戻る">
				</form>
			</div>
		</div>


		<div class="Backbtn">
			<span class="pages">
				<a href="./TopPage.jsp">トップページへ戻る</a>
			</span>
		</div>

		<footer>
			<p>CopyRight UutyanShiroRider All Right Reserved
		</footer>
	</main>

</body>

</body>
</html>