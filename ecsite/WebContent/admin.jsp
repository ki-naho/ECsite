<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Login画面</title>
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
			<p>管理者画面</p>
		</div>
		<div>
			<table>
			 <tr>
			 	<th>商品</th> <th>ユーザー</th>
			 </tr>
			 <tr>
			 	<td><s:form action="ItemCreateAction"><s:submit value="新規登録"/></s:form></td>
			 	<td><s:form action="UserCreateAction"><s:submit value="新規登録"/></s:form></td>
			 </tr>
			 <tr>
			 	<td><s:form action="ItemListAction"><s:submit value="一覧"/></s:form></td>
			 	<td><s:form action="UserListAction"><s:submit value="一覧"/></s:form></td>
			 </tr>
			</table>
		</div>
		<div>
			<s:if test="#session.login_user_id !=null">
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction"/>'>こちら</a>
			</s:if>
		</div>
	</div>

	<div id="footer">
	</div>


</body>
</html>