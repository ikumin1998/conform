<%@page import="entity.Person"%>
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
Person p = null;
if (request.getAttribute("person") != null) {
	p = (Person) request.getAttribute("person");
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
			<span class="col2"><%=p.getUserName()%></span>
		</div>
		<div class="element">
			<span class="col1">パスワード</span>
			<span class="col2"><%=p.getPassword()%></span>
		</div>
		<div class="element">
			<span class="col1">年齢</span>
			<span class="col2">
				<%
				if (p.getAge() == 0) {
				%>
				未入力
				<%
				} else {
				%>
				<%=p.getAge()%>
				<%
				}
				%>
			</span>
		</div>
		<div class="element">
			<span class="col1">居住地</span>
			<span class="col2">
				<%
				if (p.getPlace().isEmpty()) {
				%>
				未入力
				<%
				} else {
				%>
				<%=p.getPlace()%>
				<%
				}
				%>
			</span>
		</div>
		<div class="element">
			<span class="col1">FTP</span>
			<span class="col2">
				<%
				if (p.getFTP() == 0) {
				%>
				未入力
				<%
				} else {
				%>
				<%=p.getFTP()%>
				<%
				}
				%>
			</span>
		</div>
		<div class="element">
			<span class="col1">バイク歴</span>
			<span class="col2">
				<%
				if (p.getHowlong() == 0) {
				%>
				未入力
				<%
				} else {
				%>
				<%=p.getHowlong()%>
				<%
				}
				%>
			</span>
		</div>
		<div class="element">
			<span class="col1">コメント</span>
			<span class="col2">
				<%
				if (p.getComment().isEmpty()) {
				%>
				未入力
				<%
				} else {
				%>
				<%=p.getComment() %>
				<%
				}
				%>
			</span>
		</div>
	</div>
	<div class=sendbox>
		<div class=send>
			<form action="./AddServlet" method="post">
				<input type="hidden" name="name" value="<%=p.getUserName()%>">
				<input type="hidden" name="pass" value="<%=p.getPassword()%>">
				<input type="hidden" name="age" value="<%=p.getAge()%>">
				<input type="hidden" name="place" value="<%=p.getPlace()%>">
				<input type="hidden" name="FTP" value="<%=p.getFTP()%>">
				<input type="hidden" name="howlong" value="<%=p.getHowlong()%>">
				<input type="hidden" name="comment" value="<%=p.getComment()%>">
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