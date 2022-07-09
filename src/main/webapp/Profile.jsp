<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

<title>Safe Travels US Profile</title>

<body>
	<form action="profile" method="get">
		<h1>Search for Covid-19 data by state or county</h1>
		<p>
			<label for="name">Enter a State, County or City</label>
			<input id="name" name="name" value="${fn:escapeXml(param.name)}">
		</p>
		<p>
			<input type="submit">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	<br/>
	<h1>Location Data</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Covid Cases</th>
                <th>Covid Deaths</th>
            </tr>
            <c:forEach items="${profiles}" var="profile" >
                <tr>
                    <td><c:out value="${profile.getProfileId()}" /></td>
                    <td><fmt:formatDate value="${profile.getDate()}" pattern="yyyy-MM-dd"/></td>
                    <td><c:out value="${profile.getCovidCases()}" /></td>
                    <td><c:out value="${profile.getCovidDeaths()}" /></td>
                </tr>
            </c:forEach>
       </table>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
