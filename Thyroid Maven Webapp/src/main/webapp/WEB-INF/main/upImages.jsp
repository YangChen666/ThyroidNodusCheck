<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE>
<html>
	<head>
		<title>文件上传</title>
	</head>
	
	<body>
		<h1>文件上传</h1>
		<form action="toupimages.do" enctype="multipart/form-data" method="post">
			<table>
			<tr>
				<td>文件描述：12</td>
				<td><input type="text" name="description"/></td>
			</tr>
			<tr>
				<td>选择文件：</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr><td><input type="submit" value="上传"/></td></tr>
			</table>
		</form>
	</body>
</html>
