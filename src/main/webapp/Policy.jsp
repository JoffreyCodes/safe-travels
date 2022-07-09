<%--Policy webpage - displays relevant policy information for a certain county base on county FIPS--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

    <title>Policy</title>

<body>
<div class="row">
    <c:forEach items="${policyList}" var="policyList" >
        <div class="col">
            <div class="m-4 card" style="width: 18rem;">
                <div class="card-body">
                    <h4 class="card-title"><c:out value="${policyList.getCounty()} County" /></h4>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">State: <c:out value="${policyList.getStateCode()}" /></li>
                    <li class="list-group-item">Status: <c:out value="${policyList.getActive()}" /></li>
                    <li class="list-group-item">Policy Date: <c:out value="${policyList.getPolicyDate()}" /></li>
                    <li class="list-group-item">Policy: <c:out value="${policyList.getContent()}" /></li>
                </ul>
                <div class="card-body">
                    <a class="text-decoration-none" target="_blank" href="<c:out value="${policyList.getResource()}"/>">
                        More Information
                    </a>
                    <br>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
