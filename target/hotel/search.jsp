<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html>
<head>
    <%--<meta charset="UTF-8">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Registration</title>

    <!-- Bootstrap core CSS -->
    <%--<link href="../static/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" href="../static/css/font-awesome.min.css">--%>
    <%--<link rel="stylesheet" href="../static/css/registre.css">--%>
</head>

<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/booking" method="post">
        <%--<h2 class="text-center">${registration}</h2>--%>
        <h2 class="text-center">Search</h2>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">Name</label>
            <div class="col-sm-4">
                <input type="text" id="name" name="name" placeholder="name" class="form-control" autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="surname" class="col-sm-3 control-label">surname</label>
            <div class="col-sm-4">
                <input type="text" id="surname" name="surname" placeholder="surname" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label for="phone" class="col-sm-3 control-label">phone</label>
            <div class="col-sm-4">
                <input type="text" id="phone" name="phone" placeholder="phone" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Date Settlement(yyyy.mm.dd)</label>
            <div class="col-sm-2">
                <input type="number" id="sYear" name="sYear" placeholder="settlement year"
                       class="form-control">
            </div>

            <div class="col-sm-2">
                <input type="number" id="sMonth" name="sMonth" placeholder="settlement month"
                       class="form-control">
            </div>
            <div class="col-sm-2">
                <input type="number" id="sDay" name="sDay" placeholder="settlement day"
                       class="form-control">
            </div>
        </div>


        <div class="form-group">
            <label for="eviction_year" class="col-sm-3 control-label">Date Eviction(yyyy.mm.dd)</label>
            <div class="col-sm-5">
                <input type="number" id="eviction_year" name="eYear" placeholder="eviction year"
                       class="form-control">
            </div>
            <div class="col-sm-2">
                <input type="number" id="eviction_month" name="eMonth" placeholder="eviction month"
                       class="form-control">
            </div>
            <div class="col-sm-2">
                <input type="number" id="eviction_day" name="eDay" placeholder="eviction day"
                       class="form-control">
            </div>


        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                <button type="submit" id="submit" class="btn btn-primary btn-block">${register}</button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
</html>
