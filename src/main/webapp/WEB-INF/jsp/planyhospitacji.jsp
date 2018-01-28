<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Plany hospitacji - Hospicio</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/mdb.min.css" rel="stylesheet">
    <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

<body>
<nav class="navbar navbar-dark indigo"><span class="navbar-brand">Hospic.io</span> <span
        onclick="window.location.href = '/';" class="navbar" style="color:white;">Powrót</span></nav>
<div class="row">
    <div class="col-md-12">
        <h2 class="text-center py-3"> Plany hospitacji </h2>
    </div>
</div>
<div class="row">
    <div class="offset-md-3 col-md-5">
        <div class="row">
            <form class="form-inline">
                <label for="fieldOfStudy" class="p-2">Kierunek: </label>
                <select id="fieldOfStudy" onchange="onSelectChanged()" class="form-control p-2 m-2">
                    <option value="0">Wybierz</option>
                    <option value="1">Informatyka</option>
                    <option value="2">Inżynieria Systemów</option>
                    <option value="3">Zarządzanie</option>
                </select>
                <label for="accepted" class="p-2">Zaakceptowany: </label>
                <select id="accepted" onchange="onSelectChanged()" class="form-control p-2 m-2">
                    <option value="0">Wybierz</option>
                    <option value="1">Tak</option>
                    <option value="2">Nie</option>
                </select>
            </form>
        </div>
    </div>
</div>
<div class="row">
    <div class="offset-md-1"></div>
    <div class="col-md-10">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Kierunek studiów</th>
                <th>Semestr</th>
                <th>Rok</th>
                <th class="">Data utworzenia</th>
                <th>Zaakceptowany</th>
                <th>Opcje</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${it}" varStatus="count">
                <tr>
                    <th scope="row">${p.id}</th>
                    <th>${p.kierunek.nazwa}</th>
                    <th>${p.semestr.rodzajSemestru.nazwa}</th>
                    <th>${p.semestr.rok1}/${p.semestr.rok2}</th>
                    <th>${p.dataUtworzenia}</th>
                    <th><c:if test="${p.czyZaakceptowany()}">Tak</c:if><c:if
                            test="${!p.czyZaakceptowany()}">Nie</c:if></th>
                    <th>
                        <a href="/plan/${p.id}" class="btn btn-outline-primary btn-sm">Szczegóły</a>
                        <a href="/plan/remove/${p.id}" class="btn btn-outline-danger btn-sm">Usuń</a>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="offset-md-1"></div>
<script>

    function onSelectChanged() {
        var selectBoxStudies = document.getElementById("fieldOfStudy");
        var studies = selectBoxStudies.options[selectBoxStudies.selectedIndex].value;
        var selectBoxAccepted = document.getElementById("accepted");
        var accepted = selectBoxAccepted.options[selectBoxAccepted.selectedIndex].value;
        window.location.href = '/plany?studies=' + studies + '&accepted=' + accepted;
    }

    $(document).ready(function () {
        var urlParams = new URLSearchParams(window.location.search);
        var selectBoxStudies = document.getElementById("fieldOfStudy");
        selectBoxStudies.selectedIndex = urlParams.get("studies");
        var selectBoxAccepted = document.getElementById("accepted");
        selectBoxAccepted.selectedIndex = urlParams.get("accepted");

    });

</script>

</body>

</html>
