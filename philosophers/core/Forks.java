package hw5.philosophers.core;

import java.util.Arrays;

public class Forks {

    private final Object[] forks;

    public Forks(int forkCount) {
        forks = new Object[forkCount];
        Arrays.fill(forks, new Object());
    }

    public Object getFork(int index) {
        return forks[index];
    }

}
