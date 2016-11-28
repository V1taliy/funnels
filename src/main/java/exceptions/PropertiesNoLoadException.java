package exceptions;

import java.io.IOException;

public class PropertiesNoLoadException extends IOException {

    private static final String EXCEPTION_NAME = "PropertiesNoLoadException: ";

    public PropertiesNoLoadException(String message) {
        String.format(EXCEPTION_NAME + "< %s >", message);
    }

}
