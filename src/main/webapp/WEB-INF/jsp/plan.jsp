<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Plan hospitacji - szczegóły</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/mdb.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">

<body>
<nav class="navbar navbar-dark indigo"><span class="navbar-brand">Hospic.io</span>
    <span class="navbar" onclick="window.location.href = '/plany';" style="color:white;">Powrót</span>
</nav>
<div class="row">
    <div class="offset-md-1 col-md-10">
        <h2 class="text-center py-3"> Szczegóły planu hospitacji </h2>
        <form class="form-inline">
            <div class="form-group"><label class="m-2">Kierunek studiów</label>
                <input type="text" name="email" class="form-control m-2 p-2" disabled="" value="${it.kierunek.nazwa}">
            </div>
            <div class="form-group"><label class="m-2">Semestr</label>
                <input type="text" name="password" class="form-control m-2 p-2" disabled=""
                       value="${it.semestr.rodzajSemestru.nazwa}"></div>
            <div class="form-group"><label class="m-2">Rok</label>
                <input type="text" name="password" class="form-control m-2 p-2" disabled=""
                       value="${it.semestr.rok1}/${it.semestr.rok2}"></div>
            <a class="label label-warning text-danger">
                <c:if test="${it.czyZaakceptowany()}">Zatwierdzony</c:if>
                <c:if test="${!it.czyZaakceptowany()}">Niezatwierdzony</c:if></a>
        </form>
    </div>
</div>
<div class="row">
    <div class="offset-md-1 col-md-10">
        <form class="form-inline">
            <div class="form-group"><label class="m-2">Data utworzenia</label>
                <input type="text" name="password" class="form-control m-2 p-2" disabled=""
                       value="${it.dataUtworzenia}"></div>
            <div class="form-group"><label class="m-2">Data akceptacji</label>
                <input type="text" name="password" class="form-control m-2 p-2" disabled=""
                       value="<c:if test="${it.czyZaakceptowany()}">${it.dataAkceptacji}</c:if>"></div>
            <a class="btn btn-success pi-draggable ml-auto" href="">Edytuj </a>
            <a class="btn btn-danger pi-draggable" <c:if test="${!it.czyZaakceptowany()}">href="/plan/${it.id}/zatwierdz"</c:if>  draggable="true">
                <c:if test="${!it.czyZaakceptowany()}">Zatwierdź</c:if>
                <c:if test="${it.czyZaakceptowany()}">Anuluj zatwierdzenie</c:if></a>
        </form>
    </div>
</div>
<div class="row">
    <div class="offset-md-2 col-md-8">
        <h5 class="text-center py-3"> Zaplanowane hospitacje </h5>
    </div>
</div>
<div class="row">
    <div class="offset-md-1 col-md-10">
        <table class="table">
            <thead>
            <tr>
                <th>Kod</th>
                <th>Kurs</th>
                <th>Prowadzący</th>
                <th>Rola pracownika</th>
                <th>Dziedzina kursu</th>
                <th>Opcje</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="h" items="${it.hospitacje}" varStatus="count">
                <tr id="main${count.index}">
                    <th>${h.kurs.kod}</th>
                    <th>${h.kurs.nazwa}</th>
                    <th>${h.hospitowany.stopienNaukowy.nazwa} ${h.hospitowany.imie} ${h.hospitowany.nazwisko}</th>
                    <th>${h.hospitowany.rola.nazwa}</th>
                    <th>${h.kurs.dziedzina.nazwa}</th>
                    <th><img id="rollbtn${count.index}" onclick="expand('${count.index}')"
                             src="${pageContext.request.contextPath}/static/assets/menu-down.png"></th>
                </tr>

                <tr id="details${count.index}" style="display: none;" class="bg-info text-white">
                    <td colspan="6" class="">
                        <div class="col-md-12">
                            <table class="w-100 text-white">
                                <thead>
                                <tr>
                                    <th>Rola w komisji</th>
                                    <th>Pracownik</th>
                                    <th>Specjalności</th>
                                    <th>Obciążenie</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <th>Przewodniczący</th>
                                    <th>${h.komisja.przewodniczacy.stopienNaukowy.nazwa}&nbsp;${h.komisja.przewodniczacy.imie}&nbsp;${h.komisja.przewodniczacy.nazwisko}</th>
                                    <th>
                                        <c:forEach var="spec" items="${h.komisja.przewodniczacy.specjalizacje}">
                                            ${spec.nazwa}&nbsp;
                                        </c:forEach>
                                    </th>
                                    <th>${h.komisja.przewodniczacy.obciazenie}</th>
                                </tr>
                                <c:forEach var="cz" items="${h.komisja.czlonkowie}">
                                    <tr>
                                        <th>Członek</th>
                                        <th>${cz.stopienNaukowy.nazwa}&nbsp;${cz.imie}&nbsp;${cz.nazwisko}</th>
                                        <th><c:forEach var="spec2" items="${cz.specjalizacje}">
                                            ${spec2.nazwa}&nbsp;
                                        </c:forEach></th>
                                        <th>${cz.obciazenie}</th>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <th colspan="3"></th>
                                    <th>
                                        <a href="#" class="btn btn-success text-white">edytuj</a>
                                    </th>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</div>
<script>

    function expand(count) {
        var main = document.getElementById("main" + count);
        if (main.className === "") {
            main.className = "bg-info text-white";

            var details = document.getElementById("details" + count);
            details.removeAttribute("style");

            var btn = document.getElementById("rollbtn" + count);
            btn.src = "/static/assets/menu-up.png"
        } else {
            main.className = "";

            var details = document.getElementById("details" + count);
            details.style = "display: none;";

            var btn = document.getElementById("rollbtn" + count);
            btn.src = "/static/assets/menu-down.png"
        }


    }

    function collapse(count) {
        var main = document.getElementById("details" + count);
        main.className = "";

        var details = document.getElementById("details" + count);
        details.style = 'display: none;';

        var btn = document.getElementById("rollbtn" + count);
        btn.onclick = function () {
            expand(count);
        }
    }


</script>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/mdb.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/popper.min.js"></script>
</body>

</html>
