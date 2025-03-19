<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to PawsTrack</title>
    <style>
        body {
            margin: 0;
            font-family: 'Roboto', Arial, sans-serif;
            background: linear-gradient(to bottom, #e8f5e9, #b2dfdb); /* Gradient background */
            color: #333; /* Darker text for better contrast */
        }
        .container {
            max-width: 1000px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff; /* White background for content */
            border-radius: 15px;
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2); /* Subtle shadow */
            overflow: hidden;
        }
        .header {
            background-color: #4caf50; /* Green header */
            padding: 20px;
            color: white;
            text-align: center;
            border-radius: 15px 15px 0 0; /* Rounded top corners */
        }
        .header .logo {
            font-size: 2.5rem;
            font-weight: bold;
        }
        .header .tagline {
            font-size: 1.2rem;
            margin-top: 5px;
            font-style: italic;
        }
        .content {
            padding: 30px;
            text-align: center;
        }
        .content .about {
            font-size: 1.4rem;
            font-weight: bold;
            color: #1b5e20;
            margin-bottom: 20px;
        }
        .images {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin-top: 20px;
        }
        .images img {
            width: 180px;
            height: auto;
            border-radius: 10px;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .images img:hover {
            transform: scale(1.1); /* Slight zoom effect */
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.3);
        }
        .quotes-section {
            margin-top: 30px;
        }
        .quote {
            font-size: 1.3rem;
            font-style: italic;
            font-weight: bold;
            color: #388e3c;
            margin: 10px 0;
        }
        .buttons {
            margin-top: 30px;
        }
        .button {
            text-decoration: none;
            padding: 12px 25px;
            margin: 10px;
            font-size: 1rem;
            font-weight: bold;
            color: white;
            background-color: #4caf50; /* Green button */
            border-radius: 25px; /* Rounded buttons */
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        .button:hover {
            background-color: #388e3c; /* Darker green on hover */
            transform: translateY(-3px); /* Lift effect */
        }
        .footer {
            margin-top: 30px;
            background-color: #1b5e20;
            color: white;
            text-align: center;
            padding: 10px;
            border-radius: 0 0 15px 15px; /* Rounded bottom corners */
        }
        .footer p {
            margin: 0;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Header Section -->
        <div class="header">
            <div class="logo">Welcome to PawsTrack</div>
            <div class="tagline">Your ultimate companion for pet care and tracking!</div>
            <div class="tagline">At Paws Track, we understand that your pets are more than just animals?they?re family. Our mission is to provide innovative and reliable solutions to ensure the safety, health, and happiness of your furry companions.</div>
        </div>

        <!-- Content Section -->
        <div class="content">
            <div class="about">We care about your pet and provide the best solutions to keep them safe and happy.</div>

            <!-- Puppy Images -->
            <div class="images">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcSg6lyW2veKh0oyj4yEwZwye8SW8RgNVAiDGAr3YGpmyp_M0VIyzLiMwtp17Ih8z1qX8&usqp=CAU" alt="Cute Puppy 1">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV74tirzUCE4VmuHR5IZcQDY1Pk825ww8inzkjygY_yhSSFdp2Ya26MlFC0n4Fzv6jw6A&usqp=CAU" alt="Cute Puppy 2">
                <img src="https://i.pinimg.com/originals/b9/c4/35/b9c435d70bf634a723f45e884dd24876.jpg" alt="Cute Kitten">
            </div>

            <!-- Quotes Section -->
            <div class="quotes-section">
                <div class="quote">"A dog is the only thing on earth that loves you more than he loves himself." ? Josh Billings</div>
                <div class="quote">"Time spent with cats is never wasted." ? Sigmund Freud</div>
            </div>

            <!-- Buttons Section -->
            <div class="buttons">
                <a href="SignUp.jsp" class="button">Sign Up</a>
                <a href="Login.jsp" class="button">Login</a>
            </div>
        </div>

        <!-- Footer Section -->
        <div class="footer">
            <p>&copy; 2024 PawsTrack. All Rights Reserved.</p>
        </div>
    </div>
</body>
</html>