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
<title>UserDeleteConfirm画面</title>

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
			<p>UserDeleteConfirm</p>
		</div>
		<div>
			<h3>以下のユーザーを削除します。本当によろしいですか。</h3>
			<table border="1">
				<tr>
					<th>ID</th>
					<td><s:property value="%{#session.userlist_id}" /></td>
				</tr>
				<tr>
					<th>ログインID</th>
					<td><s:property value="%{#session.userlist_login_id}" /></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><s:property value="%{#session.userlist_login_pass}" /></td>
				</tr>
				<tr>
					<th>名前</th>
					<td><s:property value="%{#session.userlist_name}" /></td>
				</tr>
				<tr>
					<th>階級</th>
					<td><s:property value="%{#session.userlist_user_grade}" /></td>
				</tr>
				<tr>
					<th>登録日時</th>
					<td><s:property value="%{#session.userlist_insert_date}" /></td>
				</tr>
				<tr>
					<th>更新日時</th>
					<td><s:property value="%{#session.userlist_update_date}" /></td>
				</tr>
			</table>
			<s:form action="UserDeleteCompleteAction">
				<s:submit value="削除" />
			</s:form>
			<s:form action="UserListAction">
				<s:submit value="戻る"/>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>