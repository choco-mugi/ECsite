<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<title>UserCompilation画面</title>

<style type="text/css">
/* ========TAG LAYOUT ======== */
body {
	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
}

table {
	text-align: center;
	margin: 0 auto;
}
/* ========ID LAYOUT ======== */
#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#header {
	width: 100%;
	height: 80px;
	background-color: black;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}

#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
}

label {
	position: relative;
	top: 21px;
}
</style>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>

	<div id="main">
		<div id="top">
			<p>ProductEditing</p>
		</div>
		<div>
			<s:if test="errorMessage != ''">
				<s:property value="errorMessage" escape="false" />
			</s:if>
			<table>
				<s:form action="ProductEditingConfirmAction">
					<tr>
						<td><label>商品名:</label></td>
						<td><s:textfield name="itemName"
								value="%{#session.productlist_item_name}" /></td>
					</tr>
					<tr>
						<td><label>値段:</label></td>
						<td><s:textfield name="itemPrice"
								value="%{#session.productlist_item_price}" /></td>
					</tr>
					<tr>
						<td><label>在庫：</label></td>
						<td><s:textfield name="itemStock"
								value="%{#session.productlist_item_stock}" /></td>
					</tr>
					<tr>
						<td><label>詳細：</label></td>
						<td><s:textarea type="text" rows="12" name="itemDetail"
								value="%{#session.productlist_item_detail}" /></td>
					</tr>
					<s:submit value="更新" />
				</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span> <a href='<s:url action="HomeAction" />'>こちら</a>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>