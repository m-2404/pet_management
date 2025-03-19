<%@ page import="java.sql.*, java.util.*, model.Dog" %>

<%
    // List to store Dog objects
    List<Dog> dogs = new ArrayList<>();
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Database connection details
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "system";
        String password = "password";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, user, password);

        // Query to retrieve dog data
        String query = "SELECT * FROM Dog";
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        // Check if data is retrieved
        System.out.println("Query executed successfully.");

        // Populate the list of Dog objects
        while (rs.next()) {
            String breed = rs.getString("breed");
            String age = rs.getString("age");
            int price = rs.getInt("price");
            int quantity = rs.getInt("quantity");

            System.out.println("Dog: " + breed + " " + age + " " + price + " " + quantity); // Debugging print

            // Create a Dog object and add it to the list
            Dog dog = new Dog(breed, age, price, quantity);
            dogs.add(dog);
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

    // Debugging: Print size of dogs list
    System.out.println("Total dogs: " + dogs.size());
%>

<html>
<head>
    <title>Dog Products</title>
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
    <h1>Dog Breeds</h1>

    <div class="product-container">
        <% 
            // Check if the list of dogs is empty
            if (dogs.isEmpty()) {
                out.println("<p>No dogs available at the moment.</p>");
            } else {
                // Iterate through the list of dogs and display each dog's details
                for (Dog dog : dogs) {
        %>
        <div class="product">
            <img src="<%= getDogImage(dog.getBreed()) %>" alt="<%= dog.getBreed() %>">
            <h3><%= dog.getBreed() %></h3>
            <p>Age: <%= dog.getAge() %></p>
            <p>Price: ?<%= dog.getPrice() %></p>
            <p>Available: <%= dog.getQuantity() %> left</p>

            <!-- Add to Cart and Buy Now buttons -->
            <div class="action-buttons">
                <!-- Add to Cart -->
                <form method="post" action="addToCart.jsp">
                    <input type="hidden" name="dogBreed" value="<%= dog.getBreed() %>">
                    <input type="hidden" name="dogPrice" value="<%= dog.getPrice() %>">
                    <input type="hidden" name="dogQuantity" value="<%= dog.getQuantity() %>">
                    <input type="hidden" name="type" value="dog" />
                    <button type="submit">Add to Cart</button>
                </form>

                <!-- Buy Now -->
                <a href="buynow.jsp?breed=<%= dog.getBreed() %>&price=<%= dog.getPrice() %>&quantity=<%= dog.getQuantity() %>">
                    <button>Buy Now</button>
                </a>
            </div>
        </div>
        <% 
                } 
            }
        %>
    </div>
    <a href="PetCategories.jsp">Pet Categories</a>
</body>
</html>

<%!
    // Helper method to return image URL based on the breed
    public String getDogImage(String breed) {
        String imageUrl = "";
        switch (breed.toLowerCase()) {
            case "bulldog":
                imageUrl = "images/bulldog.jpg";
                break;
            case "labrador":
                imageUrl = "images/labrador.jpg";
                break;
            case "poodle":
                imageUrl = "images/poodle.jpg";
                break;
            case "german shepherd":
                imageUrl = "images/gs.jpg";
                break;
            case "beagle":
                imageUrl = "images/beagle.jpg";
                break;
            case "husky":
                imageUrl = "images/husky.jpg";
                break;
            default:
                imageUrl = "https://example.com/images/default_dog.jpg";
        }
        return imageUrl;
    }
%>
