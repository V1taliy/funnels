package exceptions;

import java.io.FileNotFoundException;

public class FileNotFound extends FileNotFoundException {

    static final String EXCEPTION_NAME = "FileNotFoundException: ";

    public FileNotFound(String message) {
        super(String.format(EXCEPTION_NAME + "< %s >", message));
    }

}
