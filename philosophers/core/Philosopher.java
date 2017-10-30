package hw5.philosophers.core;

public class Philosopher implements Runnable {

    private final String name;
    private final int eatTime;
    private final int thinkTime;
    private final Forks forks;
    private final int forkIndex1;
    private final int forkIndex2;

    public Philosopher(String name, int eatTime, int thinkTime, Forks forks, int forkIndex1, int forkIndex2) {
        this.name = name;
        this.eatTime = eatTime;
        this.thinkTime = thinkTime;
        this.forks = forks;
        this.forkIndex1 = forkIndex1;
        this.forkIndex2 = forkIndex2;
    }

    public void eat() throws InterruptedException {
        synchronized (forks.getFork(forkIndex1)) {
            synchronized (forks.getFork(forkIndex2)) {
                System.out.println(name + " eats...");
                Thread.sleep(eatTime);
            }
        }
    }

    public void think() throws InterruptedException {
        System.out.println(name + " thinks...");
        Thread.sleep(thinkTime);
    }

    @Override
    public void run() {
        while (true) {
            try {
                eat();
                think();
            } catch (InterruptedException e) {
                System.out.println("Someone interrupted philospher!!! - " + e.getMessage());
            }
        }
    }
}
