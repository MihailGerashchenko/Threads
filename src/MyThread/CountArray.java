package MyThread;

public class CountArray implements Runnable {
    private int[] array;

    public CountArray() {
    }

    public CountArray(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
    }
}
