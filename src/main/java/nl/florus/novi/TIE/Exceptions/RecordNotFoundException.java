package nl.florus.novi.huiswerk_assignment1springboot082021.Exceptions;

public class RecordNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public RecordNotFoundException() {
        super();
    }
    public RecordNotFoundException(String message) {
        super(message);
    }
}
