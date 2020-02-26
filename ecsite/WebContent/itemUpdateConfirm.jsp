<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>ItemUpdateConfirm画面</title>
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
			<p>商品情報 変更確認画面</p>
		</div>

		<div>

			<h3>以下の内容に変更します。よろしいですか？</h3>
			<s:form action = "ItemUpdateCompleteAction">
				<table>
					<tr>
						<td>id　</td>
						<td><s:property value="id"/></td>
					</tr>
					<tr>
						<td>商品名　</td>
						<td><s:property value="session.reItemName"/></td>
					</tr>
					<tr>
						<td>値段　</td>
						<td><s:property value="session.reItemPrice"/></td>
						<td><span>円</span></td>
					</tr>
					<tr>
						<td>在庫　</td>
						<td><s:property value="session.reItemNumber" /></td>
						<td><span>個</span></td>
					</tr>
				</table>
				<br>
					<s:hidden name="id" value="%{id}"/>
					<input type="submit" value="ＯＫ"/>
			</s:form>
			<s:form action="ItemListAction">
				<s:submit value="キャンセル" />
			</s:form>


			<p>商品一覧は<a href='<s:url action="ItemListAction"/>'>こちら</a></p>
		</div>
	</div>
	<div>
		<div id="footer"></div>
	</div>
</body>

</html>