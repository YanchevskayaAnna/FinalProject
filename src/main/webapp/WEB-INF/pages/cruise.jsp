<%@include file="include.jsp" %>
<html>
<head>
    <title>Cruise</title>
</head>
<body>

    <div class="centerDiv" align="center">
         <h1>${cruiseName}</h1>
    </div>


 <div class="centerDiv" align="center">
     <h2><fmt:message key="CruiseRoute" bundle="${bundle}"/></h2>
 </div>

    <c:set var="ports" value="${ports}"/>
    <div align="center" style="width: 1024px; margin: 30px auto; ">
        <table id="table_id" class="display">
            <thead>
            <tr>
                <th style="border: 2px solid grey;">Port</th>
                <th style="border: 2px solid grey;">Date arrival</th>
            </tr>
            </thead>
            <tbody id="tBody">
            <c:forEach items="${ports}" var="port">
                <tr>
                    <td align="center" style="border: 1px solid grey;">${port.idPort}</td>
                    <td align="center" style="border: 1px solid grey;">${port.dateArrival}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
