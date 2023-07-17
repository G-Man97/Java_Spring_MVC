<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <body>

        <form id="back" action="${pageContext.request.contextPath}/api/departments">
            <input type="submit" value="<- back"/>
        </form>

        <h2>Department Info</h2>

        <form:form action="/api/departments/save-department" modelAttribute="department">

            <form:hidden path="id"/>

            Name <form:input path="departmentName" pattern="[A-Z_]{2,24}"/>
            <br><br>

            <input type="submit" value="OK"/>

        </form:form>

        <c:if test="${departmentNameIsNotUnique != null}">
            <h3>The name of the department must be unique!</h3>
        </c:if>
    </body>
</html>