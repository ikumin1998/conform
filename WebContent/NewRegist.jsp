<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/NewRegist.css" rel="stylesheet">
<title>新規登録ページ</title>
</head>
<body>


	<main>
		<div class="clearfix">
			<header>
				<h1>走れる人を探そう</h1>
			</header>
		</div>

		<div class="pagename">
			<h2>新規登録画面</h2>
		</div>

		<div class="log-form">
			<h3>登録情報を入力してください</h3>
			<form action="./RegistConfirmServlet" method="post">
				<input class="inputReq" type="text" name="name" placeholder="ユーザー名(必須項目です)" required>
				<input class="inputReq" type="text" name="pass" placeholder="パスワード(必須項目です)" required>
				<input class="input" type="number" name="age" placeholder="年齢">
				<input class="input" type="text" name="place" placeholder="居住地">
				<input class="input" type="number" name="FTP" placeholder="あなたのFTP">
				<input class="input" type="number" name="howlong" placeholder="バイク歴">
				<textarea class="area" name="comment" rows="6" cols="40" placeholder = 
				"求めているローディーのタイプ、どのエリアをよく走っているかなど、自由にお書きください"></textarea>
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