class Employee {
    String name = "Sambhav";
    int id = 101;

    Employee() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
    }
}

class Manager extends Employee {
    Manager() {
        super();
        System.out.println("Manager Department: Sales");
    }
}

public class assignment8q1 {
    public static void main(String[] args) {
        Manager m = new Manager();
    }
}