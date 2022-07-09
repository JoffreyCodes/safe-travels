<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

    <title>Vaccination</title>

<body>

<br/>
<h1>Vaccination Information</h1>
<div class="row">
    <div class="col">
            <div class="m-4 card" style="width: 18rem;">
                <div class="card-body">

                    <h4 class="card-title"><c:out value="${messages.countyName} Vaccination Rates"/></h4>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">State Code: <c:out value="${vaccination.getStateCode()}" /></li>
                    <li class="list-group-item">Vaccination Series Complete Percent: <c:out value="${vaccination.getVaccinationSeriesCompletePct()}" /></li>
                    <li class="list-group-item">Vaccination Series Complete Population: <c:out value="${vaccination.getVaccinationSeriesCompletePop()}" /></li>
                </ul>
            </div>
        </div>
   </div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>