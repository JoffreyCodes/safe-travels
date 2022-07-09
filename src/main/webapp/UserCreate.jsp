<%--Webpage to create an account--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="Header.jsp"></jsp:include>

    <title>Create Account</title>

<body>
<%--<h1>Safe Travels</h1>--%>
<form action="usercreate" method="post">
    <p>

        <div class="input-group mb-3">
            <span for="username" class="input-group-text" id="inputGroup-sizing-default">Username</span>
            <input  id="username" name="username" value="" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
        </div>

    </p>
    <p>
        <div class="input-group mb-3">
            <span for="email" class="input-group-text" id="inputGroup-sizing-default">Email</span>
            <input  id="email" name="email" value="" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
        </div>
    </p>
    <p>
        <div class="input-group mb-3">
            <span for="password" class="input-group-text" id="inputGroup-sizing-default">Password</span>
            <input  id="password" name="password" value="" type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" size="20">
        </div>

    </p>
    <p>
    <div class="input-group mb-3">
        <span for="password2" class="input-group-text" id="inputGroup-sizing-default">Re-Type Password</span>
        <input  id="password2" name="password2" value="" type="password" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" size="20">
    </div>

    </p>
    <p>
        <button type="submit" class="btn btn-outline-primary" name="button">Create an Account</button>
    </p>
</form>
<br/><br/>
<p>
    <span id="successMessage"><b>${messages.success}</b></span>
</p>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>