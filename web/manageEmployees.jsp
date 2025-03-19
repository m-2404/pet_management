<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Employees</title>
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
        .employee-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .employee-table th, .employee-table td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .employee-table th {
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
        <h1>Manage Employees</h1>
    </div>

    <div class="container">
        <!-- Employee Table -->
        <h2>Employees List</h2>
        <table class="employee-table">
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Position</th>
                    <th>Salary</th>
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
                        String query = "SELECT * FROM Employees";
                        stmt = conn.prepareStatement(query);
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("EMPLOYEE_ID") %></td>
                    <td><%= rs.getString("FIRST_NAME") %></td>
                    <td><%= rs.getString("LAST_NAME") %></td>
                    <td><%= rs.getString("USERNAME") %></td>
                    <td><%= rs.getString("PHONE_NO") %></td>
                    <td><%= rs.getString("EMAIL_ID") %></td>
                    <td><%= rs.getString("POSITION") %></td>
                    <td><%= rs.getDouble("SALARY") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='8'>Error loading employees: " + e.getMessage() + "</td></tr>");
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                %>
            </tbody>
        </table>

        <div class="form-container">
            <!-- Add Employee Form -->
            <div class="form">
                <h3>Add Employee</h3>
                <form action="AddEmployee" method="post">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" required>

                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" required>

                    <label for="username">Username</label>
                    <input type="text" id="username" name="username" required>

                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>

                    <label for="phone">Phone</label>
                    <input type="text" id="phone" name="phone">

                    <label for="email">Email</label>
                    <input type="email" id="email" name="email">

                    <label for="position">Position</label>
                    <input type="text" id="position" name="position">

                    <label for="salary">Salary</label>
                    <input type="number" id="salary" name="salary" step="0.01">

                    <button type="submit">Add Employee</button>
                </form>
            </div>

            <!-- Delete Employee Form -->
            <div class="form">
                <h3>Delete Employee</h3>
                <form action="DeleteEmployee" method="post">
                    <label for="employeeId">Employee ID</label>
                    <input type="number" id="employeeId" name="employeeId" required>

                    <button type="submit">Delete Employee</button>
                </form>
            </div>
        </div>

        <div class="back-link">
            <a href="Admin.jsp">Back to Admin Dashboard</a>
        </div>
    </div>
</body>
</html>
