<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemUpdate画面</title>
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
			<p>商品情報 変更画面</p>
		</div>
		<s:if test="errorMessage != null">
			<s:property value="errorMessage" escape="false" />
		</s:if>
		<div>

			<s:form action="ItemUpdateConfirmAction">
				<table>
					<tr>
						<td>id</td>
						<td><s:property value="id" /></td>
					</tr>
					<tr>
						<td>商品名</td>
						<td><input type="text" size="15"
							value='<s:property value="session.itemName"/>' name="reItemName" /></td>
					</tr>
					<tr>
						<td>値段</td>
						<td><input type="text" size="15"
							value='<s:property value="session.itemPrice"/>'
							pattern="[1-9][0-9]*" title="半角数字" name="reItemPrice" /></td>
						<td><span>円</span></td>
					</tr>
					<tr>
						<td>在庫</td>
						<td><input type="text" size="15"
							value='<s:property value="session.itemNumber"/>'
							pattern="[1-9][0-9]*" title="半角数字" name="reItemNumber" /></td>
						<td><span>個</span></td>
					</tr>
				</table>
				<br>
				<s:hidden name="id" value="%{id}" />
				<input type="submit" value="変更する" />

			</s:form>

			<p>
				商品一覧は<a href='<s:url action="ItemListAction"/>'>こちら</a>
			</p>
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