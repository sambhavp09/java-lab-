interface Product {
    void display();
}

class Item {
    String name = "Product";
    int price = 100;
}

class Electronic extends Item implements Product {
    public void display() {
        System.out.println("Electronic: Laptop Price: " + 50000);
    }
}

class Clothing extends Item implements Product {
    public void display() {
        System.out.println("Clothing: T-Shirt Price: " + 1000);
    }
}

class Grocery extends Item implements Product {
    public void display() {
        System.out.println("Grocery: Rice Price: " + 800);
    }
}

public class assignment7q2 {
    public static void main(String[] args) {

        Electronic e = new Electronic();
        Clothing c = new Clothing();
        Grocery g = new Grocery();

        e.display();
        c.display();
        g.display();
    }
}