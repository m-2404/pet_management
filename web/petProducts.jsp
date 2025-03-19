<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pet Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        .header {
            text-align: center;
            margin-bottom: 30px;
        }
        .header h1 {
            margin: 0;
            color: #4CAF50;
        }
        .nav-links {
            text-align: center;
            margin-bottom: 20px;
        }
        .nav-links a {
            margin: 0 10px;
            padding: 10px 20px;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            border-radius: 5px;
            font-size: 16px;
        }
        .nav-links a:hover {
            background-color: #45a049;
        }
        .product-grid {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
        }
        .product-card {
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 8px;
            width: 250px;
            padding: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.2s;
        }
        .product-card:hover {
            transform: scale(1.05);
        }
        .product-card img {
            max-width: 100%;
            height: 150px;
            object-fit: cover;
            border-radius: 8px;
        }
        .product-card h3 {
            margin: 10px 0;
            color: #333;
            font-size: 18px;
        }
        .product-card p {
            margin: 5px 0;
            font-size: 16px;
            color: #666;
        }
        .product-card a, .product-card button {
            display: inline-block;
            margin: 5px 0;
            padding: 10px 15px;
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
        }
        .product-card a:hover, .product-card button:hover {
            background-color: #45a049;
        }
        .food-button {
            display: block;
            width: 250px;
            margin: 30px auto;
            padding: 15px;
            background-color: #ff9800;
            color: white;
            text-align: center;
            font-size: 18px;
            border-radius: 5px;
            cursor: pointer;
        }
        .food-button:hover {
            background-color: #e68900;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Pet Products</h1>
        </div>
        <div class="nav-links">
            <a href="Customer.jsp">Return to Customer Page</a>
            <a href="PetCategories.jsp">Return to Pet Categories</a>
        </div>
        <div class="product-grid">
            <%
                // Database connection details
                String url = "jdbc:oracle:thin:@localhost:1521:xe";
                String username = "system";
                String password = "password";

                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    // Load Oracle JDBC Driver
                    Class.forName("oracle.jdbc.driver.OracleDriver");

                    // Establish connection
                    conn = DriverManager.getConnection(url, username, password);

                    // Query to retrieve products
                    String query = "SELECT * FROM Products";
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(query);

                    // Iterate through the result set
                    while (rs.next()) {
                        int productId = rs.getInt("PRODUCT_ID");
                        String productName = rs.getString("PRODUCT_NAME");
                        double price = rs.getDouble("PRICE");
                        String imageLink = rs.getString("IMAGE_LINK");
                        String productLink = rs.getString("PRODUCT_LINK");
            %>
            <div class="product-card">
                <img src="<%= imageLink %>" alt="<%= productName %>">
                <h3><%= productName %></h3>
                <p>Price: ₹<%= price %></p>
                <a href="<%= productLink %>" target="_blank">View Details</a>
                <br>
                <!-- Add to Cart -->
                <a href="addToCart.jsp?name=<%= productName %>&price=<%= price %>&type=product"<input type="hidden" name="type" value="petProduct" />>Add to Cart</a>
                <!-- Buy Now -->
                <a href="buynow.jsp?name=<%= productName %>&price=<%= price %>&type=product"<input type="hidden" name="type" value="petProduct" />>Buy Now</a>
            </div>
            <%
                    }
                } catch (Exception e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                } finally {
                    // Close resources
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                }
            %>
        </div>

        <!-- Button for Food Products Page -->
        <a href="food.jsp" class="food-button">View Food Products</a>
    </div>
</body>
</html>
