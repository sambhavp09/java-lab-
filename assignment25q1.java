class NumberThread extends Thread {

    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class assignment25q1 {

    public static void main(String[] args) {

        NumberThread t1 = new NumberThread();
        NumberThread t2 = new NumberThread();

        t1.start();
        t2.start();
    }
}