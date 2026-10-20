
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h2>Submitted Student Information</h2>

    <%
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String course = request.getParameter("course");
        String email = request.getParameter("email");
    %>

    <p>Student Name: <%= name %></p>
    <p>Roll Number: <%= roll %></p>
    <p>Course: <%= course %></p>
    <p>Email: <%= email %></p>

    <a href="student.jsp">Go Back</a>
</body>
</html>
