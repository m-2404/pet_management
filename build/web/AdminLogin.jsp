<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
</head>
<body>
    <div style="width: 300px; margin: 50px auto; padding: 20px; background-color: white; box-shadow: 0 0 10px rgba(0,0,0,0.1);">
        <h2 style="text-align: center; color: #4CAF50;">Admin Login</h2>

        <!-- Show error message if provided -->
        <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
        <% if (errorMessage != null) { %>
            <p style="color: red; text-align: center;"><%= errorMessage %></p>
        <% } %>

        <form action="AdminLoginServlet" method="post">
            <label for="adminId">Admin ID:</label>
            <input type="number" id="adminId" name="adminId" required style="width: 100%; padding: 10px; margin-top: 10px;">

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required style="width: 100%; padding: 10px; margin-top: 10px;"><br><br>
            
            <button type="submit" style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer;">Login</button>
        </form>

        <div style="text-align: center; margin-top: 10px;">
            <a href="AdminSignUp.jsp" style="color: #4CAF50; text-decoration: none;">Create Admin Account</a>
        </div>
    </div>
</body>
</html>
