<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Login</title>
</head>
<body>
    <h1>Employee Login</h1>
    <form action="LoginEmployee" method="post">
        <label for="employeeId">Employee ID:</label>
        <input type="text" id="employeeId" name="employeeId" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <button type="submit">Login</button>
    </form>
</body>
</html>
