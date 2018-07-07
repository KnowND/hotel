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

    <title>Guest Registration</title>
    <%--<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>--%>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="/static/css/jquery.ccpicker.css">


</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/checkin" method="post">
        <h2 class="text-center">Guest registration</h2>

        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">Name</label>
            <div class="col-sm-7">
                <input type="text" id="name" name="name" value="${guestName}" placeholder="Name" class="form-control"
                       autofocus>
            </div>
        </div>

        <div class="form-group">
            <label for="surname" class="col-sm-3 control-label">Surname</label>
            <div class="col-sm-7">
                <input type="text" id="surname" name="surname" value="${guestSurname}" placeholder="Surname"
                       class="form-control" autofocus>
                <%--<span class="help-block">Last Name, First Name, eg.: Smith, Harry</span>--%>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Passport</label>
            <div class="col-sm-7">
                <input type="text" id="passport" name="passport" placeholder="Passport" class="form-control">
            </div>
        </div>

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

        <div class="form-group">
            <label class="col-sm-3 control-label">Room</label>
            <div class="col-sm-7">
                <%--<input type="text" id="room" name="room" placeholder="Room" class="form-control">--%>
                <select name="room">
                    <c:forEach var="room" items="${rooms}">
                        <option value="${room.id}">${room.number} ${room.floor} ${room.cost}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label">Cost</label>
            <div class="col-sm-7">
                <input type="text" id="cost" name="cost" placeholder="Cost" class="form-control">
            </div>
        </div>
        <c:if test="${sessionScope.wrong_checkin == true}">
            <div class="text-center">
                <span class="text-danger">Enter valid information</span>
            </div>
        </c:if>

        <div class="form-group row text-center">
            <div class="col-sm-4 col-sm-offset-3">
                <button type="submit" id="submit" class="btn btn-primary">Checkin Guest</button>
            </div>

            <div class="col-sm-4">
                <a class="btn btn-danger" href="/checkin">Cancel</a>
            </div>
        </div>
    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>--%>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<%--<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>--%>
<%--<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>--%>
<script src="static/js/jquery.ccpicker.min.js"></script>
<script src="static/js/CheckValidator.js"></script>
<script>
</script>

<%--<script>--%>

<%--$(document).ready(function () {--%>

<%--$('#submit').click(function () {--%>
<%--var name = $('#name').val().length;--%>
<%--var surname = $('#surname').val().length;--%>
<%--var phone = $('#phone').val();--%>
<%--var passport = $('#passport').val().length;--%>
<%--var room = $('#room').val();--%>
<%--var cost = $('#cost').val();--%>

<%--var check = true;--%>

<%--var phone_pattern = /\(?[+]?[0-9]{2}\)?\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/;--%>

<%--if (name == 0){--%>
<%--check = false;--%>
<%--$('#name').css("border-color", "#FF0000");--%>
<%--} else {--%>
<%--$('#name').css("border-color", "#0aff07");--%>
<%--}--%>

<%--if (surname == 0){--%>
<%--check = false;--%>
<%--$('#surname').css("border-color", "#FF0000");--%>
<%--} else {--%>
<%--$('#surname').css("border-color", "#0aff07");--%>
<%--}--%>

<%--if (!phone_pattern.test(phone)){--%>
<%--check = false;--%>
<%--$('#phone').css("border-color", "#FF0000");--%>
<%--} else {--%>
<%--$('#phone').css("border-color", "#0aff07");--%>
<%--}--%>

<%--if (cost.length == 0 ){--%>
<%--check = false;--%>
<%--$('#cost').css("border-color", "#FF0000");--%>
<%--} else {--%>
<%--$('#cost').css("border-color", "#0aff07");--%>
<%--}--%>


<%--if (passport == 0){--%>
<%--check = false;--%>
<%--$('#passport').css("border-color", "#FF0000");--%>
<%--} else {--%>
<%--$('#passport').css("border-color", "#0aff07");--%>
<%--}--%>

<%--return check;--%>


<%--});--%>


<%--})--%>
<%--</script>--%>
</html>
