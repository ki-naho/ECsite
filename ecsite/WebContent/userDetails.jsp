<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<title>UserDetails画面</title>
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
			<p>ユーザー詳細</p>
		</div>
		<div>
			<s:if test="userDetailsDTO == null">
				<h3>ユーザーの詳細情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>ユーザー詳細情報は以下になります。</h3>
				<table border ="1">
					<tr>
						<td>id</td>
						<td><s:property value="userDetailsDTO.id"/></td>
					</tr>
					<tr>
						<td>ログインID</td>
						<td><s:property value="userDetailsDTO.loginId"/></td>
					</tr>
					<tr>
						<td>パスワード</td>
						<td><s:property value="userDetailsDTO.password"/></td>
					</tr>
					<tr>
						<td>ユーザーネーム</td>
						<td><s:property value="userDetailsDTO.userName"/></td>
					</tr>
					<tr>
						<td>登録日</td>
						<td><s:property value="userDetailsDTO.insert_date"/></td>
					</tr>
					<tr>
						<td>更新日</td>
						<td><s:property value="userDetailsDTO.update_date"/></td>
					</tr>
				</table>
				<br>
				<s:form action ="UserDeleteConfirmAction">
					<s:submit value="削除"/>
					<s:hidden name ="loginId" value="%{loginId}"/>
				</s:form>

			</s:elseif>
			<div id="text-right">
				<p>ユーザー一覧は<a href='<s:url action="UserListAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
			<div id="pr">
			</div>
		</div>

</body>
</html>