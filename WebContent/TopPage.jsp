<%@page import="entity.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href = "css/style.css" rel = "stylesheet" >
<link href = "css/TopPage.css" rel = "stylesheet" >
<title>一緒に走ろう！仮</title>
</head>

<% Person person = (Person) session.getAttribute("person");  %>

<body>

<main>
<div class ="clearfix">
	<header>
		<h1>走れる人を探そう</h1>
	</header>
		<ul class="logleft">
			<li class="login"><a class="loginA" href="./Login.jsp">ログイン</a></li>
			<li class="login"><a class="loginA" href="./NewRegist.jsp">新規登録</a></li>
		</ul>
</div>

<div class="pagename">
	<h2>トップページ</h2>
</div>

<%
if (person!=null){
%>
<div class="welcome">
	<p><%=person.getName()%>さん、こんにちは！</p>
</div>
<%
}else{
%>
<div class="welcome">
<p>初めての方は<a href="#">このページ</a>へ</p>
</div>
<%
}
%>



<div class="pages">
		<ul>
			<li class="boxname">掲示板へ</li>
			<li class="boxname">〇〇さんに関係する掲示板</li>
			<li class="boxname">登録情報の修正</li>
		</ul>
</div>

<div class="addpages">
		<ul>
			<li class="addpagesname">このサイトの目的</li>
			<li class="addpagesname">お問い合わせ、ご要望</li>
		</ul>
</div>



<footer>
	<p>CopyRight UutyanShiroRider All Right Reserved
</footer>

</main>

</body>
</html>