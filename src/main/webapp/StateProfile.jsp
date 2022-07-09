<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

<%--    Chart.js script--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.6.2/chart.min.js" integrity="sha512-tMabqarPtykgDtdtSqCL3uLVM0gS1ZkUAVhRFu1vSEFgvB73niFQWJuvviDyBGBH22Lcau4rHB5p2K2T0Xvr6Q==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>State Profiles</title>

<body onload="drawChart()">
<div class="container-fluid mx-auto text-center">
    <form action="stateprofile" method="get">
        <h1>State Profiles</h1>
        <p class="text-center">
            <label for="name">Search for a State </label>
            <input class="w-22 p-1" id="name" name="name" value="${fn:escapeXml(param.name)}">
        </p>
        <p>
            <button type="submit" class="btn btn-outline-primary mx-auto text-center" name="button">Search</button>
        </p>
    </form>
    <span class="text-center" id="successMessage"><b>${messages.success}</b></span>

    <p class="text-center">
    <h6 class="rating"> <u>Rating Key</u></h6>
        Rating 1: Safest State To Travel<br>
        Rating 2: Exercise Normal Precautions<br>
        Rating 3: Exercise Increased Caution<br>
        Rating 4: Reconsider Travel<br>
        Rating 5: Do Not Travel
    </p>

    <div class="row">

        <c:forEach items="${stateProfiles}" var="stateProfile" >
            <div class="col">
                <div class="m-4 card mx-auto" style="width: 25rem;">
                    <div class="card-body">
                        <h4 class="card-title"><c:out value="${stateProfile.getStateName()}" /></h4>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Safety Rating: <c:out value="${stateProfile.getSafetyRating()}" /></li>
                        <li class="list-group-item">Total Cases: <c:out value="${stateProfile.getCovidCases()}" /></li>
                        <li class="list-group-item">Total Deaths: <c:out value="${stateProfile.getCovidDeaths()}" /></li>
                    </ul>
                    <div class="card-body">
                        <a class="text-decoration-none" href="countyprofile?stateProfileId=<c:out value="${stateProfile.getProfileId()}"/>">
                            View Counties
                        </a>
                        <br>
                        <a class="text-decoration-none" href="statereview?stateProfileId=<c:out value="${stateProfile.getProfileId()}"/>">
                            View Reviews
                        </a>
                </div>

<%--                    Pie Chart displaying travel data for certain state--%>
                    <script type="text/javascript" items="${usTravel}" var="usTravel">
                        function drawChart() {
                            const population = [<c:out value="${usTravel.getPopStayingAtHome()}"/>, <c:out value="${usTravel.getPopNotStayingAtHome()}"/>];
                            const populationStats = ['PopStayingAtHome', 'PopNotStayingAtHome'];
                            new Chart('myChart', {
                                type: 'pie',
                                data: {
                                    labels: populationStats,
                                    datasets: [{
                                        label: 'Population Travel Data',
                                        data: population,
                                        backgroundColor: ['rgb(255, 99, 132)', 'rgb(54, 162, 235)']
                                    }]
                                },

                            });
                        }
                    </script>
                    <canvas id="myChart" width="800" height="400"></canvas>
            </div>
        </c:forEach>
    </div>
</div>

</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
