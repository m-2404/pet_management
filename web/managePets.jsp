<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Pets</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            text-align: center;
        }
        .container {
            margin: 20px;
        }
        .pet-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        .pet-table th, .pet-table td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        .pet-table th {
            background-color: #4CAF50;
            color: white;
            text-align: left;
        }
        .form-container {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
        }
        .form {
            background-color: #ffffff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-bottom: 20px;
            width: 48%;
        }
        .form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form input, .form select, .form button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        .form button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form button:hover {
            background-color: #45a049;
        }
        .back-link {
            text-align: center;
            margin-top: 20px;
        }
        .back-link a {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 20px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Manage Pets</h1>
    </div>

    <div class="container">
        <!-- Cats Table -->
        <h2>Cat List</h2>
        <table class="pet-table">
            <thead>
                <tr>
                    <th>Cat ID</th>
                    <th>Breed</th>
                    <th>Age</th>
                    <th>Price</th>
                     <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Connection conn = null;
                    PreparedStatement stmt = null;
                    ResultSet rs = null;
                    try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                        String query = "SELECT * FROM Cat";
                        stmt = conn.prepareStatement(query);
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("CAT_ID") %></td>
                   <td><%= rs.getString("BREED") %></td>
                    <td><%= rs.getString("AGE") %></td>
                    <td><%= rs.getDouble("PRICE") %></td>
                    <td><%= rs.getDouble("QUANTITY") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='5'>Error loading cats: " + e.getMessage() + "</td></tr>");
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                %>
            </tbody>
        </table>

        <!-- Dogs Table -->
        <h2>Dog List</h2>
        <table class="pet-table">
            <thead>
                <tr>
                    <th>Dog ID</th>
                    <th>Breed</th>
                    <th>Age</th>
                    <th>Price</th>
                     <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <%
                    try {
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");
                        String query = "SELECT * FROM Dog";
                        stmt = conn.prepareStatement(query);
                        rs = stmt.executeQuery();
                        while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("DOG_ID") %></td>
                    <td><%= rs.getString("BREED") %></td>
                    <td><%= rs.getString("AGE") %></td>
                    <td><%= rs.getDouble("PRICE") %></td>
                    <td><%= rs.getDouble("QUANTITY") %></td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        out.println("<tr><td colspan='5'>Error loading dogs: " + e.getMessage() + "</td></tr>");
                    } finally {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    }
                %>
            </tbody>
        </table>

        <div class="form-container">
            <!-- Add Pet Form -->
            <div class="form">
                <h3>Add Pet</h3>
                <form action="AddPet" method="post">
                    <label for="petType">Pet Type</label>
                    <select id="petType" name="petType" required>
                        <option value="Cat">Cat</option>
                        <option value="Dog">Dog</option>
                    </select>

                    

                    <label for="breed">Breed</label>
                    <input type="text" id="breed" name="breed" required>

                    <label for="age">Age</label>
                    <input type="number" id="age" name="age" required>

                    <label for="price">Price</label>
                    <input type="number" id="price" name="price" step="0.01" required>
                    
                    
                    <label for="quantity">Quantity</label>
                    <input type="number" id="quantity" name="quantity" required>
                    <button type="submit">Add Pet</button>
                </form>
            </div>

            <!-- Delete Pet Form -->
            <div class="form">
                <h3>Delete Pet</h3>
                <form action="DeletePet" method="post">
                    <label for="petType">Pet Type</label>
                    <select id="petType" name="petType" required>
                        <option value="Cat">Cat</option>
                        <option value="Dog">Dog</option>
                    </select>

                    <label for="petId">Pet ID</label>
                    <input type="number" id="petId" name="petId" required>

                    <button type="submit">Delete Pet</button>
                </form>
            </div>
        </div>

        <div class="back-link">
            <a href="Admin.jsp">Back to Admin Dashboard</a>
        </div>
    </div>
</body>
</html>
