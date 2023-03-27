<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>UserData</title>
</head>
<body>
<h1>WELCOME TO USER DATA !!!</h1>
<p><b>User ID:</b> <span>${usr.userId}</span></p>
<p><b>User Name:</b> <span>${usr.userName}</span></p>
<p><b>User Role:</b> <span>${usr.userRole}</span></p>
<h2>Full Data : <span>${usr}</span></h2>

<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>ROLE</th>
    </tr>
    <c:forEach var="user" items="${usrs}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userRole}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
