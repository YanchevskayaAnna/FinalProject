<%@include file="include.jsp" %>
<html>
<head>
    <style type="text/css">
       .unsuccessful_attempt {
        color: red;
       }
    </style>
     <fmt:setLocale value="${empty sessionScope.lang ? 'en' :sessionScope.lang}"/>
     <fmt:setBundle basename="resources"/>
     <title>Login</title>
</head>
<body>

   <form action="" method="post">
       <input type="hidden" name="command" value="ChangeLanguage">
       <button name="lang" type="submit" value="en">en</button>
       <button name="lang" type="submit" value="ru">ru</button>
       <button name="lang" type="submit" value="uk">ua</button>
   </form>

    <div class="centerDiv" align="left">
        <h2><fmt:message key="Login"/></h2>
    </div>
    <div>
     <form method="post">
           <div>
                <label><fmt:message key="email"/></label>
                <input name="email" type="text">
           </div>
           <div>
                <label><fmt:message key="password"/></label>
                <input name="password" type="password" >
           </div>
           <button name="command" value="Login" type="submit"><fmt:message key="Login"/></button>
     </form>
           <div class="unsuccessful_attempt">
             <c:if test="${invalid_data_entered}"><fmt:message key="error_information"/></c:if>
           </div>
    </div>
    <div>
         <a href="${pageContext.request.contextPath}/travelcompany/ShowRegistrationPage"><fmt:message key="Registration"/></a>
    </div>
    <div>
         <a href="${pageContext.request.contextPath}/travelcompany"><fmt:message key="main"/></a>
    </div>
</body>
</html>