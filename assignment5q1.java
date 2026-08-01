import java.util.ArrayList;

public class assignment5q1 {
    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Study Java");
        tasks.add("Complete Assignment");
        tasks.add("Go to Gym");

        StringBuffer sb = new StringBuffer();

        sb.append("To-Do List:\n");

        for (String task : tasks) {
            sb.append("- ").append(task).append("\n");
        }

        System.out.println(sb);
    }
}