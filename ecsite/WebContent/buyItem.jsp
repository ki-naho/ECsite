<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>BuyItem画面</title>
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
			<p>BuyItem</p>
		</div>
		<div>

			<s:if test ="errorMessage != null">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<s:form action="BuyItemAction">
				<table>
					<tr>
						<td>
							<span>商品名</span>
						</td>
						<td>
							<s:property value="session.buyItem_name"/><br>
						</td>
					</tr>
					<tr>
						<td>
							<span>値段</span>
						</td>
						<td>
							<s:property value="session.buyItem_price"/><span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							<span>購入個数</span>
						</td>
						<td>
							<select name="count">
								<option value="1" selected="selected">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<span>支払方法</span>
						</td>
						<td>
							<input type="radio" name="pay" value="1" checked="checked">現金払い
							<input type="radio" name="pay" value="2">クレジットカード
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="購入"/>
						</td>
					</tr>
				</table>
			</s:form>
			<div>
				<p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
				<p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>