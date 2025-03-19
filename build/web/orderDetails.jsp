<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Details</title>
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
        .order-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .order-table th, .order-table td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .order-table th {
            background-color: #4CAF50;
            color: white;
            text-align: left;
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
        <h1>Order Details</h1>
    </div>

    <div class="container">
        <!-- Orders Table -->
        <h2>Orders List</h2>
        <table class="order-table">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Customer ID</th>
                    <th>Product ID</th>
                    <th>Quantity</th>
                    <th>Order Date</th>
                    <th>Delivery Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Connection conn = null;
                    PreparedStatement stmt = null;
                    ResultSet rs = null;
                    try {
                        // Connect to the database
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

                        // Query to fetch order details including order date and delivery date
                        String query = "SELECT ORDER_ID, CUSTOMER_ID, PRODUCT_ID, QUANTITY, ORDER_DATE, DELIVERY_DATE FROM ORDERS";
                        stmt = conn.prepareStatement(query);
                        rs = stmt.executeQuery();

                        // Iterate over the result set and display order details
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("ORDER_ID") %></td>
                    <td><%= rs.getInt("CUSTOMER_ID") %></td>
                    <td><%= rs.getInt("PRODUCT_ID") %></td>
                    <td><%= rs.getInt("QUANTITY") %></td>
                    <td><%= rs.getDate("ORDER_DATE") %></td>
                    <td><%= rs.getDate("DELIVERY_DATE") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='6'>Error loading orders: " + e.getMessage() + "</td></tr>");
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                %>
            </tbody>
        </table>

        <div class="back-link">
            <a href="Employee.jsp">Back to Employee Dashboard</a>
        </div>
    </div>
</body>
</html>
