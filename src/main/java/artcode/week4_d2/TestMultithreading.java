package artcode.week4_d2;

/**
 * Created by yurii on 19.02.17.
 */
public class TestMultithreading {

    public static void main(String[] args) {

        Container container = new Container();


        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                container.inc();
            }
        });


        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                container.decr();
            }
        });


         {
            thread1.start();
            thread2.start();
        }


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(container.getCount());
    }
}
