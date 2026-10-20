
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    ArrayList<String[]> patients =
        (ArrayList<String[]>) session.getAttribute("patients");

    if (patients == null) {
        patients = new ArrayList<String[]>();
        session.setAttribute("patients", patients);
    }

    String action = request.getParameter("action");
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String disease = request.getParameter("disease");
    String status = request.getParameter("status");
    String message = "";

    if ("Add".equals(action)) {
        boolean exists = false;

        for (String[] p : patients) {
            if (p[0].equals(id)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            message = "Patient ID already exists!";
        } else {
            patients.add(new String[]{id, name, age, disease, status});
            message = "Patient added successfully!";
        }
    }

    if ("Update".equals(action)) {
        boolean found = false;

        for (String[] p : patients) {
            if (p[0].equals(id)) {
                p[1] = name;
                p[2] = age;
                p[3] = disease;
                p[4] = status;
                found = true;
                break;
            }
        }

        message = found ? "Patient updated successfully!"
                        : "Patient ID not found!";
    }

    if ("Delete".equals(action)) {
        boolean removed = false;

        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i)[0].equals(id)) {
                patients.remove(i);
                removed = true;
                break;
            }
        }

        message = removed ? "Patient deleted successfully!"
                          : "Patient ID not found!";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Patient Management</title>
</head>
<body>
    <h2>Patient Record Management System</h2>

    <form method="post" action="patient.jsp">
        Patient ID:
        <input type="text" name="id" required><br><br>

        Name:
        <input type="text" name="name" required><br><br>

        Age:
        <input type="number" name="age" min="0" required><br><br>

        Disease:
        <input type="text" name="disease" required><br><br>

        Treatment Status:
        <select name="status" required>
            <option value="Under Treatment">Under Treatment</option>
            <option value="Recovered">Recovered</option>
            <option value="Discharged">Discharged</option>
        </select><br><br>

        <button type="submit" name="action" value="Add">Add</button>
        <button type="submit" name="action" value="Update">Update</button>
        <button type="submit" name="action" value="Delete">Delete</button>
    </form>

    <p><b><%= message %></b></p>

    <h3>Patient Records</h3>

    <table border="1" cellpadding="8">
        <tr>
            <th>Patient ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Disease</th>
            <th>Treatment Status</th>
        </tr>

        <% for (String[] p : patients) { %>
        <tr>
            <td><%= p[0] %></td>
            <td><%= p[1] %></td>
            <td><%= p[2] %></td>
            <td><%= p[3] %></td>
            <td><%= p[4] %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
