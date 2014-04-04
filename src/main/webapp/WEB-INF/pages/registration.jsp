<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add new user</title>
</head>
<body>

<div style="background: #e0eeee; width: 350; height: 240; margin: auto; margin-top: 150; padding: 20; padding-top: 0;
 border: black; border-style: solid; border-width: 1px;">

    <div align="center"><p style="font-family: Arial; font-size: 20">Registration</p></div>

    <form:form method="POST" modelAttribute="user" action="${pageContext.request.contextPath}/registration">

        <table width="100%" style="margin-top: 30">

            <tr>
                <td>Name:</td>
                <td align="right"><form:input type="text" path="firstName"/></td>
                <td><form:errors path="firstName" cssstyle="color: red;"></form:errors></td>
            </tr>
            <tr>
                <td>Surname:</td>
                <td align="right"><form:input type="text" path="lastName"/></td>
                <td><form:errors path="lastName" cssstyle="color: red;"></form:errors></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td align="right"><form:input type="text" path="phoneNumber"/></td>
                <td><form:errors path="phoneNumber" cssstyle="color: red;"></form:errors></td>
            </tr>

            <tr>
                <td colspan="2" height="30">
                    <p align="center" style="color: red">${message}</p>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <p align="center"><input type="submit" value="registration" style="width: 200"></p>
                </td>
            </tr>
        </table>


    </form:form>

</div>

</body>
</html>

