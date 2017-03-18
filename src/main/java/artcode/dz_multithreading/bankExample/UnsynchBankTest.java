package artcode.dz_multithreading.bankExample;

/**
 * Created by yurii on 22.02.17.
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 100;
    public static final int INITIAL_BALANCE = 10000;

    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            Thread t = new Thread(r);
            t.start();
        }
    }
}
