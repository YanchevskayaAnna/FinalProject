<%@include file="include.jsp" %>
<html>
<head>
     <fmt:setLocale value="${empty sessionScope.lang ? 'en' :sessionScope.lang}"/>
     <fmt:setBundle basename="resources"/>
     <title>Registration</title>
</head>
<body>

   <form action="" method="post">
       <input type="hidden" name="command" value="ChangeLanguage">
       <button name="lang" type="submit" value="en">en</button>
       <button name="lang" type="submit" value="ru">ru</button>
       <button name="lang" type="submit" value="uk">ua</button>
   </form>

    <div class="centerDiv" align="left">
        <h2><fmt:message key="Registration"/></h2>
    </div>
    <div>
     <form action="" method="post">
            <div>
                <label><fmt:message key="name"/></label>
                <input name="name" type="text">
            </div>
           <div>
                <label><fmt:message key="email"/></label>
                <input name="email" type="text">
           </div>
           <div>
                <label><fmt:message key="password"/></label>
                <input name="password" type="password" >
           </div>
           <div>
                <label><fmt:message key="phone"/></label>
                <input name="phone" type="phone">
           </div>
           <button name="command" value="Registration" type="submit"><fmt:message key="SignUp"/></button>
     </form>
     <div>
         <c:if test="${invalid_data_entered}"><fmt:message key="${error_information}"/></c:if>
     </div>
    </div>

    <div>
        <a href="${pageContext.request.contextPath}/travelcompany"><fmt:message key="main"/></a>
    </div>

</body>
</html>