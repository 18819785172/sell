<html>
<head>
    <meta charset="UTF-8">
    <title>卖家系统登录</title>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/css/style.css">
</head>
<body style="background-color: aliceblue">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column" style="top: 100px">
            <h3>账号密码：admin</h3>
            <form class="form-horizontal" role="form" method="post" action="/sell/seller/login">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">账号:</label>
                    <div class="col-sm-10">
                        <input class="form-control" value="" id="username" name="username" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
                    <div class="col-sm-10">
                        <input type="password" id="password" name="password" class="form-control" id="inputPassword3" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" id="login" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }
    var username = (GetQueryString("username"));
    $("#username").val(username);

</script>
</html>