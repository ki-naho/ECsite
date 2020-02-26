<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="./css/styleUserList.css">
<title>UserList画面</title>
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
			<p>ユーザー一覧</p>
		</div>
		<div>
			<s:if test="userListDTOList == null">
				<h3>ユーザーの情報はありません。</h3>
			</s:if>
			<s:if test="message == null">
				<h3>ユーザーの情報は以下になります。</h3>
				<s:iterator value="userListDTOList">
					<table border="1px" class="itemList">
						<tr>
							<th class="idLine">ID</th>
							<th class="itemLine">ログインID</th>
							<th class="priceLine">パスワード</th>
							<th class="userName">ユーザー名</th>
							<th class="insertLine">登録日時</th>
							<th class="updateLine">更新日時</th>
							<th class="etcLine">詳細</th>
						</tr>
						<tr>
							<td class="idLine"><s:property value="id"/></td>
							<td class="itemLine"><s:property value="loginId"/></td>
							<td class="priceLine"><s:property value="password"/></td>
							<td class="countLine"><s:property value="userName"/></td>
							<td class="insertLine"><s:property value="insert_date"/></td>
							<td class="updateLine"><s:property value="update_date"/></td>
							<td class="etcLine">
								<a href ='<s:url action="UserDetailsAction">
										<s:param name="loginId" value="%{loginId}"/>
										</s:url>'>詳細</a>
							</td>
						</tr>
					</table>

				</s:iterator>
			</s:if>
		</div>
		<br>
		<s:form action="UserListDeleteConfirmAction">
			<s:submit value="削除"/>
		</s:form>
		<br>
		<p><a href='<s:url action ="AdminAction"/>'>管理者TOPへ戻る</a></p>


	</div>

	<div id="footer"></div>
</body>
</html>