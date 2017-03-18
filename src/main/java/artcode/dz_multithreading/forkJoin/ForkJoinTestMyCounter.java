/*
package artcode.dz_multithreading.forkJoin;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;

*/
/**
 * Created by yurii on 03.03.17.
 *//*

public class ForkJoinTestMyCounter {
    public static void main(String[] args) {

        double start = new Date().getTime();

        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }

        MyCounter myCounter = new MyCounter(numbers, 0, numbers.length, new Filter() {
            @Override
            public boolean accept(double x) {
                return x > 0.5;
            }
        });

        ForkJoinPool pool = new ForkJoinPool();

        System.out.println(myCounter.getRes());

        double end = new Date().getTime();
        System.out.println("time " + (end - start));

    }
}
*/
