<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

    <body>

        <form id="toMain" action="/">
            <input type="submit" value="<- Main page"/>
        </form>
        <input type="button" value="<- back" onclick="window.location.href='empByDepartment'">

        <h2>Employee by department</h2>

        <br><br>

        <form id="searchEmployee" action="searchEmployee" method="post">
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
            <h3><tr align="center" valign="middle">
                <th>Name</th>
                <th>Surname</th>
                <th>Salary</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
            </h3>

            <c:choose>
                <c:when test="${empty obj}">
                    <tr><td colspan="5" align="center" valign="middle">No such employees found</td></tr>
                </c:when>
                <c:when test="${obj != null}">

                    <c:forEach var="row" items="${obj}">

                        <tr align="center" valign="middle">

                            <c:forEach var="data" items="${row}" varStatus="counter">

                                <c:choose>

                                    <c:when test="${counter.index == 0}">

                                        <c:url var="updateButton" value="/updateEmployee">
                                            <c:param name="empId" value="${data}"/>
                                        </c:url>

                                        <c:url var="deleteButton" value="/deleteEmployee">
                                            <c:param name="empId" value="${data}"/>
                                        </c:url>
                                    </c:when>

                                    <c:when test="${counter.index > 0}">
                                        <td>${data}</td>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
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
