package utils;

import exceptions.FileNotFound;
import exceptions.NoSuchElement;
import exceptions.PropertiesNoLoadException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigurationData {

    private static final Logger log = Logger.getLogger(ConfigurationData.class);

    /*path where to store locators*/
    private static final String UI_MAPPING_PATH = "src/main/resources/UIMapping.PROPERTIES";

    private static ConfigurationData config;
    private final Properties PROPERTIES;
    private Map<String, String> propertiesMap;

    /**
     * static method for return configuration data
     *
     * @return configuration data {@link ConfigurationData}
     */
    public static ConfigurationData getConfigData() {

        if (config == null) {
            config = new ConfigurationData();
        }
        return config;

    }

    /**
     * private constructor
     *
     * @throws IOException
     */
    private ConfigurationData() {

        this.PROPERTIES = new Properties();
        log.info("created PROPERTIES in configuration data");
        try {
            this.propertiesMap = loadPropertiesToMap();
            log.info("created map PROPERTIES in configuration data");
        } catch (IOException e) {
            e.printStackTrace();
            log.error(String.format("EXCEPTION < %s >", e.getStackTrace()));
        }

    }

    /**
     * Private method for loaded PROPERTIES to the map {@link ConfigurationData#propertiesMap}
     *
     * @return {@link HashMap <String, String> with {@value PROPERTIES}} If file is not exists and
     * path correct, otherwise {@link FileNotFound}
     * @throws NoSuchElement             If {@link FileInputStream not opening a connection to an actual
     *                                   file {@value UI_MAPPING_PATH}}
     * @throws FileNotFound              If false {@link Files#exists(Path, LinkOption...) and
     *                                   {@link Paths#get(String, String...)}, where
     *                                   String => {@value UI_MAPPING_PATH}}
     * @throws PropertiesNoLoadException if {@link #PROPERTIES} not
     *                                   {@link Properties#load(InputStream)}
     * @throws IOException               this exceptions throw method {@link Properties#load(InputStream)}
     */
    private Map<String, String> loadPropertiesToMap()
            throws NoSuchElement, FileNotFound, PropertiesNoLoadException {

        if (Files.exists(Paths.get(UI_MAPPING_PATH))) {

            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(UI_MAPPING_PATH);
                PROPERTIES.load(fileInputStream);
            } catch (FileNotFound e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new NoSuchElement(
                    String.format("< %s > not found exceptions", UI_MAPPING_PATH.substring(13)));
        }

        return propertiesMap = new HashMap<String, String>((Map) PROPERTIES);

    }

    /**
     * private method for return value property
     *
     * @return key from PROPERTIES map
     */
    private String getPropertyValue(String key) {
        return propertiesMap.get(key);
    }

    /**
     * this method get locator
     *
     * @return element {@link By}
     * @throws NoSuchElement when the locator is not found by key
     */
    public By getLocator(String key) throws NoSuchElement {

        String[] partsOfLocators = getPropertyValue(key).split("\"");
        String findMethod = partsOfLocators[0].substring(0, partsOfLocators[0].length() - 1);
        String locator = partsOfLocators[1];

        switch (findMethod) {
            case "id":
                return By.id(locator);
            case "name":
                return By.name(locator);
            case "class":
                return By.className(locator);
            case "cssSelector":
                return By.cssSelector(locator);
            case "xpath":
                return By.xpath(locator);
            default:
                throw new NoSuchElement(
                        String.format("locator < %s > not defined!", locator));
        }

    }

}
