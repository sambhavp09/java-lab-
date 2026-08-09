import java.io.*;

public class assignment13q2 {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("patient.txt");

        fw.write("Patient ID: 101\n");
        fw.write("Name: Rahul\n");
        fw.write("Age: 25\n");
        fw.write("Diagnosis: Fever\n");

        fw.close();

        BufferedReader br = new BufferedReader(new FileReader("patient.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}