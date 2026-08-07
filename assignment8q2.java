class Vehicle {
    String vehicleName = "Car";

    Vehicle() {
        System.out.println("Vehicle: " + vehicleName);
    }
}

class Insurance extends Vehicle {
    Insurance() {
        super();
        System.out.println("Insurance Type: Comprehensive");
    }
}

public class assignment8q2 {
    public static void main(String[] args) {
        Insurance i = new Insurance();
    }
}