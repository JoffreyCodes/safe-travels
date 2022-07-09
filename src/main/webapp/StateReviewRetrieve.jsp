<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

    <title>State Review</title>

<body>

<div class="container-fluid">

    <p>
    <h6 class="rating"><u>Rating Key</u></h6>
    Rating 1: Safest State To Travel<br>
    Rating 2: Exercise Normal Precautions<br>
    Rating 3: Exercise Increased Caution<br>
    Rating 4: Reconsider Travel<br>
    Rating 5: Do Not Travel
    </p>

    <h1>${messages.title}</h1>
    <div class="row">
        <c:forEach items="${reviewList}" var="reviews" >
            <div class="m-4 card" style="width: 18rem;">
                <div class="card-body">
                    <h4 class="card-title">Review: <c:out value="${reviews.getReviewId()}" /></h4>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">UserName: <c:out value="${reviews.getUserName()}" /></li>
                    <li class="list-group-item">User Review: <c:out value="${reviews.getUserReview()}" /></li>
                    <li class="list-group-item">Rating: <c:out value="${reviews.getRating()}" /></li>
                </ul>
            </div>
        </c:forEach>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
