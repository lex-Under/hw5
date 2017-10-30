package hw5.concurrentSync;

public class BankUser implements Runnable {

    private final Bank bank;
    private final int moneyToWithdraw;

    public BankUser(Bank bank, int moneyToWithdraw) {
        this.bank = bank;
        this.moneyToWithdraw = moneyToWithdraw;
    }

    @Override
    public void run() {
        while (true) {
            try {
                bank.getLock().lock();
                if (bank.hasMoney(moneyToWithdraw)) {
                    bank.getMoney(moneyToWithdraw);
                } else {
                    return;
                }
            } finally {
                bank.getLock().unlock();
            }
        }
    }
}
