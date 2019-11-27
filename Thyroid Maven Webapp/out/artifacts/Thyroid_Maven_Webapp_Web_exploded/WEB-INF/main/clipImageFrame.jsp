<%@page pageEncoding="utf-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>frame</title>
    <link rel="stylesheet" type="text/css" href="assets/css/image_clip/imageClip.css" />
    <%--<link rel="stylesheet" type="text/css" href="assets/css/image_clip/bootstrap.min.css"/>--%>
    <script type="text/javascript" src="assets/js/image_clip/imageClip.js"></script>
    <script type="text/javascript" src="assets/js/image_clip/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="assets/js/image_clip/jquery-ui.min.js"></script>
</head>
<body bgcolor="white">
    <div id="div1">
        <div id="div2">
            <div id="box" class="box">
                <image class="img1" src="Thyroid_images/${image_name}"></image>
                <image id="img2" class="img2" src="Thyroid_images/${image_name}"></image>
                <div class="main" id="main">
                    <div id="left-up" class="minDiv left-up"></div>
                    <div id="left" class="minDiv left"></div>
                    <div id="left-down" class="minDiv left-down"></div>
                    <div id="up" class="minDiv top"></div>
                    <div id="right-up" class="minDiv right-up"></div>
                    <div id="right" class="minDiv right"></div>
                    <div id="right-down" class="minDiv right-down"></div>
                    <div id="down" class="minDiv bottom"></div>
                </div>
            </div>
        </div>

    </div>
    <div id="preview">
        <div class="img3_box">
            <image id="img3" class="img3" src="Thyroid_images/${image_name}"></image>
        </div>
    </div>

    <%--<div class="labelDiv">--%>
        <%--<label id="show">aaa</label>--%>
    <%--</div>--%>
    <div class="formDiv">
        <form action="/home_ROI_tuo.do" method="post">
            <input id="test" type="text" name="clipParameter" value="" style="display: none">
            <input class="submitInput" type="submit" value="确认裁剪" formtarget="_top">
        </form>
    </div>

</body>
</html>