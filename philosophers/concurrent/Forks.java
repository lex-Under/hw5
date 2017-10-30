package hw5.philosophers.concurrent;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Forks {

    private final ReentrantLock[] forks;

    public Forks(int forkCount) {
        forks = new ReentrantLock[forkCount];
        Arrays.fill(forks, new ReentrantLock());
    }

    public void takeForksPair(int forkIndex1, int forkIndex2) {
        if (forks[forkIndex1].isLocked()) {
            throw new ForkIsTakenException("Fork is already taken! - Fork#" + forkIndex1);
        }
        if (forks[forkIndex2].isLocked()) {
            throw new ForkIsTakenException("Fork is already taken! - Fork#" + forkIndex2);
        }
        forks[forkIndex1].lock();
        forks[forkIndex2].lock();
    }

    public void releaseForksPair(int forkIndex1, int forkIndex2) {
        if (!forks[forkIndex1].isLocked()) {
            throw new ForkIsReleasedException("Fork is already released! - Fork#" + forkIndex1);
        }
        if (!forks[forkIndex2].isLocked()) {
            throw new ForkIsReleasedException("Fork is already released! - Fork#" + forkIndex2);
        }
        forks[forkIndex1].unlock();
        forks[forkIndex2].unlock();
    }

    public synchronized boolean isForksPairFree(int forkIndex1, int forkIndex2) {
        return !(forks[forkIndex1].isLocked() || forks[forkIndex2].isLocked());
    }
}
