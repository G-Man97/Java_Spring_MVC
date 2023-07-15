<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
    <h2>All Departments</h2>
    <table cellpadding="10" border="2">
        <h3><tr align="center" valign="middle">
            <th>Id</th>
            <th>Name</th>
            <th>Actions</th>
        </tr></h3>

        <c:forEach var="dep" items="${allDeps}">

            <c:url var="updateButton" value="/updateDepartment">
                <c:param name="depId" value="${dep.id}"/>
            </c:url>

            <c:url var="deleteButton" value="/deleteDepartment">
                <c:param name="depId" value="${dep.id}"/>
            </c:url>

            <tr align="center" valign="middle">
                <td>${dep.id}</td>
                <td>${dep.departmentName}</td>
                <td>
                    <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                    <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
                </td>
            </tr>

        </c:forEach>
    </table>
    <br>
    <input type="button" value="Add department" onclick="window.location.href = 'addNewDepartment'">
</body>
</html>
