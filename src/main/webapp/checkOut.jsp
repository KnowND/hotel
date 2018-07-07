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

<body>
<div class="container">
    <h2>Guest IN HOTEL</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Guest Phone</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Room</th>
            <th>Settlement</th>
            <th>Eviction</th>
            <th>CheckOut</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${inHotels}" var="inHotel">
            <tr>
                <td>${inHotel.phone}</td>
                <td>${inHotel.name}</td>
                <td>${inHotel.surname}</td>
                <td>${inHotel.room}</td>
                <td>${inHotel.dateSettlement}</td>
                <td>${inHotel.dateEviction}</td>
                <td><a href="/checkoutguest?passport=${inHotel.passport}" class="btn btn-block">CHECK OUT</a> </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>


</div> <!-- ./container -->
</body>
</html>
