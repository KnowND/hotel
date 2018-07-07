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

    <title>Booking list</title>

    <!-- Bootstrap core CSS -->
    <%--<link href="../static/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" href="../static/css/font-awesome.min.css">--%>
    <%--<link rel="stylesheet" href="../static/css/registre.css">--%>
</head>

<body>

<%--<jsp:include page="header.jsp"></jsp:include>--%>
<div class="container row text-center">
    <h2 class="text-center">BOOKINGS LIST</h2>


    <div class="col-md-10">

        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Guest Phone</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Room Level</th>
                <th>Settlement</th>
                <th>Eviction</th>
                <th>Status</th>
                <th>Booking Date</th>
                <th>CheckIn</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${booking}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.phoneGuest}</td>
                    <td>${book.nameGuest}</td>
                    <td>${book.surnameGuest}</td>
                    <td>${book.roomClass}</td>
                    <td>${book.dateSettlement}</td>
                    <td>${book.dateEviction}</td>
                    <td>${book.status}</td>
                    <td>${book.bookDate}</td>
                    <td><c:if test="${book.status == 'confirmed'}"><a
                            href="/settlement?id=${book.id}">CHECKIN</a> </c:if>
                        <c:if test="${book.status == 'not confirmed'}"><a
                                href="/activate?id=${book.id}">CONFIRM</a></c:if></td>
                    <td><a href="/deletebook?id=${book.id}">DELETE</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-md-2">
        <a href="/settlement" class="btn btn-primary">New Checkin</a>
    </div>


</div> <!-- ./container -->
</body>

</html>
