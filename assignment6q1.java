interface Action {
    void perform();
}

public class assignment6q1 {

    String vehicleName = "Car";

    class Details {
        void display() {
            System.out.println("Vehicle: " + vehicleName);
        }
    }

    public static void main(String[] args) {

        assignment6q1 obj = new assignment6q1();

        assignment6q1.Details d = obj.new Details();
        d.display();

        Action a = new Action() {
            public void perform() {
                System.out.println("Vehicle is moving.");
            }
        };

        a.perform();
    }
}