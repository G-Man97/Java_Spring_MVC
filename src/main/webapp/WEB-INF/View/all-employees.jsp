<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
        <h2>All Employees</h2>
            <table cellpadding="10" border="2">
                <h3><tr align="center" valign="middle">
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Birthday</th>
                    <th>Salary</th>
                    <th>Department_id</th>
                    <th>Actions</th>
                </tr></h3>


                <c:forEach var="employee" items="${listOfEmployees}">

                    <c:url var="updateButton" value="/api/employees/update-employee">
                        <c:param name="employeeId" value="${employee.id}"/>
                    </c:url>

                    <c:url var="deleteButton" value="/api/employees/delete-employee">
                        <c:param name="employeeId" value="${employee.id}"/>
                    </c:url>

                    <tr align="center" valign="middle">
                        <td>${employee.name}</td>
                        <td>${employee.surname}</td>
                        <td>${employee.birthday}</td>
                        <td>${employee.salary}</td>
                        <td>${employee.department.id}</td>
                        <td>
                            <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                            <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        <br>
        <input type="button" value="Add employee" onclick="window.location.href = '/api/employees/add-new-employee'"/>
        <br><br>
        <input type="button" value="Average salary by department" onclick="window.location.href = '/api/departments/average-salary-by-department'"/>
        <input type="button" value="Employees by department" onclick="window.location.href = '/api/employees/by-department'"/>

    </body>
</html>
