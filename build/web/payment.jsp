<%@ page import="java.util.*, java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    // Retrieve the cart and customer information from session
    List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
    String address = request.getParameter("address");
    String phone = request.getParameter("phone");
    String email = request.getParameter("email");

    // Generate the order ID and calculate the delivery date
    String orderId = "ORD" + System.currentTimeMillis();  // Generate unique order ID
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, 5);  // Delivery date 5 days from now
    String deliveryDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
    int customerId = -1;
    // Save order details to the database if valid
    if (cart != null && !cart.isEmpty() && address != null && phone != null && email != null) {
        try {
            // Database connection
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
            String customerQuery = "SELECT CUSTOMER_ID FROM Customer WHERE EMAIL = ?";
            PreparedStatement customerStmt = conn.prepareStatement(customerQuery);
            customerStmt.setString(1, email);
            ResultSet customerRs = customerStmt.executeQuery();
            if (customerRs.next()) {
                customerId = customerRs.getInt("CUSTOMER_ID");
            } else {
                out.println("<h3>Customer not found. Please check your email address.</h3>");
                return;
            }
            // Insert order into Orders table
            String orderQuery = "INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, ADDRESS, PHONE, EMAIL, ORDER_DATE, DELIVERY_DATE) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(orderQuery);
            stmt.setString(1, orderId);
            stmt.setInt(2, Integer.parseInt(request.getParameter("customerId")));  // Assuming customer ID is passed in the form
            stmt.setString(3, address);
            stmt.setString(4, phone);
            stmt.setString(5, email);
            stmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));  // Current date as order date
            stmt.setString(7, deliveryDate);
            stmt.executeUpdate();

            // Insert each product in the cart into ORDER_PRODUCTS table
            String productQuery = "INSERT INTO ORDER_PRODUCTS (ORDER_ID, PRODUCT_ID, PRODUCT_NAME, QUANTITY, PRICE) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(productQuery);
            for (Map<String, Object> item : cart) {
                stmt.setString(1, orderId);
                stmt.setInt(2, (Integer) item.get("productId"));
                stmt.setString(3, (String) item.get("productName"));
                stmt.setInt(4, (Integer) item.get("quantity"));
                stmt.setDouble(5, (Double) item.get("price"));
                stmt.addBatch();
            }
            stmt.executeBatch();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment</title>
</head>
<body>
    <h1>Payment Information</h1>
    <form action="paymentConfirmation.jsp" method="post">
        <label for="cardNumber">Card Number:</label><br>
        <input type="text" name="cardNumber" required /><br>

        <label for="cvv">CVV:</label><br>
        <input type="text" name="cvv" required /><br>

        <label for="expiryDate">Expiry Date (MM/YY):</label><br>
        <input type="text" name="expiryDate" required /><br>

        <label for="emailId">Email ID:</label><br>
        <input type="email" name="emailId" value="<%= email %>" required /><br><br>

        <input type="hidden" name="orderId" value="<%= orderId %>" />
        <input type="hidden" name="deliveryDate" value="<%= deliveryDate %>" />

        <button type="submit">Confirm Payment</button>
    </form>
</body>
</html>
