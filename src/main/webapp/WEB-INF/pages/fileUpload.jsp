<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/9
  Time: 下午4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>

<form action="/fileUpload" method="post" enctype="multipart/form-data">
    选择:<input type="file" name="pic">
    <input type="submit" value="up">
</form>

</body>
</html>
