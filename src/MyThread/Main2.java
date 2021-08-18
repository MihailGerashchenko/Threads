package MyThread;

public class Main2 {
    public static void main(String[] args) {
        long time;

        int[] array = new int[100_000_000];
        int[] array1 = new int[25_000_000];
        int[] array2 = new int[25_000_000];
        int[] array3 = new int[25_000_000];
        int[] array4 = new int[25_000_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        time = System.currentTimeMillis();

        System.out.println("Main thread sum of the Main array with length " + array.length + " is " + Main2.countArray(array));
        System.out.println("Main thread time is " + (time = System.currentTimeMillis() - time) + " sec ");
        System.arraycopy(array, 0, array1, 0, 25000000);
        System.arraycopy(array, 25000000, array2, 0, 25000000);
        System.arraycopy(array, 50000000, array3, 0, 25000000);
        System.arraycopy(array, 75000000, array4, 0, 25000000);

        CountArray one = new CountArray(array1);
        CountArray two = new CountArray(array2);
        CountArray three = new CountArray(array3);
        CountArray four = new CountArray(array4);

        Thread thOne = new Thread(one);
        Thread thTwo = new Thread(two);
        Thread thThree = new Thread(three);
        Thread thFour = new Thread(four);

        thOne.start();
        thTwo.start();
        thThree.start();
        thFour.start();

        time = System.currentTimeMillis();

        try {
            thOne.join();
            thTwo.join();
            thThree.join();
            thFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The multithreading sum is " + (Main2.countArray(array1) + Main2.countArray(array2) + Main2.countArray(array3) + Main2.countArray(array4)));
        System.out.println("The multithreading time of the Main array split on 4 different arrays with length for each " + array1.length + " is " + (time = System.currentTimeMillis() - time) + " sec ");

    }

    public static int countArray(int[] array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            n += array[i];
        }
        return n;
    }
}


