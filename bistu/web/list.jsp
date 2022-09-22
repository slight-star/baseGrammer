<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>电影信息</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        table{
            table-layout: fixed;
        }
        td, th {
            text-align: center;
        }

        .line-limit-length {
            width: 200px;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap; //文本不换行，这样超出一行的部分被截取，显示...
        }

    </style>
    <script>
        function deleteMovie(movieId,currentPage){
            //
            if (confirm("您确定要删除吗？")){
                location.href = "${pageContext.request.contextPath}/delMovieServlet?movieId="+movieId+"&currentPage="+currentPage;
            }
        }

        // window.onload=function(){
        //     var date = $(".date").text();
        //     let newDate=/\d{4}-\d{1,2}-\d{1,2}/g.exec(date);
        //     $(".date").text(newDate);
        // };

        function delSelected(){
            if(confirm("您确定要删除选中条目吗？")){
                //判断是否有选中的条目
                var flag =false;
                var cbs = $("input[name='movieId']");
                for (var i = 0; i < cbs.length; i++){
                    if(cbs[i].checked){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    $("#form").submit();
                }else{
                    alert("您还未选择条目");
                }
            }
        }

        // window.onload = function(){ //不知道为啥不管用
        //     $("#firstCb").onclick = function () {
        //         var cbs = $("input[name='movieId']");
        //         for (var i = 0; i < cbs.length; i++){
        //             cbs[i].checked = $("#firstCb").prop("checked");
        //         }
        //     }
        // };

        function selectAll(){
            var cbs = $("input[name='movieId']");
            // var cbs = document.getElementsByName("movieId");
            for (var i = 0; i < cbs.length; i++){
                cbs[i].checked = $("#firstCb").prop("checked");
            }
        }

        function jumpTo(){
            var page = $("#jumpPage").val();
            if (page < ${pb.totalPage}){
                location.href = "${pageContext.request.contextPath}/findMovieByPageServlet?currentPage="+page+"&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}";
            }else{
                alert("请输入有效页码");
            }

        }

    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">电影信息列表</h3>
    <div style="float: left; margin: 13px">
        <form class="form-inline" action="${pageContext.request.contextPath}/findMovieByPageServlet" method="post">
            <div class="form-group">
                <label for="title">影片名称</label>
                <input type="text" class="form-control" id="title"  name="title" value="${conditions.title[0]}" placeholder="">
            </div>
            <div class="form-group">
                <label for="actor">演员</label>
                <input type="text" class="form-control" id="actor" name="actor" value="${conditions.actor[0]}" placeholder="">
            </div>
            <div class="form-group">
                <label for="director">导演</label>
                <input type="text" class="form-control" id="director" name="director" value="${conditions.director[0]}" placeholder="">
            </div>
            <button type="submit" class="btn btn-default">搜索</button>
        </form>
    </div>

    <div style="float: right; margin: 10px">
        <a class="btn btn-primary" href="add.jsp">添加电影</a>
        <a class="btn btn-primary" onclick="delSelected()">删除选中</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th style="width: 50px;"><input type="checkbox" id="firstCb" onclick="selectAll()"></th>
            <th style="width: 80px;">序号</th>
            <th>影片名称</th>
            <th>演员</th>
            <th>导演</th>
            <th>上映日期</th>
            <th>总票房(万)</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${pb.list}" var="movie" varStatus="s">
            <tr>
                <td style="width: 50px;"><input type="checkbox" name="movieId" value="${movie.movieId}"></td>
                <td style="width: 80px;">${s.count}</td>
                <td>${movie.title}</td>
                <td class="line-limit-length">${movie.actor}</td>
                <td>${movie.director}</td>
                <td class="date">${fn:substring(movie.releaseDate, 0,10)}</td>
                <td>${movie.totalBoxoffice}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findMovieServlet?movieId=${movie.movieId}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" onclick="deleteMovie(${movie.movieId},${pb.currentPage})">删除</a></td>
            </tr>

        </c:forEach>

        <%--<tr>--%>
            <%--<td colspan="8" align="center"><a class="btn btn-primary" href="add.html">添加</a></td>--%>
        <%--</tr>--%>
    </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <li>
                    <a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=1&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}" aria-label="Previous">
                        <span aria-hidden="true">首页</span>
                    </a>
                </li>
                <%--上一页--%>
                <c:if test="${pb.currentPage == 1}">
                    <li class="disabled">
                        <a href="javascript:void(0)" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage != 1}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${pb.currentPage - 1}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <%--页码--%>
                <c:if test="${pb.currentPage < 5}">
                    <c:forEach begin="1" end="${pb.currentPage + 5}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <li class="active"><a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${i}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}">${i}</a></li>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li><a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${i}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}">${i}</a></li>
                        </c:if>
                    </c:forEach>
                </c:if>
                <c:if test="${pb.currentPage >= 5 && pb.currentPage < pb.totalPage-8}">
                    <c:forEach begin="${pb.currentPage - 3}" end="${pb.currentPage + 5}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <li class="active"><a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${i}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}">${i}</a></li>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li><a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${i}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}">${i}</a></li>
                        </c:if>
                    </c:forEach>
                </c:if>
                <c:if test="${pb.totalPage - 8 <= pb.currentPage  &&  pb.currentPage <= pb.totalPage && pb.currentPage > 3}">
                    <c:forEach begin="${pb.currentPage - 3}" end="${pb.totalPage}" var="i">
                        <c:if test="${pb.currentPage == i}">
                            <li class="active"><a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${i}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}">${i}</a></li>
                        </c:if>
                        <c:if test="${pb.currentPage != i}">
                            <li><a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${i}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}">${i}</a></li>
                        </c:if>
                    </c:forEach>
                </c:if>



                <%--下一页--%>
                <c:if test="${pb.currentPage == pb.totalPage}">
                    <li class="disabled">
                        <a href="javascript:void(0)" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${pb.currentPage != pb.totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${pb.currentPage + 1}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>

                <%--末页--%>
                <li>
                    <a href="${pageContext.request.contextPath}/findMovieByPageServlet?currentPage=${pb.totalPage}&rows=10&title=${conditions.title[0]}&actor=${conditions.actor[0]}&director=${conditions.director[0]}" aria-label="Next">
                        <span aria-hidden="true">末页</span>
                    </a>
                </li>

                <input type="text" id="jumpPage" style="width: 100px;float: left" class="form-control" placeholder="请输入页码">
                <button id="jump" style="float: left" class="btn btn-default" onclick="jumpTo()">跳转</button>

                <span style="font-size: 20px; margin: 10px 10px 10px 10px">
                    共${pb.totalCount}条数据，共${pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>

</div>
</body>
</html>

