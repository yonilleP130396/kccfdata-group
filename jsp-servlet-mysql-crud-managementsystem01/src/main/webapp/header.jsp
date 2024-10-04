<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.servlet.http.HttpSession" %>


    
    
<!DOCTYPE html>
<html>
<head>
    <title></title>
<style>
        /* CSS styles for the header */
        header {
            background-color: green; /* Dark background color */
            color: #fff; /* Text color */
            padding: 20px; /* Padding around the header */
            display: flex; /* Use flexbox layout */
            justify-content: flex-end; /* Align items to the end (right side) */
            align-items: center; /* Center items vertically */
        }
        header h3 {
            margin: 0; /* Remove default margin */
            margin-right: auto; /* Push the heading to the left */
        }
        nav ul {
            list-style-type: none; /* Remove default list style */
            padding: 0; /* Remove default padding */
            margin: 0; /* Remove default margin */
        }
        nav ul li {
            display: inline; /* Display list items horizontally */
            margin-right: 20px; /* Add some spacing between list items */
        }
        nav ul li a {
            color: #fff; /* Link text color */
            text-decoration: none; /* Remove underline from links */
        }
    </style>
</head>
<body>


<header>

    <h3>Group Management System</h3>
    <nav>
        <ul>
            <li><a href="<%=request.getContextPath()%>/list">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>
        </ul>
    </nav>
</header>

<!-- The rest of your page content goes here -->

</body>
</html>