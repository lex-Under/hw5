package hw5.coreSync;

public class BankUser implements Runnable {

    private final int moneyToWithdraw;
    private final Bank bank;

    public BankUser(Bank bank, int moneyToWithdraw) {
        this.bank = bank;
        this.moneyToWithdraw = moneyToWithdraw;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bank) {
                if (bank.hasMoney(moneyToWithdraw)) {
                    bank.getMoney(moneyToWithdraw);
                } else {
                    return;
                }
            }
        }
    }
}
