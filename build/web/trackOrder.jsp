<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*" %>
<%
    // Retrieve orderId from session
    String orderId = (String) session.getAttribute("orderId");

    if (orderId == null) {
        out.println("<h2>You must be logged in to track your order.</h2>");
        out.println("<p><a href='loginCustomer.html'>Login</a></p>");
        return;
    }

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

        // Query to fetch the order details from the Orders table using orderId
        String query = "SELECT * FROM Orders WHERE orderId = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, orderId);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            String customerName = rs.getString("customerName");
            String phone = rs.getString("phone");
            String address = rs.getString("address");
            String email = rs.getString("email");
            double totalAmount = rs.getDouble("totalAmount");
            String productDetails = rs.getString("productDetails");
            java.sql.Date orderDate = rs.getDate("orderDate");
            java.sql.Date deliveryDate = rs.getDate("deliveryDate");

            out.println("<h2>Order Details</h2>");
            out.println("<p><strong>Order ID:</strong> " + orderId + "</p>");
            out.println("<p><strong>Customer Name:</strong> " + customerName + "</p>");
            out.println("<p><strong>Phone:</strong> " + phone + "</p>");
            out.println("<p><strong>Address:</strong> " + address + "</p>");
            out.println("<p><strong>Email:</strong> " + email + "</p>");
            out.println("<p><strong>Total Amount:</strong> " + totalAmount + "</p>");
            out.println("<p><strong>Product Details:</strong> " + productDetails + "</p>");
            out.println("<p><strong>Order Date:</strong> " + orderDate + "</p>");
            out.println("<p><strong>Estimated Delivery Date:</strong> " + deliveryDate + "</p>");
        } else {
            out.println("<h2>Order not found</h2>");
            out.println("<p>The order ID you entered does not exist.</p>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h2>Something went wrong!</h2>");
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
