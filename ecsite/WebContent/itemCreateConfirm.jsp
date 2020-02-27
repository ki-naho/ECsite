<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>itemCreateConfirm画面</title>
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
			<p>商品新規登録 確認画面</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<s:form action="ItemCreateCompleteAction">
				<table>
					<tr id="box">
						<td><label>商品名:</label></td>
						<td><s:property value="session.itemName" escape="false" /></td>
					</tr>
					<tr id="box">
						<td><label>値段:</label></td>
						<td><s:property value="session.itemPrice" escape="false" /><span>円</span></td>
					</tr>
					<tr id="box">
						<td><label>在庫数:</label></td>
						<td><s:property value="session.number" escape="false" /><span>個</span></td>
					</tr>
				</table>
				<br>
				<input type="submit" value="登録" />
			</s:form>
			<s:form action="ItemCreateAction">
				<s:submit value="やり直す" />
			</s:form>

		</div>
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