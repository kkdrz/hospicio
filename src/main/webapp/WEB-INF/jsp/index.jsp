<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Hospicio</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/mdb.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-dark indigo"><span class="navbar-brand">Hospic.io</span>
    <h8 style="color:white; font-size:12px;">Zalogowano jako: ktoś</h8>
</nav>
<div class="row mt-5">
    <div class="offset-md-3"></div>
    <div class="col-md-6">
        <div  onclick="window.location.href = '/plany?studies=0&accepted=0';" class="card info-color text-center z-depth-2">
            <div class="card-body">
                <p class="white-text mb-0">Przeglądaj plany hospitacji</p>
            </div>
        </div>
    </div>
    <div class="offset-md-3"></div>
</div>
<div class="row mt-3">
    <div class="offset-md-3"></div>
    <div class="col-md-6">
        <div onclick="window.location.href = '/prezentacja';" class="card info-color text-center z-depth-2">
            <div class="card-body">
                <p class="white-text mb-0">Utwórz prezentację wyników hospitacji</p>
            </div>
        </div>
    </div>
    <div class="offset-md-3"></div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</body>

</html>