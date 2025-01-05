<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
</head>
<body>
    <h1>User Profile</h1>
    <table>
        <tr><th>Name</th><td>${sessionScope.user.name}</td></tr>
        <tr><th>Email</th><td>${sessionScope.user.email}</td></tr>
    </table>
    <a href="index.jsp">Logout</a>
</body>
</html>
