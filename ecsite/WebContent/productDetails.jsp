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
<title>ProductDetails画面</title>

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

#text-right {
	display: inline-block;
	text-align: right;
}
</style>
</head>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>ProductDetails</p>
		</div>
		<div>
			<h3>この商品の詳細です。</h3>
			<table border="1">
				<tr>
					<th>ID</th>
					<td><s:property value="%{#session.productlist_id}" /></td>
				</tr>
				<tr>
					<th>商品名</th>
					<td><s:property value="%{#session.productlist_item_name}" /></td>
				</tr>
				<tr>
					<th>値段</th>
					<td><s:property value="%{#session.productlist_item_price}" /><span>円</span></td>
				</tr>
				<tr>
					<th>在庫</th>
					<td><s:property value="%{#session.productlist_item_stock}" /><span>個</span></td>
				</tr>
				<tr>
					<th>詳細</th>
					<td><s:property value="%{#session.productlist_item_detail}" /></td>
				</tr>
				<tr>
					<th>登録日時</th>
					<td><s:property value="%{#session.productlist_insert_date}" /></td>
				</tr>
				<tr>
					<th>更新日時</th>
					<td><s:property value="%{#session.productlist_update_date}" /></td>
				</tr>
			</table>
			<s:form action="ProductEditingAction">
				<s:submit value="編集" />
			</s:form>
			<s:form action="ProductDeleteConfirmAction">
				<s:submit value="削除"/>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>