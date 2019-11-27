<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 该页已废弃-结果直接显示 -->
<html>
这个页是显示分类结果正常-结节的结果的--未写
	<body>
		<table >
			<tr >
				<th >对图像${image_name }进行结节分类检测操作</th>
			</tr>
			<tr>
			</tr>
		</table>
		<img src="Thyroid_images/${image_name }">
		
		
		<form action="quzao.do"> <!-- 提交给这个网页 -->
			有三个分类方式
			是否去除：<input type="submit" value="去噪"/>
			<table >
				<tr >
					<th >对图像${image_name }进行结节分类检测操作</th>
				</tr>
				<tr>
				</tr>
			</table>
		</form>
	</body>
</html>