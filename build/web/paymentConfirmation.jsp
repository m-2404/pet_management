<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    String orderId = request.getParameter("orderId");
    String deliveryDate = request.getParameter("deliveryDate");

    // Fetch order details from the database
    List<Map<String, Object>> products = new ArrayList<>();
    try {
        // Database connection
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

        // Fetch order details
        String orderQuery = "SELECT * FROM Orders WHERE ORDER_ID = ?";
        PreparedStatement stmt = conn.prepareStatement(orderQuery);
        stmt.setString(1, orderId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Order details fetched, can be displayed if needed
        }

        // Fetch products for this order
        String productQuery = "SELECT * FROM ORDER_PRODUCTS WHERE ORDER_ID = ?";
        stmt = conn.prepareStatement(productQuery);
        stmt.setString(1, orderId);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Map<String, Object> product = new HashMap<>();
            product.put("productName", rs.getString("PRODUCT_NAME"));
            product.put("breed", rs.getString("BREED"));
            product.put("quantity", rs.getInt("QUANTITY"));
            product.put("price", rs.getDouble("PRICE"));
            products.add(product);
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
</head>
<body>
    <h1><center>Thank You for Your Order!</center></h1>
    <p>Your Order ID: <%= orderId %></p>
    <p>Delivery Date: <%= deliveryDate %></p>

    <h2>Order Details:</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Breed</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Map<String, Object> item : products) {
            %>
                <tr>
                    <td><%= item.get("productName") %></td>
                    <td><%= item.get("breed") %></td>
                    <td><%= item.get("quantity") %></td>
                    <td><%= item.get("price") %></td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <p>Thank you for shopping with us!</p>
    <a href="home.jsp">Go to Home</a>
</body>
</html>
