package artcode.week4_d2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yurii on 19.02.17.
 */
// some threads invoke 'inc', others invoke 'decr'
// 1. Make this class thread safe
// 2. Add conditions
//    thread cannot invoke increment while count doesn't equals 0
//    thread cannot invoke decrement while count equal 0
class Container {

    private volatile int count;
    private final Object moitor = new Object();

    public void inc() {
        synchronized (moitor){
        count++;
        }//.getAndIncrement();}
    }

    public void decr() {
        synchronized(moitor){
        count--;
        }//.getAndDecrement();}
    }

    public int getCount(){
        return count;//.intValue();
    }
}