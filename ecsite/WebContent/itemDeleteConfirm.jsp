<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemDeleteConfirm画面</title>
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
			<p>商品情報削除　確認画面</p>
		</div>
		<p>商品ID:<s:property value="id"/><br>
		商品名:<s:property value="itemDetailsDTO.itemName" escape="false"/><br>
		の商品情報を削除します。よろしいですか？</p>
		<s:form action="ItemDeleteCompleteAction">
			<s:hidden name="id" value="%{id}"/>
			<s:submit value="ＯＫ" />
		</s:form>
		<s:form action="ItemListAction">
			<s:submit value="キャンセル" />
		</s:form>
	</div>
	<div id="footer"></div>
</body>
</html>