<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Map<String, Object>> cart = (List<Map<String, Object>>) session.getAttribute("cart");
    
    // Initialize cart if it's null
    if (cart == null) {
        cart = new ArrayList<>();
    }

    // Retrieve item parameters from the request
    String itemName = request.getParameter("name");
    String itemPrice = request.getParameter("price");
    String itemType = request.getParameter("type");
    //String itemBreed = request.getParameter("breed");

    // Ensure that item name and price are not null
    if (itemName != null && itemPrice != null) {
        Map<String, Object> cartItem = new HashMap<>();
        cartItem.put("productName", itemName);
        cartItem.put("price", Double.parseDouble(itemPrice));
     
        cartItem.put("quantity", 1);  // Default quantity
       // cartItem.put("productId", UUID.randomUUID().toString()); // Generate a unique ID
  
        
        cart.add(cartItem);
        session.setAttribute("cart", cart);
        
    }
%>

<html>
<head>
    <title>Item Added to Cart</title>
</head>
<body>
    <h1>Item Added to Cart</h1>
    <p><%= itemName %> has been added to your cart!</p>
    <a href="cart.jsp">Go to Cart</a>
    <br>
    <a href="PetCategories.jsp">Back to Pet Categories</a>
</body>
</html>
