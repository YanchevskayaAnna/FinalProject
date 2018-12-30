<%@include file="include.jsp" %>
<html>
<head>
    <title>Cruise</title>
</head>
<body>

    <div class="centerDiv" align="center">
         <h1>${cruiseName}</h1>
    </div>

    <form method="get" action="">
       <div class="centerDiv" align="center" style="width: 1024px; margin: 30px auto;">
              <input type="radio" name="command" id="SortNumber" value="SortNumber" checked>
              <label for="SortNumber">Sort by number</label>
              <input type="radio" name="command" id="SortComfortLevel" value="SortComfortLevel">
              <label for="SortComfortLevel">Sort by comfort level</label>
              <button type="submit">Sort</button>
       </div>
    </form>

    <form method="get" action="">
         <div class="centerDiv" align="center" style="width: 1024px; margin: 30px auto;">
            <input type="radio" name="command" id="ShowCarriages" value="ShowCarriages" checked>
            <label for="ShowCarriages">Show all carriages</label>
            <input type="radio" name="command" id="FilterCarriages" value="FilterCarriages">
            <label for="FilterCarriages">Select by the number of passengers</label>
            <input style="width: 50px" type="text" name="CountPassengerFrom">
            <input style="width: 50px" type="text" name="CountPassengerTo">
            <button type="submit">Filter</button><br/>
         </div>
    </form>

    <c:set var="ports" value="${ports}"/>
    <div align="center" style="width: 1024px; margin: 30px auto; ">
        <table id="table_id" class="display">
            <thead>
            <tr>
                <th style="border: 2px solid grey;">Number</th>
                <th style="border: 2px solid grey;">Type</th>
                <th style="border: 2px solid grey;">Comfort level</th>
                <th style="border: 2px solid grey;">Luggage weight</th>
                <th style="border: 2px solid grey;">Count of passenger</th>
            </tr>
            </thead>
            <tbody id="tBody">
            <c:forEach items="${carriages}" var="carriage">
                <tr>
                    <td align="center" style="border: 1px solid grey;">${carriage.number}</td>
                    <td align="center" style="border: 1px solid grey;">${carriage.typeOfCarriage}</td>
                    <td align="center" style="border: 1px solid grey;">${carriage.comfortLevel}</td>
                    <td align="center" style="border: 1px solid grey;">${carriage.luggageWeight}</td>
                    <td align="center" style="border: 1px solid grey;">${carriage.countOfPassengers}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
