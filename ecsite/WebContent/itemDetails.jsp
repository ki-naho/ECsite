<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemDetails画面</title>
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
			<p>商品詳細</p>
		</div>
		<div>
			<s:if test="itemDetailsDTO == null">
				<h3>商品の詳細情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>商品情報は以下になります。</h3>
				<table border="1">
					<tr>
						<td>id</td>
						<td><s:property value="id" /></td>
					</tr>
					<tr>
						<td>商品名</td>
						<td><s:property value="itemDetailsDTO.itemName" /></td>
					</tr>
					<tr>
						<td>値段</td>
						<td><s:property value="itemDetailsDTO.itemPrice" /><span>円</span></td>
					</tr>
					<tr>
						<td>在庫</td>
						<td><s:property value="itemDetailsDTO.number" /><span>個</span></td>
					</tr>
					<tr>
						<td>登録日</td>
						<td><s:property value="itemDetailsDTO.insert_date" /></td>
					</tr>
					<tr>
						<td>更新日</td>
						<td><s:property value="itemDetailsDTO.update_date" /></td>
					</tr>

				</table>
				<br>
				<s:form action="ItemUpdateAction">
					<s:hidden name="id" value="%{id}" />
					<s:submit value="変更" />
				</s:form>
				<s:form action="ItemDeleteConfirmAction">
					<s:hidden name="id" value="%{id}" />
					<s:submit value="削除" />
				</s:form>

			</s:elseif>

			<div id="text-right">
				<p>
					商品一覧は<a href='<s:url action="ItemListAction"/>'>こちら</a>
				</p>
			</div>
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