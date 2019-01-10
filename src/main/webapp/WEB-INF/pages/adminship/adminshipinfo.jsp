<%@include file="/WEB-INF/pages/service/include.jsp" %>
<html>
<head>
     <fmt:setLocale value="${empty sessionScope.lang ? 'en' :sessionScope.lang}"/>
     <fmt:setBundle basename="resources"/>
     <title><fmt:message key="AdminShipInfo"/></title>
</head>

<body>
 <form action="" method="post">
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
                 <a href="${pageContext.request.contextPath}/travelcompany/client/clientinfo">${userName}</a>
                 <button name="command" type="submit" value="LogOut"><fmt:message key="LogOut"/></button>
             </div>
          </form>
      </c:when>
      <c:otherwise>
           <form action="" method="post">
               <div class="" align="right">
                  <button name="command" type="submit" value="ShowLogin"><fmt:message key="LogIn"/></button>
                  <button name="command" type="submit" value="ShowRegistrationPage" ><fmt:message key="SignUp"/></button>
               </div>
           </form>
     </c:otherwise>
   </c:choose>

 <div class="centerDiv" align="center">
     <h1><fmt:message key="AdminShipInfo"/></h1>
 </div>
 </body>
</html>
