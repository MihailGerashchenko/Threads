package MyThread;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Thread MainThread = Thread.currentThread();
        System.out.println(MainThread.getName());

        Thread[] array = new Thread[100];
        for (int i = 0; i < array.length; i++) {
            MyThread myThread = new MyThread(i);
            Thread threadEach = new Thread(myThread);
            array[i] = threadEach;
            array[i].start();
        }
    }
}


