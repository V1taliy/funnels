package exceptions;

import java.util.NoSuchElementException;

public class NoSuchElement extends NoSuchElementException {

    private static final String EXCEPTION_NAME = "NoSuchElementException: ";

    public NoSuchElement(String message) {
        super(String.format(EXCEPTION_NAME + "< %s >", message));
    }

}
