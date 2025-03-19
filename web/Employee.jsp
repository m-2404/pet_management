<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            text-align: center;
        }

        .employee-info {
            background-color: #e0f7fa;
            padding: 15px;
            border-radius: 5px;
            margin-bottom: 20px;
            font-size: 18px;
        }

        .employee-info b {
            color: #00796b;
        }

        .button-container {
            text-align: center;
        }

        .button-container form {
            margin: 10px 0;
        }

        .button-container button {
            background-color: #00796b;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .button-container button:hover {
            background-color: #004d40;
        }

        footer {
            text-align: center;
            font-size: 14px;
            color: #777;
            margin-top: 30px;
        }

    </style>
</head>
<body>

    <div class="container">
        <h1>Welcome to the Employee Dashboard</h1>

        <%
            // Check if session exists and if "name" is present
            if (session == null || session.getAttribute("name") == null) {
                response.sendRedirect("SignUpEmployee.jsp"); 
                return;
            }

            // Retrieve the employee name and position from the session
            String name = (String) session.getAttribute("name");
            String position = (String) session.getAttribute("position");
        %>

        <!-- Employee Information -->
        <div class="employee-info">
            <p>Welcome, <b><%= name %></b>!</p>
            <p>Your Position: <b><%= position %></b></p>
        </div>

        <!-- Navigation Buttons -->
        <div class="button-container">
            <!-- Button to Manage Customers -->
            <form action="manageCustomer.jsp" method="get">
                <button type="submit">Manage Customers</button>
            </form>

            <!-- Button to View Order Details -->
            <form action="orderDetails.jsp" method="get">
                <button type="submit">Order Details</button>
            </form>
        </div>
    </div>

    <footer>
        <p>&copy; 2024 Employee Management System</p>
    </footer>

</body>
</html>
