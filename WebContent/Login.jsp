<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="css/Login.css" rel="stylesheet">
<title>ログインページ</title>
</head>

<%
String judge = "";
if (request.getAttribute("error") != null)
	judge = (String) request.getAttribute("error");
%>


<main>
	<div class="clearfix">
		<header>
			<h1>走れる人を探そう</h1>
		</header>
	</div>

	<div class="pagename">
		<h2>ログイン画面</h2>
	</div>

	<div class="errormsg">
		<%
		if (judge.equals("未登録")) {
			;
		%>
		<p class="msg">ユーザー名とパスワードが一致しません</p>
		<%
		}
		%>
	</div>

	<div class="log-form">
		<h3>ユーザー名とパスワードを入力してください</h3>
		<form action="./LoginServlet" method="post">
			<input class="input" type="text" name="name" placeholder="ユーザー名">
			<input class="input" type="text" name="pass" placeholder="パスワード">
			<input class="botton" type="submit" class="btn" value="ログイン">
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