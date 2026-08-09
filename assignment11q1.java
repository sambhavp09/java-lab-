interface Printable {
    void print();
}

class Student implements Printable {
    public void print() {
        System.out.println("Student: Sambhav");
    }
}

class Employee implements Printable {
    public void print() {
        System.out.println("Employee: Rahul");
    }
}

public class assignment11q1 {
    public static void main(String[] args) {
        Student s = new Student();
        Employee e = new Employee();

        s.print();
        e.print();
    }
}