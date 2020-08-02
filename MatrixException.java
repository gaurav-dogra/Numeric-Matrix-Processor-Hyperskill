package processor;

public class MatrixException extends RuntimeException {

    public MatrixException() {
        super("ERROR");
    }

    public MatrixException(String message) {
        super(message);
    }
}
