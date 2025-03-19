<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Sign Up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }
        .container h2 {
            text-align: center;
            color: #4CAF50;
        }
        .container form label {
            display: block;
            margin: 10px 0 5px;
        }
        .container form input, .container form select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .container form button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Admin Sign Up</h2>
    <form action="AdminSignUpServlet" method="post">
        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required>

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender">
            <option value="M">Male</option>
            <option value="F">Female</option>
            <option value="O">Other</option>
        </select>

        <label for="phoneNo">Phone Number:</label>
        <input type="text" id="phoneNo" name="phoneNo">

        <label for="emailId">Email ID:</label>
        <input type="email" id="emailId" name="emailId">

        <label for="roleDescription">Role Description:</label>
        <input type="text" id="roleDescription" name="roleDescription">

        <label for="permissions">Permissions:</label>
        <input type="text" id="permissions" name="permissions">

        <button type="submit">Sign Up</button>
    </form>
</div>

</body>
</html>
