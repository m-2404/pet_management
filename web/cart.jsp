<%@ page import="java.util.*" %>

<%
    // Retrieve the cart from the session
    List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");

    // Ensure cart is not null, and initialize if it is
    if (cart == null) {
        cart = new ArrayList<>();
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Cart</title>
</head>
<body>
    <h1>Your Cart</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Breed (If applicable)</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Remove</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Check if cart is not empty before iterating
                if (cart != null && !cart.isEmpty()) {
                    // Iterate through the cart items
                    for (Map<String, Object> item : cart) {
                        String productName = (String) item.get("productName");
                        String breed = (String) item.get("breed");
                        Integer quantity = (Integer) item.get("quantity");
                        Double price = (Double) item.get("price");
                        //String productId = (String) item.get("productId");

                        // In case price or quantity is null, set default values
                        if (price == null) {
                            price = 0.0;
                        }
                        if (quantity == null) {
                            quantity = 0;
                        }
            %>
            <tr>
                <td><%= productName != null ? productName : "N/A" %></td>
                <td><%= breed != null ? breed : "N/A" %></td>
                <td><%= quantity %></td>
                <td><%= price %></td>
                <td><a href="removeFromCart.jsp?productId=<%= productId %>">Remove</a></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="5">Your cart is empty.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <br>
    <a href="buynow.jsp">Proceed to Checkout</a>
    <br>
    <a href="Customer.jsp">Home</a>
</body>
</html>
