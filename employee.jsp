
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    ArrayList<String[]> employees =
        (ArrayList<String[]>) session.getAttribute("employees");

    if (employees == null) {
        employees = new ArrayList<String[]>();
        session.setAttribute("employees", employees);
    }

    String action = request.getParameter("action");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String department = request.getParameter("department");
    String salary = request.getParameter("salary");
    String message = "";

    if ("Add".equals(action)) {
        boolean exists = false;

        for (String[] e : employees) {
            if (e[0].equals(id)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            message = "Employee ID already exists!";
        } else {
            employees.add(new String[]{id, name, department, salary});
            message = "Employee added successfully!";
        }
    }

    if ("Update".equals(action)) {
        boolean found = false;

        for (String[] e : employees) {
            if (e[0].equals(id)) {
                e[1] = name;
                e[2] = department;
                e[3] = salary;
                found = true;
                break;
            }
        }

        message = found ? "Employee updated successfully!"
                        : "Employee ID not found!";
    }

    if ("Delete".equals(action)) {
        boolean removed = false;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i)[0].equals(id)) {
                employees.remove(i);
                removed = true;
                break;
            }
        }

        message = removed ? "Employee deleted successfully!"
                          : "Employee ID not found!";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
    <h2>Employee Management System</h2>

    <form method="post" action="employee.jsp">
        Employee ID:
        <input type="text" name="id" required><br><br>

        Name:
        <input type="text" name="name" required><br><br>

        Department:
        <input type="text" name="department" required><br><br>

        Salary:
        <input type="number" name="salary" min="0" step="0.01" required><br><br>

        <button type="submit" name="action" value="Add">Add</button>
        <button type="submit" name="action" value="Update">Update</button>
        <button type="submit" name="action" value="Delete">Delete</button>
    </form>

    <p><b><%= message %></b></p>

    <h3>Employee Records</h3>

    <table border="1" cellpadding="8">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Salary</th>
        </tr>

        <% for (String[] e : employees) { %>
        <tr>
            <td><%= e[0] %></td>
            <td><%= e[1] %></td>
            <td><%= e[2] %></td>
            <td><%= e[3] %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
