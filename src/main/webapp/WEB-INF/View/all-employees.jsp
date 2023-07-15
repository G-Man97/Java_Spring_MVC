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


                <c:forEach var="emp" items="${allEmps}">

                    <c:url var="updateButton" value="/updateEmployee">
                        <c:param name="empId" value="${emp.id}"/>
                    </c:url>

                    <c:url var="deleteButton" value="/deleteEmployee">
                        <c:param name="empId" value="${emp.id}"/>
                    </c:url>

                    <tr align="center" valign="middle">
                        <td>${emp.name}</td>
                        <td>${emp.surname}</td>
                        <td>${emp.birthday}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.department.id}</td>
                        <td>
                            <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                            <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
                        </td>
                    </tr>

                </c:forEach>
            </table>
    <br>
    <input type="button" value="Add employee" onclick="window.location.href = 'addNewEmployee'"/>
    <br><br>
    <input type="button" value="Average salary by department" onclick="window.location.href = 'avgSalary'"/>
    <input type="button" value="Employee by department" onclick="window.location.href = 'empByDepartment'"/>

</body>
</html>
