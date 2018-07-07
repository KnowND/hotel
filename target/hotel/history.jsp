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

    <title>HISTORY</title>

    <!-- Bootstrap core CSS -->
    <%--<link href="../static/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" href="../static/css/font-awesome.min.css">--%>
    <%--<link rel="stylesheet" href="../static/css/registre.css">--%>
</head>

<body>
<div class="container">
    <h2>HISTORY</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Guest</th>
            <th>Administrator</th>
            <th>Room</th>
            <th>Cost</th>
            <th>Settlement</th>
            <th>Eviction</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${history}" var="hi">
            <tr>
                <td>${hi.guest}</td>
                <td>${hi.employee}</td>
                <td>${hi.room}</td>
                <td>${hi.cost}</td>
                <td>${hi.dateSettlement}</td>
                <td>${hi.dateEviction}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>


</div> <!-- ./container -->
</body>
</html>
