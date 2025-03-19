<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #4CAF50;
            font-size: 1.5em;
            margin-bottom: 20px;
        }
        h3 {
            text-align: center;
            font-size: 1.1em;
            margin-top: 20px;
        }
        a {
            display: block;
            text-align: center;
            margin: 10px 0;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Sign Up</h1>
        <h3>
            <a href="CustomerSignup.jsp">Sign Up as Customer</a>
            <a href="SignUpEmployee.jsp">Sign Up as Employee</a>
            <a href="AdminSignup.jsp">Sign Up as Admin</a>
            <a href="Welcome.jsp">Back</a>
        </h3>
    </div>
</body>
</html>
