package artcode.dz_multithreading.mathCounting;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatchCounterTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory:");
        String directory = in.nextLine();
        System.out.print("Enter keyword:");
        String keyword = in.nextLine();


        MatchCounter matchCounter = new MatchCounter(new File(directory), keyword);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(matchCounter);

        System.out.println(matchCounter.getCount() + " matching files.");

    }
}
