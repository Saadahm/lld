package EvenOddThreading;

class Printer implements Runnable {
    int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runnable " + Thread.currentThread().getName() + " is running: " + i);
            try {
                Thread.sleep(5000); // Pause execution for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Printer oddp=new Printer();
//        Printer evenp=new Printer();
        Thread odd= new Thread(oddp);
        Thread even= new Thread(oddp);
        odd.start();
        even.start();
    }
}
