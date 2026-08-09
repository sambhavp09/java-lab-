interface Switchable {
    void turnOn();
}

class Light implements Switchable {
    public void turnOn() {
        System.out.println("Light is ON");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan is ON");
    }
}

public class assignment11q2 {
    public static void main(String[] args) {
        Light l = new Light();
        Fan f = new Fan();

        l.turnOn();
        f.turnOn();
    }
}