import java.util.ArrayList;

public class assignment5q2 {
    public static void main(String[] args) {

        ArrayList<String> courses = new ArrayList<>();

        // Add courses
        courses.add("Java");
        courses.add("Python");
        courses.add("Database");

        // Remove a course
        courses.remove("Python");

        // Display courses
        StringBuffer sb = new StringBuffer();

        sb.append("Registered Courses:\n");

        for (String course : courses) {
            sb.append("- ").append(course).append("\n");
        }

        System.out.println(sb);
    }
}