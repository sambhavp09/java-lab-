interface Delivery {
    void status();
}

public class assignment6q2 {

    class Order {
        void details() {
            System.out.println("Order: Pizza");
        }
    }

    public static void main(String[] args) {

        assignment6q2 obj = new assignment6q2();

        assignment6q2.Order o = obj.new Order();
        o.details();

        Delivery d = new Delivery() {
            public void status() {
                System.out.println("Delivery Status: Out for Delivery");
            }
        };

        d.status();
    }
}