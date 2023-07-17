<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>
        <form id="back" action="${pageContext.request.contextPath}/api/employees">
            <input type="submit" value="<- back"/>
        </form>

        <h2>Employee Info</h2>

        <form:form action="/api/employees/save-employee" modelAttribute="employee" method="post">

            <form:hidden path="id"/>

            Name <form:input path="name" placeholder="Ivan" pattern="[A-Z]{1}[a-z]{1,24}" title="Use symbols A-Z, a-z, min 2 symbols" required="true"/>
            <br><br>
            Surname <form:input path="surname" placeholder="Ivanov" pattern="[A-Z]{1}[a-z]{1,24}" title="Use symbols A-Z or a-z min 2 symbols" required="true"/>
            <br><br>
            Birthday <input type="date" name="birthday" id="birthday" value="${employee.birthday}"/>

            <script>
                let today = new Date();

                let year = today.getFullYear();
                let month = today.getMonth();
                let day = today.getDay();

                if(month < 10) {month = '0' + month;}
                if(day < 10) {day = '0' + day;}

                let max = (year - 18) + '-' + month + '-' + day;
                let min = (year - 60) + '-' + month + '-' + day;

                const birthday = document.querySelector('#birthday');

                birthday.min = min;
                birthday.max = max;
            </script>
            <!--script src="<!c:url value="/resources/js/main.js" />"></script-->

            <br><br>
            Salary <form:input path="salary" pattern="(([5-9]\d{2}\.\d{1,2})|([5-9]\d{2}))|(([1-9]\d{3,5}.\d{1,2})|([1-9]\d{3,5}))" title="Min value is 500, max value is 999 999"/>
            <br><br>
            Department <form:select path="department.id">

                <form:form modelAttribute="listOfDepartments">
                    <c:forEach var="department" items="${listOfDepartments}">
                        <form:option value="${department.id}" label="${department.departmentName}"/>
                    </c:forEach>
                </form:form>

            </form:select>
            <br><br>

            <input type="submit" value="OK"/>
        </form:form>
    </body>
</html>
