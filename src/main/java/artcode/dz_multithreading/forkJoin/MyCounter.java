/*
package artcode.dz_multithreading.forkJoin;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by yurii on 03.03.17.
 *//*

public class MyCounter {

    public static final int THRESHOLD = 5000000;//1000;
    private double[] values;
    private int from;
    private int to;
    private Filter filter;
    private volatile int res;
    private final Object monitor = new Object();
    */
/*private List<Thread> threads = new ArrayList<>();
    private List<MyCounter> myCounterList = new ArrayList<>();*//*


    public MyCounter(double[] values, int from, int to, Filter filter) {
        this.values = values;
        this.filter = filter;
        this.to = to;
        this.from = from;
    }

    private void compute() {
        int count = 0;
        for (int i = from; i < to; i++) {
            if (filter.accept(values[i])) {
                count++;
            }
        }
        addCount(count);
    }

    private int addCount(int resThread) {
        synchronized (monitor) {
            return res += resThread;
        }
    }

    private void invokeAll() {
        if (to - from <= THRESHOLD) {
            //myCounterList.add(new MyCounter(values, from, to, filter));
        } else {
            int mid = (from + to) / 2;
            MyCounter first = new MyCounter(values, from, mid, filter);
            MyCounter second = new MyCounter(values, mid, to, filter);

            first.invokeAll();
            second.invokeAll();
        }
    }

    private void startThreads(List<MyCounter> myCounterList) {
        invokeAll();
        for (MyCounter myCounter : myCounterList) {
            //threads.add(new Thread(() -> {
                myCounter.compute();
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }

    public int getRes() {
        startThreads(myCounterList);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
*/
