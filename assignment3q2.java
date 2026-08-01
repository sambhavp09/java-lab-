class Restaurant {
    static int totalOrders = 0;

    void bill(int amount) {
        totalOrders++;
        System.out.println("Dine-in Bill: ₹" + amount);
    }

    void bill(int amount, boolean takeaway) {
        totalOrders++;
        System.out.println("Takeaway Bill: ₹" + amount);
    }

    void bill(int amount, String address) {
        totalOrders++;
        System.out.println("Delivery Bill: ₹" + amount);
    }
}

public class assignment3q2 {
    public static void main(String[] args) {
        Restaurant r = new Restaurant();

        r.bill(500);
        r.bill(350, true);
        r.bill(700, "Pune");

        System.out.println("Total Orders: " + Restaurant.totalOrders);
    }
}