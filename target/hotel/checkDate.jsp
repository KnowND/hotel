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
    <%--<script language="javascript" src="js/CheckValidator.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>


    <%--<c:import url="js/CheckValidator.js"/>--%>
</head>
<style>
    .error-data {
        display: none;
    }
</style>
<body>
<div class="container">
    <form class="form-horizontal" role="form" action="/check" method="post">
        <%--<h2 class="text-center">${registration}</h2>--%>
        <h2 class="text-center">Room reservation</h2>
        <c:if test="${sessionScope.free == false}">
            <h2 class="text-center">No free rooms for this date</h2>
        </c:if>

        <c:if test="${sessionScope.wrong_date == true}">
            <h2 class="text-center">Please enter normal date</h2>
        </c:if>


        <%--<div class="form-group row text-center">--%>
        <%--<label class="col-md-4 control-label">Date Settlement(yyyy.mm.dd)</label>--%>
        <%--<div class="col-md-2">--%>
        <%--<input type="text" id="sYear" name="sYear" placeholder="settlement year"--%>
        <%--class="form-control">--%>
        <%--</div>--%>

        <%--<div class="col-md-2">--%>
        <%--<input type="text" id="sMonth" name="sMonth" placeholder="settlement month"--%>
        <%--class="form-control">--%>
        <%--</div>--%>
        <%--<div class="col-md-2">--%>
        <%--<input type="text" id="sDay" name="sDay" placeholder="settlement day"--%>
        <%--class="form-control">--%>
        <%--</div>--%>
        <%--</div>--%>

        <%--<div class="form-group row text-center">--%>
        <%--<label class="col-md-4 control-label">Date Eviction(yyyy.mm.dd)</label>--%>
        <%--<div class="col-md-2">--%>
        <%--<input type="text" id="eYear" name="eYear" placeholder="eviction year"--%>
        <%--class="form-control">--%>
        <%--</div>--%>
        <%--<div class="col-md-2">--%>
        <%--<input type="text" id="eMonth" name="eMonth" placeholder="eviction month"--%>
        <%--class="form-control">--%>
        <%--</div>--%>
        <%--<div class="col-md-2">--%>
        <%--<input type="text" id="eDay" name="eDay" placeholder="eviction day"--%>
        <%--class="form-control">--%>
        <%--</div>--%>
        <%--</div>--%>

        <div class="row">


            <div class="error-data text-center col-sm-4" id="error-date">
                <span class="text-danger">Please print correct information</span>
            </div>
            <%--<div class="form-group row text-center">--%>
            <%--<label for="class" class="col-md-3 control-label">room level</label>--%>
            <%--<div class="col-md-2">--%>
            <%--<input type="text" id="class" name="class" placeholder="class" class="form-control">--%>
            <%--</div>--%>
            <%--</div>--%>
            <div class="col-md-4">

                <div class="form-group row text-center">
                    <label>Choose checkin and checkout dates</label>
                </div>

                <div class="form-group row text-center">
                    <input type="text" class="form-control col-md-4" name="daterange" value="01/01/2018 - 01/15/2018"/>
                </div>
            </div>

            <div class="col-md-7 col-md-offset-1">
                <div class="form-group text-center">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Price</th>
                            <th>Size</th>
                            <th>tv</th>
                            <th>shower</th>
                            <th>balcony</th>
                            <th>bath</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${roomLevel}" var="book">
                            <tr>
                                <td>
                                    <div class="row">
                                            <%--<label>class ${book.id}</label>--%>
                                        <input id="class${book.id}" type="checkbox" class="checkk" name="class"
                                               value="${book.id}">
                                    </div>
                                </td>
                                <td>${book.price}</td>
                                <td>${book.size}</td>
                                <td>${book.tv1}</td>
                                <td>${book.shower1}</td>
                                <td>${book.balcony1}</td>
                                <td>${book.bath1}</td>

                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
                <div class="error-data text-center" id="error-data">
                    <span class="text-danger">Please print correct information</span>
                </div>
            </div>



            <div class="form-group row text-center">
                <button type="submit" id="submit" class="btn btn-primary col-md-2">Find room</button>
            </div>
    </form> <!-- /form -->
