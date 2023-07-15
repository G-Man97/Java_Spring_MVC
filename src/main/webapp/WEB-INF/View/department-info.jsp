<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Department Info</h2>

<form:form action="saveDepartment" modelAttribute="deps">

    <form:hidden path="id"/>

    Name <form:input path="departmentName"/>
    <br><br>

    <input type="submit" value="OK"/>

</form:form>

</body>
</html>