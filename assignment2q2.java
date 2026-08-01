class Mobile {
    String brand;
    int price;

    // Default Constructor
    Mobile() {
        brand = "Samsung";
        price = 15000;
    }

    // Parameterized Constructor
    Mobile(String b, int p) {
        brand = b;
        price = p;
    }

    // Copy Constructor
    Mobile(Mobile m) {
        brand = m.brand;
        price = m.price;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }
}

public class assignment2q2 {
    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile("Apple", 80000);
        Mobile m3 = new Mobile(m2);

        m1.display();
        m2.display();
        m3.display();
    }
}