<html>
<head>
    <#include "../common/header.ftl">
</head>
<body>
<div id="wrapper" class="toggled">

    <#--边栏-->
    <#include "../common/nav.ftl">

    <#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>姓名</th>
                            <th>手机号</th>
                            <th>地址</th>
                            <th>金额</th>
                            <th>订单状态</th>
                            <th>支付状态</th>
                            <th>创建时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list orderDTOPage.content as orderDTO>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.buyerName}</td>
                                <td>${orderDTO.buyerPhone}</td>
                                <td>${orderDTO.buyerAddress}</td>
                                <td>${orderDTO.orderAmount}</td>
                                <td>${orderDTO.getOrderStatusEnum().msg}</td>
                                <td>${orderDTO.getPayStatusEnum().msg}</td>
                                <td>${orderDTO.createTime}</td>
                                <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}&page=${currentPage}">详情</a></td>
                                <td>
                                    <#if orderDTO.getOrderStatus()==0>
                                        <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}&page=${currentPage}">
                                            取消
                                        </a>
                                    </#if>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

                <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                        <#if currentPage==1>
                            <li class="disabled">
                                <a href="#">首页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/sell/seller/order/list?page=1&size=${size}">首页</a>
                            </li>
                        </#if>
                        <#if currentPage lte 1>
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/sell/seller/order/list?page=${currentPage-1}&size=${size}">上一页</a>
                            </li>
                        </#if>
                        <#list 1..orderDTOPage.getTotalPages() as index>
                            <#if currentPage==index>
                                <li  class="disabled">
                                    <a href="#">${index}</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            </#if>
                        </#list>

                        <#if currentPage gte orderDTOPage.getTotalPages()>
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}">下一页</a>
                            </li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<#--&lt;#&ndash;弹窗&ndash;&gt;
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提醒
                </h4>
            </div>
            <div class="modal-body">
                你有新的订单
            </div>
            <div class="modal-footer">
                <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button &lt;#&ndash;onclick="location.reload()"&ndash;&gt; type="button" class="btn btn-primary"><a href="/sell/seller/order/list">查看新的订单</a></button>
            </div>
        </div>
    </div>
</div>
&lt;#&ndash;播放音乐&ndash;&gt;
<audio id="notice" loop="loop">
    <source src="/sell/mp3/son.mp3" type="audio/mpeg">
</audio>-->
<#include "../common/websocket.ftl">
<#--<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->
<script>
    /*var websocket = null;
    if('WebSocket' in window){
        websocket = new WebSocket('ws://'+ window.location.host +'/sell/webSocket');
    }else{
        alert('该浏览器不支持websocket');
    }

    websocket.onopen = function (event) {
        console.log('建立连接');
    }

    websocket.onclose = function (event) {
        console.log('连接关闭');
    }

    websocket.onmessage = function (event) {
        console.log('收到消息'+event.data);
        $('#myModal').modal('show');
        document.getElementById('notice').play();
    }

    websocket.onerror = function () {
        console.log('websocket通信发生异常');
    }
    // 关闭窗口同时关闭连接
    window.onbeforeunload = function () {
        websocket.close();
    }*/

</script>
</body>
</html>