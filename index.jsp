<!DOCTYPE html>
<html>
<head>
    <title>Healthcare Management</title>
</head>
<body>
    <h1>Welcome to Healthcare Management System</h1>
    <form action="user" method="post">
        <input type="hidden" name="action" value="register">
        <label>Name: </label><input type="text" name="name" required><br>
        <label>Email: </label><input type="email" name="email" required><br>
        <label>Password: </label><input type="password" name="password" required><br>
        <button type="submit">Register</button>
    </form>
    <c:if test="${param.success == 1}">
        <p>Registration successful!</p>
    </c:if>
    <c:if test="${param.error == 1}">
        <p>Registration failed. Try again!</p>
    </c:if>
</body>
</html>
