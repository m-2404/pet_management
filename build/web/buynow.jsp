<%@ page import="java.util.*" %>
<%
    // Retrieve the cart from the session
    List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
    if (cart == null || cart.isEmpty()) {
        response.sendRedirect("cart.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
</head>
<body>
    <h1>Checkout</h1>
    <form action="payment.jsp" method="post">
        <label for="address">Delivery Address:</label><br>
        <input type="text" name="address" required/><br>
        <label for="phone">Phone Number:</label><br>
        <input type="text" name="phone" required/><br><br>

        <button type="submit">Proceed to Payment</button>
    </form>
</body>
</html>
