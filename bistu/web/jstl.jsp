<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.dong.domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl测试</title>
</head>
<body>
    <%
        List list = new ArrayList();
        list.add(new User(111,"zhangsan","123",new Date()));
        list.add(new User(222,"wangsu","12345",new Date()));
        list.add(new User(333,"liuad","1321",new Date()));
        list.add(new User(444,"fdwe","59693",new Date()));

        request.setAttribute("list",list);
    %>

    <table>
        <tr>
            <th>编号</th>
            <th>id</th>
            <th>用户名</th>
            <th>密码</th>
            <th>出生日期</th>
            <th>出生日期格式化</th>
        </tr>

    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count % 2 == 0}">
            <tr bgcolor="silver">
                <th>${s.count}<br>
                <th>${user.id}<br>
                <th>${user.username}<br>
                <th>${user.password}<br>
                <th>${user.birth}<br>
                <th>${user.birstr}<br>
            </tr>
        </c:if>
        <c:if test="${s.count % 2 == 1}">
            <tr bgcolor="#bc8f8f">
                <th>${s.count}<br>
                <th>${user.id}<br>
                <th>${user.username}<br>
                <th>${user.password}<br>
                <th>${user.birth}<br>
                <th>${user.birstr}<br>
            </tr>
        </c:if>

    </c:forEach>

    </table>
</body>
</html>
