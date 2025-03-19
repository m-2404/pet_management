<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Customers</title>
    <style>
        /* Styles for the page */
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
        .customer-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .customer-table th, .customer-table td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .customer-table th {
            background-color: #4CAF50;
            color: white;
            text-align: left;
        }
        .form-container {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
        }
        .form {
            background-color: #ffffff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-bottom: 20px;
            width: 48%;
        }
        .form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form input, .form button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        .form button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form button:hover {
            background-color: #45a049;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        .back-link a {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 20px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Manage Customers</h1>
    </div>

    <div class="container">
        <!-- Customers Table -->
        <h2>Customer List</h2>
        <table class="customer-table">
            <thead>
                <tr>
                    <th>Customer ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Connection conn = null;
                    PreparedStatement stmt = null;
                    ResultSet rs = null;
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                        String query = "SELECT * FROM Customer";  // Assuming table is named "Customers"
                        stmt = conn.prepareStatement(query);
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("CUSTOMER_ID") %></td>
                    <td><%= rs.getString("FIRST_NAME") %></td>
                    <td><%= rs.getString("LAST_NAME") %></td>
                    <td><%= rs.getString("EMAIL_ID") %></td>
                    <td><%= rs.getString("PHONE_NO") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='5'>Error loading customers: " + e.getMessage() + "</td></tr>");
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                %>
            </tbody>
        </table>

        <div class="form-container">
            <!-- Add Customer Form -->
            <div class="form">
                <h3>Add Customer</h3>
                <form action="AddCustomer" method="post">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" required>

                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" required>

                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>

                    <label for="phone">Phone</label>
                    <input type="text" id="phone" name="phone" required>

                    <button type="submit">Add Customer</button>
                </form>
            </div>

            <!-- Delete Customer Form -->
            <div class="form">
                <h3>Delete Customer</h3>
                <form action="DeleteCustomer" method="post">
                    <label for="customerId">Customer ID</label>
                    <input type="number" id="customerId" name="customerId" required>

                    <button type="submit">Delete Customer</button>
                </form>
            </div>
        </div>

        <div class="back-link">
            <a href="Employee.jsp">Back to Employee Dashboard</a>
        </div>
    </div>
</body>
</html>
