package utils;

public class PropertiesUrlConcat {

    private static final String MAIN_DOMAIN = PropertyLoader.loadProperty("main.domain");

    public static String getFullUrl(String url) {
        return MAIN_DOMAIN.concat(url);
    }

    public static String getFullUrl(String mainDomain, String url) {
        return mainDomain.concat(url);
    }

}
