package artcode.dz_multithreading.bankExample;

import java.util.concurrent.atomic.*;

/**
 * Created by yurii on 22.02.17.
 */
public class Account {
    private volatile double count;
    private final Object moitor = new Object();
    private double decrAmount;

    public Account(double count) {
        this.count = count;
    }

    public void inc(double amount) {
        synchronized (moitor) {
            count += amount;
            if (count >= decrAmount) {
                moitor.notifyAll();
            }
        }
    }

    public void decr(double decrAmount) {
        synchronized (moitor) {
            while (count < decrAmount) {
                try {
                    moitor.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count -= decrAmount;
        }
    }


    public double getCount() {
        return count;
    }
}

