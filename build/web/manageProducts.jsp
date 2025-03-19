<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Products</title>
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
        .product-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .product-table th, .product-table td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .product-table th {
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
        <h1>Manage Products</h1>
    </div>

    <div class="container">
        <!-- Products Table -->
        <h2>Product List</h2>
        <table class="product-table">
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Quantity</th>
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
                        String query = "SELECT * FROM Products";  // Assuming table is named "Products"
                        stmt = conn.prepareStatement(query);
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("PRODUCT_ID") %></td>
                    <td><%= rs.getString("PRODUCT_NAME") %></td>
                    <td><%= rs.getDouble("PRICE") %></td>
                    <td><%= rs.getString("IMAGE_LINK") %></td>
                    <td><%= rs.getString("PRODUCT_LINK") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='5'>Error loading products: " + e.getMessage() + "</td></tr>");
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                %>
            </tbody>
        </table>

        <div class="form-container">
            <!-- Add Product Form -->
            <div class="form">
                <h3>Add Product</h3>
                <form action="AddProduct" method="post">
                    <label for="name">Product Name</label>
                    <input type="text" id="name" name="name" required>

                    <label for="price">Price</label>
                    <input type="number" id="price" name="price" step="0.01" required>

                    <label for="image">Image_link</label>
                    <input type="text" id="image" name="image" required>
                    
                    <label for="product">Product_Link</label>
                    <input type="text" id="product" name="product" required>
                    

                    <button type="submit">Add Product</button>
                </form>
            </div>

            <!-- Delete Product Form -->
            <div class="form">
                <h3>Delete Product</h3>
                <form action="DeleteProduct" method="post">
                    <label for="productId">Product ID</label>
                    <input type="number" id="productId" name="productId" required>

                    <button type="submit">Delete Product</button>
                </form>
            </div>
        </div>

        <div class="back-link">
            <a href="Admin.jsp">Back to Admin Dashboard</a>
        </div>
    </div>
</body>
</html>
