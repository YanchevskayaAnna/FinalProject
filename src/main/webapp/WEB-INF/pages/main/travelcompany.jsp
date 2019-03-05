<%@include file="/WEB-INF/pages/service/include.jsp" %>
<html>
<head>
     <fmt:setLocale value="${empty sessionScope.lang ? 'en' :sessionScope.lang}"/>
     <fmt:setBundle basename="resources"/>
     <title><fmt:message key="CruiseInformation"/></title>
</head>

<body>
 <form method="post">
  <div align="left">
    <input type="hidden" name="command" value="ChangeLanguage">
    <button name="lang" type="submit" value="en">en</button>
    <button name="lang" type="submit" value="ru">ru</button>
    <button name="lang" type="submit" value="uk">ua</button>
   </div>
  </form>

  <c:choose>
      <c:when test="${UserLogIn}">
          <form action="" method="post">
             <div class="" align="right">
                 <a href="${pageContext.request.contextPath}/ShowUserInfo">${userName}</a>
                 <button name="command" type="submit" value="LogOut"><fmt:message key="LogOut"/></button>
             </div>
          </form>
      </c:when>
      <c:otherwise>
           <form action="" method="post">
               <div class="" align="right">
                  <button name="command" type="submit" value="ShowLoginPage"><fmt:message key="LogIn"/></button>
                  <button name="command" type="submit" value="ShowRegistrationPage" ><fmt:message key="SignUp"/></button>
               </div>
           </form>
     </c:otherwise>
   </c:choose>

 <div align="center">
     <h1><fmt:message key="Welcome"/></h1>
     <h2><fmt:message key="Cruises"/></h2>
 </div>

<c:set var="cruises" value="${cruises}"/>
    <div align="center" style="width: 1024px; margin: 30px auto;">
        <table id="table_id" class="display">
            <thead>
            <tr style="border: 1px solid grey;">
                <th style="border: 2px solid grey;">Name</th>
                <th style="border: 2px solid grey;">Date start</th>
                <th style="border: 2px solid grey;">Date finish</th>
                <th style="border: 2px solid grey;">Count of days</th>
                <th style="border: 2px solid grey;">Ship</th>
                <th style="border: 2px solid grey;">Ship capacity</th>
                <th style="border: 2px solid grey;">Number of free places</th>
            </tr>
            </thead>
            <tbody id="tBody">
            <c:forEach items="${cruises}" var="cruise">
                <tr>
                    <td align="center" style="border: 1px solid grey;">
                        <a href="${pageContext.request.contextPath}/?command=ShowCruiseDetails&cruiseID=${cruise.id}&cruiseName=${cruise.name}&ship=${cruise.shipName}&shipCapacity=${cruise.shipCapacity}&countFreePlaces=${cruise.countFreePlaces}">${cruise.name}</a>
                    </td>
                    <td align="center" style="border: 1px solid grey;">${cruise.dateStart}</td>
                    <td align="center" style="border: 1px solid grey;">${cruise.dateFinish}</td>
                    <td align="center" style="border: 1px solid grey;">${cruise.countOfDays}</td>
                    <td align="center" style="border: 1px solid grey;">${cruise.shipName}</td>
                    <td align="center" style="border: 1px solid grey;">${cruise.shipCapacity}</td>
                    <td align="center" style="border: 1px solid grey;">${cruise.countFreePlaces}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
     </div>

</body>
</html>