</div> <!-- ./container -->
</body>
<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<script src="static/js/checkDateValidator.js"></script>

<%--<script>--%>
<%--$(document).ready(function () {--%>

<%--$(".checkk").click(function() {--%>

<%--var id = parseInt(this.id.match(/\d+/));--%>

<%--if(id == 1) {--%>
<%--$('#class1').prop("checked", true);--%>
<%--$('#class2').prop('checked', false);--%>
<%--$('#class3').prop('checked', false);--%>
<%--}else if (id == 2){--%>
<%--$('#class3').prop('checked',false);--%>
<%--$('#class2').prop('checked',true);--%>
<%--$('#class1').prop('checked',false);--%>
<%--}else if (id == 3){--%>
<%--$('#class1').prop('checked',false);--%>
<%--$('#class2').prop('checked',false);--%>
<%--$('#class3').prop('checked',true);--%>
<%--}--%>
<%--});--%>

<%--$('#submit').click(function () {--%>
<%--var check = true;--%>

<%--var sY = parseInt($('#sYear').val());--%>
<%--var sM = parseInt($('#sMonth').val());--%>
<%--var sD = parseInt($('#sDay').val());--%>
<%--var eY = parseInt($('#eYear').val());--%>
<%--var eM = parseInt($('#eMonth').val());--%>
<%--var eD = parseInt($('#eDay').val());--%>

<%--if (!(sY >= 2018 && sY <= 2020)) {--%>
<%--check = false;--%>
<%--$('#sYear').css("border-color", "#FF0000");--%>
<%--} else {--%>
<%--$('#sYear').css("border-color", "#0aff07");--%>
<%--}--%>

<%--if (!( sM >= 1 && sM <= 12)) {--%>
<%--check = false;--%>
<%--$('#sMonth').css("border-color", "#FF0000");--%>
<%--} else {--%>
<%--$('#sMonth').css("border-color", "#0aff07");--%>
<%--}--%>

<%--if (!(sD >= 1 && sD <= 31)) {--%>
<%--check = false;--%>
<%--$('#sDay').css("border-color", "#FF0000");--%>

<%--} else {--%>
<%--$('#sDay').css("border-color", "#0aff07");--%>
<%--}--%>


<%--if (!(eY >= 2018 && eY <= 2020)) {--%>
<%--check = false;--%>
<%--$('#eYear').css("border-color", "#FF0000");--%>
<%--} else {--%>
<%--$('#eYear').css("border-color", "#0aff07");--%>
<%--}--%>


<%--if (!(eM >= 1 && eM <= 12)) {--%>
<%--check = false;--%>
<%--$('#eMonth').css("border-color", "#FF0000");--%>

<%--} else {--%>
<%--$('#eMonth').css("border-color", "#0aff07");--%>
<%--}--%>

<%--if (!( eD >= 1 && eD <= 31)) {--%>
<%--check = false;--%>
<%--$('#eDay').css("border-color", "#FF0000");--%>

<%--} else {--%>
<%--$('#eDay').css("border-color", "#0aff07");--%>
<%--}--%>

<%--var class0 = $('#class1').prop("checked");--%>
<%--var class1 = $('#class2').prop("checked");--%>
<%--var class2 = $('#class3').prop("checked");--%>

<%--if ((!class0 && !class1 && !class2) || (class0 && class1 && class2) || (!class0 && class1 && class2) || (class0 && !class1 && class2)--%>
<%--|| (class0 && class1 && !class2)){--%>
<%--check = false;--%>
<%--}--%>

<%--if (!check) {--%>
<%--$('#error-data').show();--%>

<%--}--%>

<%--return check;--%>
<%--})--%>
<%--});--%>
<%--</script>--%>
</html>
