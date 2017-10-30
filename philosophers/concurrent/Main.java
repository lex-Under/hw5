package hw5.philosophers.concurrent;

public class Main {

    public static void main(String[] args) {
        int philosophersCount = 5;
        int eatTime = 500;
        int thinkTime = 500;
        Philosopher[] philosophers = new Philosopher[philosophersCount];
        Forks forks = new Forks(philosophersCount);
        philosophers[0] = new Philosopher("Philosopher#0", eatTime, thinkTime, forks, philosophersCount - 1, 0);
        Thread t0 = new Thread(philosophers[0]);
        t0.start();
        for (int i = 1; i < philosophersCount; i++) {
            philosophers[i] = new Philosopher("Philosopher#" + i, eatTime, thinkTime, forks, i, i - 1);
            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }

}
