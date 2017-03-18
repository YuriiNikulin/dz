package artcode.dz_multithreading.bankExample;


/**
 * Created by yurii on 22.02.17.
 */
public class Bank {

    private Account[] accounts;

    public Bank(int n, double initialBalance) {

        accounts = new Account[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = new Account(initialBalance);
        }
    }

    public void transfer(int from, int to, double amount) {

        System.out.print(Thread.currentThread());
        System.out.printf(" %10.2f from %d to %d", amount, from, to);


        accounts[from].decr(amount);
        accounts[to].inc(amount);

        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
        System.out.println();
    }

    private double getTotalBalance() {
        double sum = 0;

        for (int i = 0; i < accounts.length; i++) {
            sum += accounts[i].getCount();
        }
        return sum;
    }

    public int size() {
        return accounts.length;
    }
}

