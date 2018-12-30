<%@include file="include.jsp" %>
<html>
<head>
     <fmt:setLocale value="${empty sessionScope.lang ? 'en' :sessionScope.lang}"/>
     <fmt:setBundle basename="resources" var="bundle"/>
     <title>Cruise</title>
</head>
<body>

    <div class="centerDiv" align="center">
         <h1>${cruiseName}</h1>
         <h2><fmt:message key="CruiseRoute" bundle="${bundle}"/></h2>
    </div>

    <c:set var="ports" value="${ports}"/>
    <div align="center" style="width: 1024px; margin: 30px auto; ">
        <table id="table_id" class="display">
            <thead>
            <tr>
                <th style="border: 2px solid grey;">Port</th>
                <th style="border: 2px solid grey;">Date arrival</th>
                <th style="border: 2px solid grey;">Excursions</th>
            </tr>
            </thead>
            <tbody id="tBody">
            <c:forEach items="${ports}" var="port">
                <tr>
                    <td align="center" style="border: 1px solid grey;">${port.idPort}</td>
                    <td align="center" style="border: 1px solid grey;">${port.dateArrival}</td>
                     <td align="center" style="border: 1px solid grey;">
                         <a href="${pageContext.request.contextPath}/?command=ShowCruiseExcursions&cruiseID=${cruiseID}&cruiseName=${cruiseName}&portID=${port.idPort}"">Show excursions</a>
                     </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
