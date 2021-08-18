package MyThread;

import java.math.BigInteger;

public class MyThread implements Runnable {
    private int number;

    public MyThread(int number) {
        this.number = number;
    }

    public BigInteger calculateFac(int a) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= a; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 0; i <= number; i++) {
            if (thread.isInterrupted()) {
                System.out.println(thread.getName() + " is interrupted");
                return;
            }
            System.out.println(thread.getName() + " " + i + "!=" + calculateFac(i));
        }
    }
}
