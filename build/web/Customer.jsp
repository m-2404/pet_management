<%@ page import="model.Customer" %>

<%
    
    String firstName = (String) session.getAttribute("firstName");
    String username = (String) session.getAttribute("lastName");
    String phone = (String) session.getAttribute("phone");
    String address = (String) session.getAttribute("address");

    
   /* if (firstName == null || username == null || phone == null || address == null) {
        response.sendRedirect("loginCustomer.html");
        return;
    }*/
%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 15px;
        }
        .nav-bar {
            text-align: center;
            margin: 20px;
        }
        .nav-bar a {
            margin: 5px;
            padding: 10px 15px;
            color: white;
            background-color: #4CAF50;
            text-decoration: none;
            border-radius: 5px;
        }
        .profile {
            max-width: 500px;
            margin: 20px auto;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .profile h2 {
            color: #4CAF50;
        }
    </style>
</head>
<body>

    <div class="header">
        <h1>Welcome, <%= firstName %> !</h1>
    </div>

    <div class="nav-bar">
        <a href="PetCategories.jsp">Pet Categories</a>
        <a href="petCare.jsp">Pet Care</a>
        <a href="petProducts.jsp">Pet Products</a>
        <a href="trackOrder.jsp">Track Orders</a>
        <a href="logout.jsp">Logout</a>
        <a href="cart.jsp">View Cart</a> <!-- Link to the cart page -->
    </div>

    <<div class="profile">
        <h2>Your Profile</h2>
        <p><strong>Username:</strong> <%= username %></p>
        <p><strong>Phone Number:</strong> <%= phone %></p>
        <p><strong>Address:</strong> <%= address %></p>
    </div>

</body>
</html>
