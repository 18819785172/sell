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
                    <form role="form" method="post" action="/sell/seller/category/save">
                        <input hidden name="categoryId" value="${(category.categoryId)!""}">
                        <div class="form-group">
                            <label>type</label>
                            <input id="categoryType" name="categoryType" type="number" class="form-control" value="${(category.categoryType)!""}"/>
                        </div>
                        <div class="form-group">
                            <label>名字</label>
                            <input id="categoryName" name="categoryName" type="text" class="form-control" value="${(category.categoryName)!""}"/>
                        </div>
                        <button id="btn" type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../common/websocket.ftl">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }
    var categoryId = (GetQueryString("categoryId"));
    if (categoryId != null) {
        $("#categoryType").attr("readonly","readonly");
    }else {
        $("#categoryType").blur(function () {
            var categoryType = $("#categoryType").val();
            if (categoryType !== null) {
                $.ajax({
                    type: "get",
                    data: categoryType,
                    url: "/sell/seller/category/check?categoryType=" + categoryType,
                    dataType: 'json',
                    success: function (data) {
                        if (data.code != 0) {
                            alert(data.msg);
                            $("#btn").attr("disabled", true);
                        } else {
                            $("#btn").attr("disabled", false);
                        }
                    }
                });
            }
        });
    }
</script>
</body>
</html>