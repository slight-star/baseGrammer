<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8"  language="java" buffer="16kb" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/echarts.js"></script>
</head>
<body>
    <c:if test=""></c:if>

    <span id="context" value="${pageContext.request.contextPath}"/>
    <%=request.getSession().getAttribute("user")%><span style="color: red;">,欢迎您！</span>
    <!--历年总票房-->
    <div id="yearBoxoffice" style="width: 800px;height:500px;float: left;margin-top: 15px"></div>
    <!--历年上映数量-->
    <div id="movieCount" style="width: 800px;height:500px;float: left;margin-top: 15px"></div>

    <!--历年档期-->
    <div style="width: 800px;height:500px;float:left;margin-top: 15px">
        <select id="dangqi_year" style="margin-left: 10px;">
            <option value="2021" selected>--请选择年份--</option>
            <option value="2021">2021</option>
            <option value="2020">2020</option>
            <option value="2019">2019</option>
            <option value="2018">2018</option>
            <option value="2017">2017</option>
            <option value="2016">2016</option>
            <option value="2015">2015</option>
            <option value="2014">2014</option>
            <option value="2013">2013</option>
            <option value="2012">2012</option>
            <option value="2011">2011</option>
            <option value="2010">2010</option>
            <option value="2009">2009</option>
            <option value="2008">2008</option>
            <option value="2007">2007</option>
            <option value="2006">2006</option>
            <option value="2005">2005</option>
            <option value="2004">2004</option>
            <option value="2003">2003</option>
            <option value="2002">2002</option>
            <option value="2001">2001</option>
            <option value="2000">2000</option>
        </select>
        <div id="dangqi" style="width: 800px;height:500px;"></div>
    </div>

    <!--历年票房前10-->
    <div style="width: 800px;height:500px;float:left;margin-top: 15px">
        <select id="movie_year" style="margin-left: 10px;">
            <option value="2021" selected="selected">--请选择年份--</option>
            <option value="2021">2021</option>
            <option value="2020">2020</option>
            <option value="2019">2019</option>
            <option value="2018">2018</option>
            <option value="2017">2017</option>
            <option value="2016">2016</option>
            <option value="2015">2015</option>
            <option value="2014">2014</option>
            <option value="2013">2013</option>
            <option value="2012">2012</option>
            <option value="2011">2011</option>
            <option value="2010">2010</option>
            <option value="2009">2009</option>
            <option value="2008">2008</option>
            <option value="2007">2007</option>
            <option value="2006">2006</option>
            <option value="2005">2005</option>
            <option value="2004">2004</option>
            <option value="2003">2003</option>
            <option value="2002">2002</option>
            <option value="2001">2001</option>
            <option value="2000">2000</option>
        </select>
        <div id="movie_top" style="width: 800px;height:500px;float: left"></div>
    </div>

    <!--排名前10的电影类型-->
    <div id="typeTop" style="width: 800px;height:500px;float: left;margin-top: 15px"></div>

    <%--<div style="border-radius: 60px;--%>
        <%--background: linear-gradient(145deg, #0089cd, #0073ad);--%>
        <%--box-shadow:  41px 41px 82px #00334d,--%>
             <%---41px -41px 82px #00cdff;--%>
             <%--width: 800px;height:500px;float: left">--%>

    <%--</div>--%>

</body>
<script>
    $(function() {
        var contextPath = $("#context").attr("value");
        alert(contextPath);
        //从服务器获取每年的总票房
        $.get(contextPath+"/findYearBoxofficeServlet",
            function (data) {
                var label_id = "yearBoxoffice";
                var year_arr = [];
                var boxoffice_arr = [];
                for (var i=0; i<data.length; i++){
                    var data_i = data[i];
                    year_arr.push(data_i["year"]);
                    boxoffice_arr.push(data_i["totalBoxoffice"]);
                }
                barPlot(label_id,"年度总票房(亿)","总票房(亿)",year_arr,boxoffice_arr);

            },"json");

        //显示历年电影数量
        $.post("/learn_tomcat/findMovieCountServlet",
            // {"year":year},
            function(data){
                var label_id = "movieCount";
                var year_arr = [];
                var count_arr = [];
                for (var i=0; i<data.length; i++){
                    var data_i = data[i];
                    year_arr.push(data_i["year"]);
                    count_arr.push(data_i["count"]);
                }
                barPlot(label_id,"历年上映数量","上映数量",year_arr,count_arr);
            },"json");

        //显示档期票房
        var year = $("#dangqi_year").val();
        $.post("/learn_tomcat/findDangqiBoxofficeServlet",
            {"year":year},
            function(data){
                var label_id = "dangqi";
                var dangqi_arr = [];
                var boxoffice_arr = [];
                for (var i=0; i<data.length; i++){
                    var data_i = data[i];
                    dangqi_arr.push(data_i["档期"]);
                    boxoffice_arr.push(data_i["totalBoxoffice"]);
                }
                barPlot(label_id,"档期总票房(亿)","总票房(亿)",dangqi_arr,boxoffice_arr);
            },"json");

        $("#dangqi_year").change(function(){
            //从服务器获取档期的总票房
            var year = $("#dangqi_year").val();
            $.post("/learn_tomcat/findDangqiBoxofficeServlet",
                {"year":year},
                function(data){
                    var label_id = "dangqi";
                    var dangqi_arr = [];
                    var boxoffice_arr = [];
                    for (var i=0; i<data.length; i++){
                        var data_i = data[i];
                        dangqi_arr.push(data_i["档期"]);
                        boxoffice_arr.push(data_i["totalBoxoffice"]);
                    }
                    barPlot(label_id,"档期总票房(亿)","总票房(亿)",dangqi_arr,boxoffice_arr);
                },"json");
        });

        //显示历年票房前十
        var year = $("#movie_year").val();
        $.post("/learn_tomcat/findMovieTopServlet",
            {"year":year},
            function(data){
                var label_id = "movie_top";
                var movieName_arr = [];
                var boxoffice_arr = [];
                for (var i=0; i<data.length; i++){
                    var data_i = data[i];
                    movieName_arr.push(data_i["影片名称"]);
                    boxoffice_arr.push(data_i["总票房"]);
                }
                barPlot(label_id,"历年票房前10","总票房(万)",movieName_arr,boxoffice_arr);
            },"json");

        $("#movie_year").change(function(){
            //从服务器获取档期的总票房
            var year = $("#movie_year").val();
            $.post("/learn_tomcat/findMovieTopServlet",
                {"year":year},
                function(data){
                    var label_id = "movie_top";
                    var movieName_arr = [];
                    var boxoffice_arr = [];
                    for (var i=0; i<data.length; i++){
                        var data_i = data[i];
                        movieName_arr.push(data_i["影片名称"]);
                        boxoffice_arr.push(data_i["总票房"]);
                    }
                    barPlot(label_id,"历年票房前10","总票房(万)",movieName_arr,boxoffice_arr);
                },"json");
        });

        // $('#typeTop');
        $(document).ready(function () {
            $.post("/learn_tomcat/findTypeTopServlet",
                function (data) {
                    var label_id = "typeTop";
                    var title = "电影类型前10";
                    // var data_arr = [];
                    //
                    // for (var i=0; i<data.length; i++){
                    //     var data_i = data[i];
                    //     var m = {};
                    //     m['value'] = data[i].value;
                    //     m['name'] = data[i].name;
                    //     data_arr.push(m);
                    // }
                    piePlot(label_id,title,data);
                },'json');
        });


        function piePlot(label_id,title,data){
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById(label_id));
            window.onresize = function() {
                myChart.resize();
            };

            option = {
                title: {
                    text: title,
                    left: 'center',
                    top: 'center'
                },
                color: ['#fc8251', '#5470c6', '#91cd77', '#ef6567', '#f9c956', '#75bedc'],
                series: [
                    {
                        type: 'pie',
                        data: data,
                        radius: ['40%', '70%'],
                        label : {
                            normal : {
                                formatter: '{b}:{c}: ({d}%)',
                                textStyle : {
                                    fontWeight : 'normal',
                                    fontSize : 15
                                }
                            }
                        },
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);

            /*
            var option = {
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    // data: cat_data
                        // ['A', 'B', 'C', 'D', 'E']
                },
                series: [
                    {
                        type: 'pie',
                        radius: ['50%', '70%'],
                        avoidLabelOverlap: false,
                        label: {
                            show: false,
                            position: 'center',
                            emphasis: {
                                show: true
                            }
                        },
                        labelLine: {
                            show: false
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        },
                        data: data
                        //     [
                        //     { value: 335, name: 'A' },
                        //     { value: 310, name: 'B' },
                        //     { value: 234, name: 'C' },
                        //     { value: 135, name: 'D' },
                        //     { value: 1548, name: 'E' }
                        // ]
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);*/

        }

        function barPlot(label_id,title,series_name,x_arr,y_arr){
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById(label_id));
            window.onresize = function() {
                myChart.resize();
            };

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: title
                },
                tooltip: {},
                // legend: {
                //     data: ['总票房']
                // },
                xAxis: {
                    //x轴
                    data: x_arr,
                    axisLabel :{interval:0,rotate:0}
                },
                yAxis: {},
                series: [
                    {
                        name: series_name,
                        type: 'bar',
                        data: y_arr
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }

    });

</script>



</html>
