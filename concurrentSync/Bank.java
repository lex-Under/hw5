package hw5.concurrentSync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final Lock lock = new ReentrantLock();
    private volatile int moneyAmount;

    public Bank(int initialMoney) {
        moneyAmount = initialMoney;
    }

    //synchronized здесь не нужен.
    //Этот метод нарушает принцип "Open/Closed" из SOLID
    public synchronized Lock getLock() {
        return lock;
    }

    public void getMoney(int money) {
        if (!hasMoney(money)) {
            throw new NoMoneyException("Bank has no money: " + money);
        } else {
            moneyAmount -= money;
        }
        System.out.format("thread '%s' got %d money.(money left in bank: %d)%n",
                Thread.currentThread().getName(),
                money,
                moneyAmount);
    }

    public boolean hasMoney(int amount) {
        return moneyAmount >= amount;
    }

}
