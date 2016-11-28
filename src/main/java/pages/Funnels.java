package pages;

import org.openqa.selenium.WebElement;
import utils.WebDriverWrapper;

import java.io.IOException;


public class Funnels extends Page {
    public Funnels(WebDriverWrapper driverWrapper) {
        super(driverWrapper);
    }

    public boolean openHomePage(String page) {
        return openPage(page);
    }

    public void clearAndInput(String data) {
        web.clearAndInputAndClickEnter("googleSearchField", data);
    }
    public WebElement getElement(String elementLocator){
        return web.getElement(elementLocator);
    }

    public String getLogoLink(String locator) {
        return web.getElement(locator).getAttribute("src");
    }

}
