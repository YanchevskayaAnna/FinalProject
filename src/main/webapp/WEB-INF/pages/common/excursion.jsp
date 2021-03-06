<%@include file="/WEB-INF/pages/service/include.jsp" %>
<html>
<head>
     <fmt:setLocale value="${empty sessionScope.lang ? 'en' :sessionScope.lang}"/>
     <fmt:setBundle basename="resources"/>
     <title>Cruise excursions</title>
</head>
<body>

  <form action="" method="post">
        <input type="hidden" onClick="document.location.reload(true)">
        <button name="lang" type="submit" value="en">en</button>
        <button name="lang" type="submit" value="ru">ru</button>
        <button name="lang" type="submit" value="uk">ua</button>
  </form>

<c:choose>
      <c:when test="${UserLogIn}">
          <form action="ShowCruiseExcursions" method="post">
             <div class="" align="right">
                 <a href="${pageContext.request.contextPath}/ShowUserInfo">${userName}</a>
                 <button name="command" type="submit" value="LogOut"><fmt:message key="LogOut"/></button>
             </div>
          </form>
      </c:when>
      <c:otherwise>
           <form action="ShowCruiseExcursions" method="post">
               <div class="" align="right">
                  <button name="command" type="submit" value="ShowLoginPage"><fmt:message key="LogIn"/></button>
                  <button name="command" type="submit" value="ShowRegistrationPage" ><fmt:message key="SignUp"/></button>
               </div>
           </form>
     </c:otherwise>
   </c:choose>

    <div class="centerDiv" align="center">
         <h1>${cruiseName}</h1>
         <h1>${portName}</h1>
         <h2><fmt:message key="Excursions"/></h2>
    </div>

    <c:set var="excursions" value="${excursions}"/>
    <div align="center" style="width: 1024px; margin: 30px auto; ">
        <table id="table_id" class="display">
            <thead>
            <tr>
                <th style="border: 2px solid grey;">Name</th>
                <th style="border: 2px solid grey;">Price</th>
            </tr>
            </thead>
            <tbody id="tBody">
            <c:forEach items="${excursions}" var="excursion">
                <tr>
                    <td align="center" style="border: 1px solid grey;">${excursion.name}</td>
                    <td align="center" style="border: 1px solid grey;">${excursion.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div>
         <a href="${pageContext.request.contextPath}"><fmt:message key="main"/></a>
    </div>

</body>
</html>