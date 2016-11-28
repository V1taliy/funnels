package tests;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.CompositionFunnels;
import utils.PropertyLoader;
import utils.WebDriverFactory;
import utils.WebDriverWrapper;

import java.util.concurrent.TimeUnit;

public class Fixture {

    public static String impWait = PropertyLoader.loadProperty("wait.timeout20sec");
    private static final Logger log = Logger.getLogger(Fixture.class);
    public static WebDriverWrapper driverWrapper;
    public static CompositionFunnels compositionFunnels;
    public static final boolean isGridEnabled = Boolean.parseBoolean(PropertyLoader.loadProperty("grid.enable"));

    @BeforeClass
    public static void startBrowser() {
        if (isGridEnabled == true) {
            driverWrapper = new WebDriverWrapper(WebDriverFactory.getGridInstance());
            driverWrapper.manage().timeouts().implicitlyWait(Long.parseLong(impWait), TimeUnit.SECONDS);
            try {
                compositionFunnels = new CompositionFunnels(driverWrapper);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info(String.format("start test execution"));
        } else if (isGridEnabled == false) {
            driverWrapper = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
            driverWrapper.manage().window().maximize();
            driverWrapper.manage().timeouts().implicitlyWait(Long.parseLong(impWait), TimeUnit.SECONDS);
            try {
                compositionFunnels = new CompositionFunnels(driverWrapper);
            } catch (Exception e) {
                e.printStackTrace();
            }
            log.info("start test execution");
        }
    }

    @AfterClass
    public static void quitBrowser() {
        if (driverWrapper != null) {
            driverWrapper.quit();
        }
        log.info(String.format("tests execution completed"));
    }
}
