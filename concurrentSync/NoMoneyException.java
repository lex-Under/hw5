package hw5.concurrentSync;

public class NoMoneyException extends RuntimeException {

    public NoMoneyException() {
        super();
    }

    public NoMoneyException(String s) {
        super(s);
    }
}
