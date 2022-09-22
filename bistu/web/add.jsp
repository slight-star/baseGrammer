<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
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
    <title>添加电影信息</title>

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
    //这其实是一个汉化的js中的内容（bootstrap-datetimepicker.zh-CN.js），但是导入后总是乱码显示，所以直接贴到前端了
    // $.fn.datetimepicker.dates['zh-CN'] = {
    //     days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
    //     daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
    //     daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
    //     months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    //     monthsShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
    //     today: "今天",
    //     suffix: [],
    //     meridiem: ["上午", "下午"]
    // };
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
<div class="container">
    <center><h3>添加电影数据页面</h3></center>
    <form action="${pageContext.request.contextPath}/addMovieServlet" method="post">
        <div class="form-group">
            <label for="title">影片名称：</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="请输入影片名称">
        </div>


        <div class="form-group">
            <label for="actor">演员：</label>
            <input type="text" class="form-control" id="actor" name="actor" placeholder="请输入演员">
        </div>

        <div class="form-group">
            <label for="director">导演：</label>
            <input type="text" class="form-control" id="director" name="director" placeholder="请输入导演">
        </div>

        <div class="form-group">
            <label for="mainType">主类型：</label>
            <select name="mainType" class="form-control" id="mainType">
                <%--<option value="">剧情</option>--%>
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
                    <input type='text' class="form-control" id="releaseDate" name="releaseDate"/>
                    <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            <%--</div>--%>
        </div>

        <div class="form-group">
            <label for="totalBoxoffice">总票房：</label>
            <input type="text" class="form-control" id="totalBoxoffice" name="totalBoxoffice" >
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
