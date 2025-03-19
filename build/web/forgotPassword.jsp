<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
</head>
<body>
    <h2>Forgot Password</h2>

    <form action="ForgotPasswordServlet" method="post">
        <!-- Display the email field -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <!-- Display error message if exists -->
        <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) {
        %>
            <p style="color:red;">Error: <%= errorMessage %></p>
        <% 
            }
        %>

        <input type="submit" value="Submit">
    </form>

    <hr>

    <% 
        // Check if a security question exists after email submission
        String securityQuestion = (String) request.getAttribute("securityQuestion");
        String email = (String) request.getAttribute("email");

        if (securityQuestion != null) {
    %>
        <!-- Show the security question input field -->
        <h3>Security Question:</h3>
        <form action="ForgotPasswordServlet" method="post">
            <label for="securityAnswer"><%= securityQuestion %></label><br>
            <input type="text" id="securityAnswer" name="securityAnswer" required><br><br>

            <input type="hidden" name="email" value="<%= email %>"> <!-- Keep email in hidden field -->
            <input type="submit" value="Submit Answer">
        </form>
    <% 
        }
    %>
</body>
</html>
