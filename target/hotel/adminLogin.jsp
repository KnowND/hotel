<%--
  Created by IntelliJ IDEA.
  User: edik2
  Date: 04.07.2018
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <title>Title</title>
</head>
<body>
<form class="form-horizontal" role="form" action="/admin" method="post">

    <div class="text-center">
        <div class="form-group row">
            <label>Login</label>
            <input type="text" name="login" id="login" placeholder="login" >
        </div>

        <div class="form-group row">
            <label>Login</label>
            <input type="password" name="password" id="password" placeholder="password">
        </div>

        <div class="form-group row">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>

    </div>
</form>
</body>
</html>
