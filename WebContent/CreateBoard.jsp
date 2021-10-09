<%@page import="entity.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/NewRegist.css" rel="stylesheet">
<title>新規掲示板作成</title>
</head>
<body>
	<%Person p =(Person) session.getAttribute("person")	;
 %>


	<main>
		<div class="clearfix">
			<header>
				<h1>走れる人を探そう</h1>
			</header>
		</div>

		<div class="pagename">
			<h2>掲示板作成ページ</h2>
		</div>

		<div class="log-form">
			<h3>掲示板へ登録する情報を入力してください</h3>
			<form action="./CreateBoardServlet" method="post">
				<textarea class="area" name="time" rows="6" cols="40"
					placeholder="一緒に走りたい時間帯を入力してください（例：１３時～１５時）" required></textarea>
				<textarea class="area" name="place" rows="6" cols="40"
					placeholder="一緒に走る場所を入力してください（例：荒川サイクリングロード）" required></textarea>
				<textarea class="area" name="comment" rows="6" cols="40"
					placeholder="自由にコメントをお書きください"></textarea>
				<input type="hidden" value="<%=p.getId() %>" name="id">
				<input class="botton" type="submit" class="btn" value="確認画面へ">
			</form>
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