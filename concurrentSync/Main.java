package hw5.concurrentSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(500);
        int usersCount = 25;
        ExecutorService executor = Executors.newFixedThreadPool(usersCount);
        for (int i = 0; i < usersCount; i++) {
            BankUser user = new BankUser(bank, 10);
            executor.execute(user);
        }
        executor.shutdown();
    }
}
