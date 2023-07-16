<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
        <form id="toMain" action="/api/employees">
            <input type="submit" value="<- Main page"/>
        </form><br>
        <form id="back" action="/api/employees/by-department">
            <input type="submit" value="<- back"/>
        </form>

        <h2>Employees by department</h2>

        <br><br>

        <form id="searchEmployee" action="/api/employees/search-employee" method="post">
            <label>Search an employee born </label>
            <input type="date" name="strData" id="fDate" onchange="check()" required/> -
            <input type="date" name="strData" id="sDate" onchange="check()" required/>
            <input type="submit" onclick="showMessage()" value="Search" id="submBut"/>
        </form>

        <script>
            let today = new Date();

            let year = today.getFullYear();
            let month = today.getMonth();
            let day = today.getDay();

            if(month < 10) {month = '0' + month;}
            if(day < 10) {day = '0' + day;}

            let max = (year - 18) + '-' + month + '-' + day;
            let min = (year - 60) + '-' + month + '-' + day;

            const fDate = document.querySelector('#fDate');
            const sDate = document.querySelector('#sDate');

            fDate.min = min;
            fDate.max = max;

            sDate.max = max;

            function check() {
                if(fDate.value > sDate.value) {
                    sDate.value = fDate.value;
                    sDate.min = fDate.value;
                }
            }
            function showMessage() {
                if(fDate.value != '' && sDate.value != '') {
                    alert('There is employee who was born in ' + fDate.value + ' - ' + sDate.value);
                }
            }
        </script>

        <!-- script src="<! c:url value="/resources/js/forView-emp-by-department.js" />"></script-->

        <br><br>

        <table cellpadding="10" border="2">
            <h3>
                <tr align="center" valign="middle">
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Salary</th>
                    <th>Department</th>
                    <th>Actions</th>
                </tr>
            </h3>

            <c:choose>

                <c:when test="${empty listOfEmployeeDTO}">
                    <tr><td colspan="5" align="center" valign="middle">No such employees found</td></tr>
                </c:when>

                <c:when test="${not empty listOfEmployeeDTO}">

                    <c:forEach var="element" items="${listOfEmployeeDTO}">

                        <tr align="center" valign="middle">
                            <td>${element.name}</td>
                            <td>${element.surname}</td>
                            <td>${element.salary}</td>
                            <td>${element.departmentName}</td>

                            <c:url var="updateButton" value="/api/employees/update-employee">
                                <c:param name="empId" value="${element.id}"/>
                            </c:url>

                            <c:url var="deleteButton" value="/api/employees/delete-employee">
                                <c:param name="empId" value="${element.id}"/>
                            </c:url>

                            <td>
                                <input type="button" value="Update" onclick="window.location.href = '${updateButton}'"/>
                                <input type="button" value="Delete" onclick="window.location.href = '${deleteButton}'"/>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
            </c:choose>
        </table>
    </body>
</html>
