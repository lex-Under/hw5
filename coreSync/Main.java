package hw5.coreSync;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank(500);
        int usersCount = 25;
        for (int i = 0; i < usersCount; i++) {
            BankUser user = new BankUser(bank, 10);
            Thread t = new Thread(user);
            t.start();
        }
    }
}
