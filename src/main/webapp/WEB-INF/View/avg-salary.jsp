<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>Average salary by department</h2>
        <table cellpadding="10" border="2">
            <h3>
                <tr align="center" valign="middle">
                    <th>Name</th>
                    <th>Average salary</th>
                </tr>
            </h3>

            <c:forEach var="element" items="${list}">

                <tr align="center" valign="middle">
                    <td>${element.departmentName}</td>
                    <td>${element.averageSalary}</td>
                </tr>

            </c:forEach>
        </table>
    </body>
</html>
