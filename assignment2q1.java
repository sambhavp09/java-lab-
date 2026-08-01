class Student {
    String name;
    int rollNo;

    // Default Constructor
    Student() {
        name = "Unknown";
        rollNo = 0;
    }

    // Parameterized Constructor
    Student(String n, int r) {
        name = n;
        rollNo = r;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

public class assignment2q1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Sambhav", 101);

        System.out.println("Default Constructor:");
        s1.display();

        System.out.println("\nParameterized Constructor:");
        s2.display();
    }
}