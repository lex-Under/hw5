package hw5.philosophers.concurrent;

public class ForkIsTakenException extends RuntimeException {

    public ForkIsTakenException() {
        super();
    }

    public ForkIsTakenException(String s) {
        super(s);
    }
}
