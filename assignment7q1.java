class Shape {
    void area() {
        System.out.println("Area of Shape");
    }
}

class Circle extends Shape {
    double radius = 5;

    void area() {
        double a = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + a);
    }
}

class Rectangle extends Shape {
    int length = 10, width = 5;

    void area() {
        int a = length * width;
        System.out.println("Area of Rectangle = " + a);
    }
}

public class assignment7q1 {
    public static void main(String[] args) {

        Circle c = new Circle();
        Rectangle r = new Rectangle();

        c.area();
        r.area();
    }
}