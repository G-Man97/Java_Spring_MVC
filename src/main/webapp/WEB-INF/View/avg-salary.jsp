<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>Average salary by department</h2>
<table cellpadding="10" border="2">
    <h3><tr align="center" valign="middle">
        <th>Department name</th>
        <th>Avg salary</th>
    </h3></tr>

    <c:forEach var="row" items="${obj}">

        <tr align="center" valign="middle">
            <c:forEach var="data" items="${row}">
                <td>${data}</td>
            </c:forEach>
        </tr>

    </c:forEach>
</table>
</body>
</html>
