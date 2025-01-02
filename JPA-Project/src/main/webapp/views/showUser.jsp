<html>
<head>
<title>Welcome JPA Project</title>
<style>
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
    
    
    
</head>
<body>
<h1>show User Details</h1>
${user}<br>
${user.name}
<br>
<a href="index" class="button">Go to Index</a>

<br><br><br>
 <!-- Form with a button to redirect to index.jsp -->
    <form action="index.jsp" method="get">
        <button type="submit">Go to Index</button>
    </form>

</body>
</html>
