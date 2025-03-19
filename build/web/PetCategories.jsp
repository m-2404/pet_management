<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pet Categories</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            text-align: center;
        }

        .categories-container {
            margin: 20px;
            padding: 20px;
            display: flex;
            justify-content: space-around;
            align-items: center;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .category {
            text-align: center;
            width: 200px;
        }

        .category img {
            width: 150px;
            height: 150px;
            object-fit: cover;
            border-radius: 8px;
        }

        .category h3 {
            margin-top: 10px;
            color: #333;
        }

        .button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            display: inline-block;
        }

        .button:hover {
            background-color: #45a049;
        }

        .go-back-button {
            background-color: #e74c3c;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            margin-top: 20px;
            display: inline-block;
            cursor: pointer;
        }

        .go-back-button:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

<header>
    <h1>Select Pet Categories</h1>
</header>

<div class="categories-container">

    <!-- Dog Category -->
    <div class="category">
        <img src="images/dog.jpg"  alt="Dog">

        <a href="dog.jsp" class="button">View Dogs</a>
    </div>

    
    <div class="category">
        <img src="images/cat.jpg" alt="Cat">
       
        <a href="cat.jsp" class="button">View Cats</a>
    </div>

</div>

<a href="Customer.jsp" class="button">Back</a>

</body>
</html>
