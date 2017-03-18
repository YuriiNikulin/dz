package artcode.dz_multithreading.forkJoin;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;


public class ForkJoinTest {
    public static void main(String[] args) {

        double start = new Date().getTime();

        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }
        Counter counter = new Counter(numbers, 0, numbers.length, new Filter() {
            @Override
            public boolean accept(double x) {
                return x > 0.5;
            }
        });

        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(counter.compute());


        double end = new Date().getTime();
        System.out.println("time " + (end-start));

    }
}
