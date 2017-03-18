package artcode.dz_multithreading.mathCounting;

/**
 * Created by yurii on 22.02.17.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MatchCounter implements Runnable {

    private File directory;
    private String keyword;
    private volatile AtomicInteger count = new AtomicInteger();
    private List<String> fileList = new ArrayList<>();

    public MatchCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public void run() {

        System.out.println("new thread");
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounter counter = new MatchCounter(file, keyword);
                System.out.println(file);
                count.getAndIncrement();
                counter.run();
            } else {
                if (search(file)) {
                    count.getAndIncrement();
                }
            }
        }
    }

    private boolean search(File file) {
        try (Scanner in = new Scanner(file)) {
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword)) {
                    System.out.println(line);
                    found = true;
                }
            }
            return found;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public int getCount() {
        return count.get();
    }
}