package exception;

public class OverDraftException extends Exception {
    private double deficit;

    public double getDeficit() {
        return deficit;
    }

    public OverDraftException(String message, double deficit) {
        super(message);
        this.deficit = deficit;
    }
}
