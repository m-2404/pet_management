<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Sign Up</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 40%;
            margin: auto;
            background: white;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin-top: 50px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ddd;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Employee Sign Up</h1>
        <form action="SignUpEmployee" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <label for="securityQuestion">Security Question</label>
            <select id="securityQuestion" name="securityQuestion" required>
                <option value="" disabled selected>Select your security question</option>
                <option value="Teacher">What is your favorite teacher's name?</option>
                <option value="Pet">What is the name of your first pet?</option>
                <option value="Movie">What is your favorite movie?</option>
            </select>

            <label for="securityAnswer">Security Answer</label>
            <input type="text" id="securityAnswer" name="securityAnswer" required>

            <label for="gender">Gender</label>
            <select id="gender" name="gender" required>
                <option value="" disabled selected>Select your gender</option>
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>

            <label for="address">Address</label>
            <input type="text" id="address" name="address" required>

            <label for="phoneNo">Phone Number</label>
            <input type="text" id="phoneNo" name="phoneNo" required>

            <label for="position">Position</label>
            <input type="text" id="position" name="position" required>

            <label for="salary">Salary</label>
            <input type="number" id="salary" name="salary" step="0.01" required>

            <button type="submit">Sign Up</button>
        </form>
        <a href="loginEmployee.jsp">log In</a>
    </div>
</body>
</html>
