
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

class MyRunnable implements Runnable { // we can only extend one class but can implement multiple interfaces
    public void run() {  // only one method to implement in Runnable interface 
        System.out.println("Thread using Runnable");
    }
}

class Test extends Thread {
    public void run() {
        for(int i=1; i<=3; i++) {
            System.out.println(i);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // starts thread

        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t2.start(); // starts thread

        Test t3 = new Test();
        t3.start(); // starts thread

    }
}