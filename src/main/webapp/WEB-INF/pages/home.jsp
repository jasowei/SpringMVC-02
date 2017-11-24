<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/11/9
  Time: 上午11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <script src="/js/jquery-3.2.1.js"></script>

</head>
<body>
<h1>热烈庆祝党的十九大胜利召开</h1>
<hr>
<form action="/login" method="post">
<select name="deptId" id="dept">
    <option value="-1">---请选择---</option>
</select>


<select name="postId" id="post" >
    <option value="-1">---请选择---</option>
</select>
    <hr>
    学号:
    <br>
    ID:<input type="checkbox" name="ids" value="1"><br>
    ID:<input type="checkbox" name="ids" value="2"><br>
    ID:<input type="checkbox" name="ids" value="3"><br>

    <input type="submit" value="提交">

</form>
</body>
<script>
    /*页面加载成功直接通过ajax请求获取部门集合*/
    $.ajax({
        url:"/hr/findAll",
        type:"get",
        success:function (result) {
            var selDept = document.getElementById("dept");
            selDept.innerHTML
                    ="<option value='-1'>---请选择---</option>";
            /*遍历结果集*/
            for(var i=0;i<result.length;i++){
                var depart = result[i];
                selDept.innerHTML
                        +="<option value='"+depart.depID+"'>"+depart.depName+"</option>";
            }
        }
    });

    /*根据所选部门id查职务集合*/
    $("#dept").change(function () {
        $.ajax({
            url:"/hr/findPostByDeptID",
            type:"get",
            data:{
                "deptID":$("#dept").val()
            },
            success:function (result) {
                var post = document.getElementById("post");
                post.innerHTML=
                        "<option value='-1'>---请选择---</option>";
                for(var i=0;i<result.length;i++){
                    var p = result[i];
                    post.innerHTML
                            +="<option value='"+p.postId+"'>"+p.postName+"</option>";
                }

            }
        })
    })
</script>
</html>
