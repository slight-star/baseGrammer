<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改电影信息</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <!-- 时间选择器样式表 -->
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <!-- 时间选择器前置脚本 -->
    <%--<script src="https://cdn.bootcss.com/moment.js/2.22.1/moment-with-locales.min.js"></script>--%>
    <script src="js/bootstrap-datetimepicker.min.js"></script>

</head>
<script>
    $(function() {
        $('#datetimepicker1').datetimepicker({
            format: 'yyyy-mm-dd',  //显示格式可为yyyymm/yyyy-mm-dd/yyyy.mm.dd
            language:'zh-cn',
            // minView:1,
            // todayBtn:true,
            // todayHighlight:true,

        });
    });
</script>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改电影信息</h3>
    <form action="${pageContext.request.contextPath}/updateMovieServlet" method="post">
        <input type="hidden" name="movieId" value="${movie.movieId}">
        <div class="form-group">
            <label for="title">影片名称：</label>
            <input type="text" class="form-control" id="title" name="title" value="${movie.title}" placeholder="请输入影片名称">
        </div>


        <div class="form-group">
            <label for="actor">演员：</label>
            <input type="text" class="form-control" id="actor" name="actor" value="${movie.actor}" placeholder="请输入演员">
        </div>

        <div class="form-group">
            <label for="director">导演：</label>
            <input type="text" class="form-control" id="director" name="director" value="${movie.director}" placeholder="请输入导演">
        </div>

        <div class="form-group">
            <label for="mainType">主类型：</label>
            <select name="mainType" class="form-control" id="mainType">
                <%--<option value="">剧情</option>--%>
                <option value="${movie.mainType}" >${movie.mainType}</option>
                <option value="剧情">剧情</option>
                <option value="动作">动作</option>
                <option value="科幻">科幻</option>
            </select>
        </div>

        <div class="form-group">
            <%--<div class="col-sm-6">--%>
            <label>上映日期：</label>
            <!--指定 date标记-->
            <div class='input-group date' id='datetimepicker1'>
                <input type='text' class="form-control" id="releaseDate" name="releaseDate" value="${fn:substring(movie.releaseDate, 0,10)}"/>
                <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                    </span>
            </div>
            <%--</div>--%>
        </div>

        <div class="form-group">
            <label for="totalBoxoffice">总票房：</label>
            <input type="text" class="form-control" id="totalBoxoffice" name="totalBoxoffice" value="${movie.totalBoxoffice}">
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" />
        </div>
    </form>
</div>
</body>
</html>
