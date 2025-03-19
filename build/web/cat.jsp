<%@ page import="java.sql.*, java.util.*, model.Cat" %>
<%
    // List to store Cat objects
    List<Cat> cats = new ArrayList<>();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Database connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Change connection string as needed
        String user = "system";
        String password = "password";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        // Query to retrieve cat data
        String query = "SELECT * FROM Cat";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        // Populate the list of Cat objects
        while (rs.next()) {
            String breed = rs.getString("breed");
            String age = rs.getString("age");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");

            // Create a Cat object and add it to the list
            Cat cat = new Cat(breed, age, price, quantity);
            cats.add(cat);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
%>

<html>
<head>
    <title>Cat Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        h1 {
            text-align: center;
        }
        .product-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
        .product {
            border: 1px solid #ddd;
            margin: 10px;
            padding: 10px;
            width: 250px;
            text-align: center;
        }
        .product img {
            width: 200px;
            height: 200px;
            object-fit: cover;
        }
        .product h3 {
            font-size: 18px;
            margin-bottom: 10px;
        }
        .product p {
            margin: 5px 0;
        }
        .action-buttons {
            margin-top: 10px;
        }
        .action-buttons a, .action-buttons button {
            margin: 5px;
            padding: 10px 15px;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .action-buttons a:hover, .action-buttons button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Cat Breeds</h1>

    <div class="product-container">
        <% 
            // Iterate through the list of cats and display each cat's details
            for (Cat cat : cats) {
        %>
        <div class="product">
            <!-- Display breed, age, price, and image -->
            <img src="<%= getCatImage(cat.getBreed()) %>" alt="<%= cat.getBreed() %>">
            <h3><%= cat.getBreed() %></h3>
            <p>Age: <%= cat.getAge() %></p>
            <p>Price: ?<%= cat.getPrice() %></p>
            <p>Available: <%= cat.getQuantity() %> left</p>

            <!-- Add to Cart and Buy Now buttons -->
            <div class="action-buttons">
                <!-- Add to Cart -->
                <form method="post" action="addToCart.jsp">
                    <input type="hidden" name="catBreed" value="<%= cat.getBreed() %>">
                    <input type="hidden" name="catPrice" value="<%= cat.getPrice() %>">
                    <input type="hidden" name="catQuantity" value="<%= cat.getQuantity() %>">
                    <input type="hidden" name="type" value="cat" />
                    <button type="submit">Add to Cart</button>
                </form>

                <!-- Buy Now -->
                <a href="buynow.jsp?breed=<%= cat.getBreed() %>&price=<%= cat.getPrice() %>&quantity=<%= cat.getQuantity() %>" <input type="hidden" name="type" value="cat" />>
                    <button>Buy Now</button>
                </a>
            </div>
        </div>
        <% } %>
    </div>
    <a href="PetCategories.jsp">Pet Categories</a>
</body>
</html>

<%!
    // Helper method to return image URL based on the breed
    public String getCatImage(String breed) {
        String imageUrl = "";
        switch (breed.toLowerCase()) {
            case "persian cat":
                imageUrl = "images/persian.jpg";
                break;
            case "siamese cat":
                imageUrl = "images/siamese.jpg";
                break;
             case "persian blue cat":
                    imageUrl="images/persian blue.jpg";
                   break;
              case "bengal cat":
                    imageUrl="images/bengal.jpg";
                   break;
              case "maine coon cat":
                    imageUrl="images/maine coon.jpg";
                   break;
              case "ragdoll cat":
                    imageUrl="images/ragdoll.jpg";
                   break;
            default:
                imageUrl = "https://example.com/images/default_cat.jpg";
        }
        return imageUrl;
    }
%>
