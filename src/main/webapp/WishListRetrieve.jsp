<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

    <title>User Wishlists</title>

<body>
<h1>${messages.title}</h1>
<table border="1">
    <tr>
        <th>WishId</th>
        <th>Username</th>
<%--        <th>CityProfile Id</th>--%>
        <th>State name</th>
        <th>County Name</th>
    </tr>
    <c:forEach items="${wishListByUser}" var="userData" >
        <tr>
            <td><c:out value="${userData.getWishListID()}" /></td>
            <td><c:out value="${userData.getUser().getUserName()}" /></td>
<%--            <td><c:out value="${wishListByUser.get()}" /></td>--%>
            <td><c:out value="${userData.getStateProfile().getStateName()}" /></td>
            <td><c:out value="${userData.getCountyProfile().getCountyName()}" /></td>
        </tr>
    </c:forEach>
</table>
<form action="wishlistdelete" method="post">
    <p>
    <div <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
        <label for="username">${userData[0].getUser().getUserName()}</label>
        <input id="username" name="username" value="${fn:escapeXml(param.username)}" readonly>
    </div>
    </p>
    <p>
        <span id="submitButton" <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
            <input type="submit">
			</span>
    </p>
</form>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
