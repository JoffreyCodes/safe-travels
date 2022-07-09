<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

    <title>Safe Travels</title>

<body>
<div class="container-fluid text-center">
    <form action="cities" method="post">
        <h1>Search for Covid-19 data by location</h1>
        <p>
            <label for="location">Enter a State, County or City</label>
            <input id="location" name="location" value="${fn:escapeXml(param.location)}">
        </p>
        <p>
            <button type="submit" class="btn btn-outline-primary mx-auto text-center" name="button">Search</button>
        </p>
        <span class="text-center" id="successMessage"><b>${messages.success}</b></span>
    </form>

    <div class="row">
        <c:forEach items="${locations}" var="location" >
            <div class="col">
                <div class="m-4 card mx-auto" style="width: 18rem;">
                        <%--            <img src="..." class="card-img-top" alt="...">--%>
                    <div class="card-body">
                        <h5 class="card-title"><c:out value="${location.getCityName()}" /></h5>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">City ID: <c:out value="${location.getCityId()}" /></li>
                        <li class="list-group-item">County: <c:out value="${location.getCountyName()}" /></li>
                    </ul>
                    <div class="card-body">
                        <a class="text-decoration-none" href="stateprofile?name=<c:out value="${location.getStateName()}"/>">
                                ${location.getStateName()}
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
