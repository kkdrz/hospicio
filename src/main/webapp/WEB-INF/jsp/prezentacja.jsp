<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Prezentacja</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/mdb.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/mdb.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

<body>
<nav class="navbar navbar-dark indigo"><span class="navbar-brand">Hospic.io</span>
    <span class="navbar" onclick="window.location.href = '/';" style="color:white;">Powrót</span></nav>
<div class="row">
    <div class="offset-md-1 col-md-10">
        <h2 class="text-center py-3"> Tworzenie prezentacji wyników </h2>
    </div>
</div>
<div class="row">
    <div class="offset-md-2 col-md-8 offset-md-2">
        <h5 class="text-center"> Wybierz plan hospitacji, którego ma dotyczyć prezentacja </h5>
    </div>
    <div class="offset-md-3 col-md-10">
        <div class="form-check"><label class="form-check-label">
            <input class="form-check-input" id="checkbox1" type="checkbox" value="">
            Chcę porównac wyniki wybranego planu hospitacji z wynikami hospitacji z poprzednich lat.
        </label></div>
    </div>
</div>
<div class="row">
    <div class="offset-md-1 col-md-10">
        <table id="table1" class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Kierunek studiów</th>
                <th>Semestr</th>
                <th>Rok</th>
                <th class="">Data utworzenia</th>
                <th>Data akceptacji</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${it}" varStatus="count">
                <tr id="row${p.id}">
                    <th scope="row">${p.id}</th>
                    <th>${p.kierunek.nazwa}</th>
                    <th>${p.semestr.rodzajSemestru.nazwa}</th>
                    <th>${p.semestr.rok1}/${p.semestr.rok2}</th>
                    <th>${p.dataUtworzenia}</th>
                    <th>${p.dataAkceptacji}</th>
                    <th>
                        <a href="#hidden1" onclick="select1(${p.id})" class="btn btn-outline-primary btn-sm">Wybierz</a>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div id="hidden1" style="display: none;" class="row">
    <div class="offset-md-2 col-md-8 mt-5">
        <h5 class="text-center py-3"> Wybierz plan hospitacji, którego wyniki chcesz porównać: </h5>
    </div>
</div>
<div id="hidden2" style="display: none;" class="row">
    <div class="offset-md-1 col-md-10">
        <table id="table2" class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Kierunek studiów</th>
                <th>Semestr</th>
                <th>Rok</th>
                <th class="">Data utworzenia</th>
                <th>Data akceptacji</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${it}" varStatus="count">
                <tr id="row_second${p.id}">
                    <th scope="row">${p.id}</th>
                    <th>${p.kierunek.nazwa}</th>
                    <th>${p.semestr.rodzajSemestru.nazwa}</th>
                    <th>${p.semestr.rok1}/${p.semestr.rok2}</th>
                    <th>${p.dataUtworzenia}</th>
                    <th>${p.dataAkceptacji}</th>
                    <th>
                        <button onclick="select2(${p.id})" class="btn btn-outline-primary btn-sm">Wybierz</button>
                    </th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="offset-md-5 col-md-6">
        <a id="c_button" class="btn btn-primary pi-draggable" onclick="generate()" draggable="true">Generuj! </a>
    </div>
</div>

<script>
    var chosen1;
    var chosen2;

    function generate() {
        window.location.href = '/generate?hosp1=' + chosen1 + '&hosp2=' + chosen2;
        select1(-1);
        select2(-2);
        setTimeout(function () {
            window.location.href = '/';
        }, 2000);
    }

    function select1(index) {
        chosen1 = index;

        $('#table1 > tbody > tr').css("background-color", "");

        $("#row" + index).css("background-color", "#8c9aaf");

        if ($("#checkbox1").is(':checked')) {
            $("#hidden1").css("display", "");
            $("#hidden2").css("display", "");
        } else {
            $("#hidden1").css("display", "none");
            $("#hidden2").css("display", "none");
        }

    }

    function select2(index) {
        chosen2 = index;

        $('#table2 > tbody > tr').css("background-color", "");

        $("#row_second" + index).css("background-color", "#8c9aaf");

        if ($("#checkbox1").is(':checked')) {
            $("#hidden1").css("display", "");
            $("#hidden2").css("display", "");
        } else {
            $("#hidden1").css("display", "none");
            $("#hidden2").css("display", "none");
        }

    }
</script>

</body>

</html>