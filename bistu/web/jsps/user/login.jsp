<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/index.css" />
</head>

<body>

    <img class="bgone" src="${pageContext.request.contextPath }/img/1.jpg" />
    <img class="pic" src="${pageContext.request.contextPath }/img/a.png" />

    <div class="table">
        <div class="wel">用户登录</div>
        <div class="wel1">YONG HU DENG LU</div>

        <form action="${pageContext.request.contextPath }/loginServlet" method="post">
            <div class="user">
                <div id="yonghu" style=""><img src="${pageContext.request.contextPath }/img/yhm.png" /></div>
                <input type="text" name="username" placeholder="请输入用户名" />
            </div>
            <div class="password">
                <div id="yonghu"><img src="${pageContext.request.contextPath }/img/mm.png" /></div>
                <input type="password" name="password" placeholder="请输入密码"/>
            </div>
            <c:if test="${not empty login_msg}">
                <div><%=request.getAttribute("login_msg") %></div>
            </c:if>

            <button class="btn" type="submit">登录</button>
        </form>

        <%--<span><%=request.getAttribute("checkCodemsg") %></span>--%>
    </div>

</body>

</html>