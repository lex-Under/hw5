package hw5.philosophers.concurrent;

public class ForkIsReleasedException extends RuntimeException {

    public ForkIsReleasedException() {
        super();
    }

    public ForkIsReleasedException(String s) {
        super(s);
    }
}
