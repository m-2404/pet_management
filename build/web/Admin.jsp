<%@ page language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            text-align: center;
        }
        .container {
            margin: 20px;
        }
        .info {
            background-color: #ffffff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        .nav-links {
            display: flex;
            justify-content: space-around;
            margin-bottom: 20px;
        }
        .nav-links a {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 20px;
            border-radius: 5px;
        }
        .nav-links a:hover {
            background-color: #45a049;
        }
        .logout {
            text-align: center;
            margin-top: 20px;
        }
        .logout a {
            text-decoration: none;
            color: white;
            background-color: #f44336;
            padding: 10px 20px;
            border-radius: 5px;
        }
        .logout a:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Admin Dashboard</h1>
        <p>Welcome, <%= session.getAttribute("firstName") %> <%= session.getAttribute("lastName") %>!</p>
    </div>

    <div class="container">
        <div class="info">
            <p><strong>Admin ID:</strong> <%= session.getAttribute("adminId") %></p>
            <p><strong>Role:</strong> <%= session.getAttribute("roleDescription") %></p>
        </div>

        <div class="nav-links">
            <a href="manageEmployees.jsp">Manage Employees</a>
            <a href="managePets.jsp">Manage Pets</a>
            <a href="manageProducts.jsp">Manage Products</a>
        </div>

        <div class="logout">
            <a href="logout.jsp">Logout</a>
        </div>
    </div>
</body>
</html>
