<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Signup</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 50px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Customer Signup</h2>
        <form action="CustomerSignupServlet" method="post">
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="FIRST_NAME" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="LAST_NAME" required>
            </div>
            <div class="form-group">
                <label for="phoneNo">Phone Number:</label>
                <input type="text" id="phoneNo" name="PHONE_NO">
            </div>
            <div class="form-group">
                <label for="email">Email ID:</label>
                <input type="email" id="email" name="EMAIL_ID">
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select id="gender" name="GENDER">
                    <option value="M">Male</option>
                    <option value="F">Female</option>
                    <option value="O">Other</option>
                </select>
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="USERNAME" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="PASSWORD" required>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="ADDRESS">
            </div>
            <div class="form-group">
                <label for="securityQuestion">Security Question:</label>
                <select id="securityQuestion" name="COL1" required>
                    <option value="teacher">What is your favorite teacher's name?</option>
                    <option value="pet">What is your first pet's name?</option>
                    <option value="movie">What is your favorite movie?</option>
                </select>
            </div>
            <div class="form-group">
                <label for="securityAnswer">Security Answer:</label>
                <input type="text" id="securityAnswer" name="COL2" required>
            </div>
            <button type="submit">Signup</button>
        </form>
    </div>
</body>
</html>
