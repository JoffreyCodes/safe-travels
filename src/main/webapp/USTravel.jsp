<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

    <title>US Travel</title>

<body>
<form action="ustravel" method="get">
    <h1>Travel Statistics for State: Enter state name</h1>
    <p>
        <label for="statename">Search for a State</label>
        <input id="statename" name="statename" value="${fn:escapeXml(param.statename)}">
    </p>
    <p>
        <input type="submit">
        <br/><br/><br/>
        <span id="successMessage"><b>${messages.success}</b></span>
    </p>
</form>
<br/>
<h1>State Travel Data</h1>
<div class="col">
    <div class="m-4 card" style="width: 18rem;">
        <div class="card-body">
            <h4 class="card-title"><c:out value="${usTravelState.getStateName()}"  /></h4>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">State FIPS: <c:out value="${usTravelState.getStateFIPS()}"  /></li>
            <li class="list-group-item">Population Staying at home: <c:out value="${usTravelState.getPopStayingAtHome()}" /></li>
            <li class="list-group-item">Population Not staying at home: <c:out value="${usTravelState.getPopNotStayingAtHome()}" /></li>
            <li class="list-group-item">Percentage taking trips: <c:out value="${usTravelState.getPercentTakingTrips()}" /></li>

        </ul>
        <div class="card-body">
            <a class="text-decoration-none" href="countyprofile?stateProfileId=<c:out value="${usTravelState.getStateProfileID()}"/>">
                View Counties
            </a>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>

