import java.io.*;

public class assignment13q1 {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("employee.txt");
        fw.write("Employee ID: 101\n");
        fw.write("Name: Sambhav\n");
        fw.write("Salary: 50000\n");
        fw.close();

        BufferedReader br = new BufferedReader(new FileReader("employee.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}