<%@include file="include.jsp" %>
<html>
<head>
     <fmt:setLocale value="${empty sessionScope.lang ? 'en' :sessionScope.lang}"/>
     <fmt:setBundle basename="resources"/>
     <title>Cruise excursions</title>
</head>
<body>

    <div class="centerDiv" align="center">
         <h1>${cruiseName}</h1>
         <h1>${portID}</h1>
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
         <a href="${pageContext.request.contextPath}/travelcompany"><fmt:message key="main"/></a>
    </div>

</body>
</html>