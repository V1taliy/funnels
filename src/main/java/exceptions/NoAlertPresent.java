package exceptions;

import org.openqa.selenium.NoAlertPresentException;

public class NoAlertPresent extends NoAlertPresentException {

    private static final String EXCEPTION_NAME = "NoAlertPresentException: ";

    public NoAlertPresent(String message) {
        super(String.format(EXCEPTION_NAME + "< %s >", message));
    }

}
