abstract class FoodOrder {
    double amount;

    FoodOrder(double amount) {
        this.amount = amount;
    }

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {
    DineInOrder(double amount) {
        super(amount);
    }

    void calculateBill() {
        System.out.println("Dine-In Bill: ₹" + (amount + 50));
    }
}

class TakeAwayOrder extends FoodOrder {
    TakeAwayOrder(double amount) {
        super(amount);
    }

    void calculateBill() {
        System.out.println("Take-Away Bill: ₹" + (amount + 20));
    }
}

public class assignment10q2 {
    public static void main(String[] args) {
        FoodOrder d = new DineInOrder(500);
        FoodOrder t = new TakeAwayOrder(500);

        d.calculateBill();
        t.calculateBill();
    }
}