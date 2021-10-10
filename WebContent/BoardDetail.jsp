<%@page import="entity.Board"%>
<%@page import="entity.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/Boarddetail.css" rel="stylesheet">
<title>掲示板詳細ページ</title>
</head>

<%
Board b = null;
if (request.getAttribute("board") != null) {
	b = (Board) request.getAttribute("board");
}
%>

<body>

	<main>
		<div class="clearfix">
			<header>
				<h1>走れる人を探そう</h1>
			</header>
		</div>

		<div class="pagename">
			<h2>掲示板詳細ページ</h2>
		</div>

		<div class="top">
			<div class="second1">
				<%=b.getName()%>さんの基本情報と掲示板情報
			</div>
		</div>
		<div class="top">
			<div class="goboard">
				<form action="./GoMessageBoardServlet" method="post">
					<input type="hidden" name="id" value="<%=b.getId()%>">
					<input type="submit" value="<%=b.getName()%>さんと会話をする" class="button">
				</form>
			</div>
		</div>
		<div class="top">
			<div class="second">年齢</div>
			<div class="second">
				<%=b.getName()%>
			</div>
		</div>
		<div class="top">
			<div class="second">FTP</div>
			<div class="second">
				<%=b.getFtp()%>
			</div>
		</div>
		<div class="top">
			<div class="second">ロードバイク歴</div>
			<div class="second">
				<%=b.getHowlong()%>
			</div>
		</div>
		<div class="top">
			<div class="second">走りたい場所</div>
			<div class="second">
				<%=b.getPlace()%>
			</div>
		</div>
		<div class="top">
			<div class="second">時間帯</div>
			<div class="second">
				<%=b.getTime()%>
			</div>
		</div>
		<div class="top">
			<div class="second2">コメント欄</div>
			<div class="second3">
				<%=b.getComment()%>
			</div>
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
</html>