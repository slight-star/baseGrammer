<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="css/index.css" />
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function(){
            //给username input绑定离焦事件
            $("#username").blur(function () {
                //获取输入框中的值
                var username = $(this).val();
                //发送ajax请求
                //期望服务器响应的数据 {"userExist":true,"msg":"此用户名已存在”} {"userExist":false,"msg":"可用”}
                $.get("/learn_tomcat/findUserServlet",
                    {"username":username},
                    function (data) {
                        // alert(data);
                        var span = $("#s_username");
                        if (data.userExist){
                            //用户名存在
                            span.css("color","red");
                            span.html(data.msg);
                        }else{
                            //用户名不存在
                            span.css("color","green");
                            span.html(data.msg);
                        }
                    },"json");
            });
        });
    </script>
</head>

<body>

    <img class="bgone" src="img/1.jpg" />
    <img class="pic" src="img/3.png" />

    <div class="table">
        <div class="wel">用户注册</div>
        <div class="wel1">YONG HU ZHU CE</div>

        <form action="${pageContext.request.contextPath }/registServlet" method="post">
            <div class="user" style="top:3.8rem;">
                <div id="yonghu" style=""><img src="img/yhm.png" /></div>
                <input type="text" name="username" placeholder="请输入用户名" />
                <span id=""></span>
            </div>
            <div class="password" style="top:8.8rem;">
                <div id="yonghu"><img src="img/mm.png" /></div>
                <input type="password" name="password" placeholder="请输入密码"/>
            </div>
            <div class="repassword" style="top:13.8rem;">
                <div id="yonghu"><img src="img/mm.png" /></div>
                <input type="password" name="repassword" placeholder="请确认密码"/>
            </div>
            <%--<div><%=request.getAttribute("login_error") %></div>--%>
            <button class="btn" style="top:18.8rem;" type="submit">注册</button>
        </form>

        <%--<span><%=request.getAttribute("checkCodemsg") %></span>--%>
        <%--<span>${requestScope.checkCodemsg}</span>--%>
    </div>

</body>

</html>