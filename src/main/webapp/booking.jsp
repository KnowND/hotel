<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<style>
    .error-data {
        display: none;
    }
</style>

<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/booking" method="post">
        <%--<h2 class="text-center">${registration}</h2>--%>
        <h2 class="text-center">User contact info</h2>


            <div class="error-data text-center">
                <h3 class="text-danger">Please enter information</h3>
            </div>
            <div class="form-group text-center">
                <label class="control-label">Checkin date: ${sessionScope.in}</label>

            </div>


            <div class="form-group text-center">
                <label class="control-label">Checkout date: ${sessionScope.out}</label>

            </div>

            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">Name</label>
                <div class="col-sm-4">
                    <input type="text" id="name" name="name" placeholder="name" class="form-control" autofocus>
                </div>
            </div>

            <div class="form-group">
                <label for="surname" class="col-sm-3 control-label">surname</label>
                <div class="col-sm-4">
                    <input type="text" id="surname" name="surname" placeholder="class" class="form-control">
                </div>
            </div>

            <%--<div class="form-group">--%>
                <%--<label for="phone" class="col-sm-3 control-label">phone</label>--%>
                <%--<div class="col-sm-4">--%>
                    <%--<input type="text" id="phone" name="phone" placeholder="0931231234" class="form-control">--%>
                <%--</div>--%>
            <%--</div>--%>

            <div class="form-group">
                <label class="col-sm-3 control-label">Phone</label>
                <div class="col-sm-7">
                    <select name="code" class="text-right" id="code">
                        <option value="+38">+38</option>
                        <option value="+1">+1</option>
                        <option value="+43">+43</option>
                    </select>
                    <input type="text" id="phone" name="phone" class="text-left">
                    <%--<input type="text" id="phone" name="phone" value="${guestPhone}" placeholder="Phone"--%>
                    <%--class="form-control">--%>
                </div>
            </div>



        <c:if test="${sessionScope.wrong_guest == true or sessionScope.wrong == true}">
            <div class="text-center">
                <span class="text-danger">Enter valid information</span>
            </div>
        </c:if>


        <div class="form-group">
            <div class="col-sm-4 col-sm-offset-2">
                <button type="submit" id="submit" class="btn btn-primary btn-block">Create book request</button>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

<script>

    $(document).ready(function () {

        $('#submit').click(function () {
            var name = $('#name').val().length;
            var surname = $('#surname').val().length;
            var phone = $('#phone').val().length;

            var check = true;

            if (name == 0) {
                check = false;
                $('#name').css("border-color", "#FF0000");
            } else {
                $('#name').css("border-color", "#0aff07");
            }

            if (surname == 0) {
                check = false;
                $('#surname').css("border-color", "#FF0000");
            } else {
                $('#surname').css("border-color", "#0aff07");
            }

            if (phone != 10) {
                check = false;
                $('#phone').css("border-color", "#FF0000");
            } else {
                $('#phone').css("border-color", "#0aff07");
            }


            return check;


        });


    })
</script>
</html>
