<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserDeleteConfirm画面</title>
</head>
<body>
	<div id="header">
		<div class="header-title">
			<img src="./image/headerIcon.png" />
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
			<p>ユーザー情報削除 確認画面</p>
		</div>
		<p>
			ログインID:
			<s:property value="loginId" />
			のユーザー情報を削除します。よろしいですか？
		</p>
		<s:form action="UserDeleteCompleteAction">
			<s:hidden name="loginId" value="%{loginId}" />
			<s:submit value="ＯＫ" />
		</s:form>
		<s:form action="UserListAction">
			<s:submit value="キャンセル" />
		</s:form>
	</div>
	<div id="footer">
		<div class="footer-link">
			<ul>
				<li>初めての方へ</li>
				<li>会社概要</li>
				<li>利用規約</li>
				<li>プライバシーポリシー</li>
				<li>推奨環境</li>
			</ul>
		</div>
		<div class="copyRight">
			<p>Copyrights © itudemo Corp.</p>
		</div>
	</div>
</body>
</html>