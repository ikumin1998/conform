<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/RegistConfirm.css" rel="stylesheet">
<title>登録確認画面</title>
</head>
<%
String name = (String) request.getAttribute("name");
String pass = (String) request.getAttribute("pass");
String age = "";
if (request.getParameter("age") != "") {
	age = (String) request.getAttribute("age");
}
String place = "";
if (request.getAttribute("place") != "") {
	place = (String) request.getAttribute("place");
}
String FTP = "";
if (request.getParameter("FTP") != "") {
	FTP = (String) request.getAttribute("FTP");
}
String howlong = "";
if (request.getParameter("howlong") != "") {
	howlong = (String) request.getAttribute("howlong");
}
String comment = "";
if (request.getAttribute("comment") != "") {
	comment = (String) request.getAttribute("comment");
}
%>


<main>
	<div class="clearfix">
		<header>
			<h1>走れる人を探そう</h1>
		</header>
	</div>

	<div class="pagename">
		<h2>登録確認画面</h2>
	</div>

	<div class="elements">
		<div class="element">
			<h3>以上の内容で登録します</h3>
		</div>
		<div class="element">
			<span class="col1">ユーザー名</span>
			<span class="col2"><%=name%></span>
		</div>
		<div class="element">
			<span class="col1">パスワード</span>
			<span class="col2"><%=pass%></span>
		</div>
		<div class="element">
			<span class="col1">年齢</span>
			<span class="col2"><%=age%></span>
		</div>
		<div class="element">
			<span class="col1">居住地</span>
			<span class="col2"><%=place%></span>
		</div>
		<div class="element">
			<span class="col1">FTP</span>
			<span class="col2"><%=FTP%></span>
		</div>
		<div class="element">
			<span class="col1">バイク歴</span>
			<span class="col2"><%=howlong%></span>
		</div>
		<div class="element">
			<span class="col1">コメント</span>
			<span class="col2"><%=comment%></span>
		</div>
	</div>
	<div class = sendbox>
		<div class = send>
			<form action="./AddServlet" method="post">
				<input type="hidden" name="name" value="<%=name %>">
				<input type="hidden" name="pass" value="<%=pass %>">
				<input type="hidden" name="age" value="<%=age%>">
				<input type="hidden" name="place" value="<%=place%>">
				<input type="hidden" name="FTP" value="<%=FTP %>">
				<input type="hidden" name="howlong" value="<%=howlong %>">
				<input type="hidden" name="comment" value="<%=comment %>">
				<input class="btn" type="submit" value="新規登録">
			</form>
		</div>

		<div class="send">
			<form action="./NewRegist.jsp" method="post">
				<input type="hidden" name="name" value="name">
				<input type="hidden" name="name" value="pass">
				<input type="hidden" name="name" value="age">
				<input type="hidden" name="name" value="place">
				<input type="hidden" name="name" value="FTP">
				<input type="hidden" name="name" value="howlong">
				<input type="hidden" name="name" value="comment">
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
</html>