<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>itemCreate画面</title>
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
			<p>商品新規登録</p>
		</div>
		<s:form action ="ItemCreateConfirmAction" method="post" enctype="multipart/form-data">
			<s:if test='errorMessage !="" '>
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
				<tr>
					<td>商品名</td>
					<td><input type="text" name="itemName"/></td>
					<td></td>
				</tr>
				<tr>
					<td>値段</td>
					<td><input type="text" name="itemPrice" pattern="[1-9][0-9]*" title="半角数字"/></td>
					<td><span>円</span></td>
				</tr>
				<tr>
					<td>在庫</td>
					<td><input type="text" name="number" pattern="[1-9][0-9]*" title="半角数字"/></td>
					<td><span>個</span></td>
				</tr>

			</table>
			<br>
			<input type="submit" value="登録"/>
		</s:form>
		<p><a href='<s:url action ="AdminAction"/>'>管理者TOPへ戻る</a></p>
	</div>

	<div id="footer">
	</div>
</body>
</html>