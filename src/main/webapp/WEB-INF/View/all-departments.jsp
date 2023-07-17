<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body>
        <form id="toMain" action="${pageContext.request.contextPath}/api/employees">
            <input type="submit" value="<- Main page"/>
        </form>

        <h2>All Departments</h2>
        <table cellpadding="10" border="2">
            <h3>
                <tr align="center" valign="middle">
                    <th>Id</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </h3>

            <c:forEach var="department" items="${listOfDepartments}">

                <c:url var="updateButton" value="/api/departments/update-department">
                    <c:param name="departmentId" value="${department.id}"/>
                </c:url>

                <c:url var="deleteButton" value="/api/departments/delete-department">
                    <c:param name="departmentId" value="${department.id}"/>
                </c:url>

                <tr align="center" valign="middle">
                    <td>${department.id}</td>
                    <td>${department.departmentName}</td>
                    <td>
                        <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                        <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
                    </td>
                </tr>

            </c:forEach>
        </table>
        <br>
        <input type="button" value="Add department" onclick="window.location.href = '/api/departments/add-new-department'">
    </body>
</html>
