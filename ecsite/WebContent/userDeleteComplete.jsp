<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserDeleteComplete画面</title>
</head>
<body>
<div id="header">
		<div class="header-title">
			<img src="./image/headerIcon.png"/>
			<p>DOCO DEMO</p>
		</div>
		<div class="header-menu">
			<ul>
				<li><a href='<s:url action="UserCreateAction"/>'>新規登録</a></li>
				<li><a href='<s:url action="HomeAction"/>'>ログイン</a></li>

			</ul>
		</div>
	</div>
	<div id="main">
		<div id="top">
		<p>ユーザー情報削除　完了画面</p>
		</div>
		<div>
			<p><s:property value="message"/></p>
			<div>
					<p><a href='<s:url action="AdminAction" />'>管理者TOP画面へ戻る</a></p>
				</div>
		</div>
	</div>
	<div id="footer">
			<div id="pr">
			</div>
		</div>
</html>