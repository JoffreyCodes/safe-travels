<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<jsp:include page="Header.jsp"></jsp:include>

  <title>Safe Travels</title>

<div class="container-fluid content">
  <div class="banner">
    <img src="images/banner.png" class="img-fluid banner" alt="SafeTravelsBanner">
  </div>
  <div class="text-center p-4">
    <a href="FindLocations.jsp" class="btn btn-primary" role="button">Search Location</a>
    <a href="StateProfile.jsp" class="btn btn-primary" role="button">Search States</a>
    <a href="USTravel.jsp" class="btn btn-primary" role="button">Search US Travel</a>
  </div>

  <div class="p-4 container">
    <div class="row">
      <div id="chart" style="width: 75%; margin: auto"></div>
      <div class="mx-2 col">
        <div id="links"></div>
      </div>
    </div>
    <hr/>
    <div class="row">

      <div class="col text-left">

        <h1>About:</h1>
        <p>
          Safe Travels Is a travel advisory website that provides the latest updates for visitors to a specific destination
          in the US. The advisory is based on Covid-19 safety rating system by city and state, and travel recommendations
          and tips by other users. During uncertain times like this, many people are stressed from staying home too long,
          but at the same time, still unsure about travelling due to the unbalanced health precautions across the nation.
          The target market is for people who want to travel, but are not happy with the false information spreading across
          the media. We want to provide our users with a one-stop place for reliable information on which location in the US
          is best for travelling, based on vaccination rate, mask mandate, and other Covid related policies.
        </p>
      </div>

      <div class="mx-4 col">
        <div class="row">
          <div class="text-left">
            <h1>Team Bigfoot is Real:</h1>
            Brittany-Lauren Todd<br>
            Joffrey Inocencio<br>
            Kayla Sear<br>
            Randy Ramli<br>
            Sruti Keerti Munukutla<br>
            Steven Fountain<br>
          </div>
        </div>

        <div class="row">
          <div class="text-left">
            <h1>Data Sources:</h1>
            <a href="https://catalog.data.gov/dataset/covid-19-state-and-county-policy-orders-9408a">Covid-19 State and County
              Policy Orders</a><br>
            <a href="https://catalog.data.gov/dataset/united-states-covid-19-cases-and-deaths-by-state-over-time">United
              States Covid 19 Cases and Deaths By State</a><br>
            <a href="https://github.com/nytimes/covid-19-data">Mask Use</a><br>
            <a href="https://www.bts.gov/daily-travel">Transportation Statistics</a><br>
          </div>
        </div>
      </div>


    </div>

  </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

  <script type="module">
      import {Runtime, Inspector} from "https://cdn.jsdelivr.net/npm/@observablehq/runtime@4/dist/runtime.js";
      import define from "https://api.observablehq.com/d/137d57ab7480a90e.js?v=3";
      new Runtime().module(define, name => {
          if (name === "chart") return new Inspector(document.querySelector("#chart"));
          if (name === "Links") return new Inspector(document.querySelector("#links"));
      });
  </script>

</html>

