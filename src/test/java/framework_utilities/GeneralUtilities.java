package framework_utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class GeneralUtilities {
    public WebDriver driver;
    public Scenario _scenario;

    public GeneralUtilities() {
        driver = CucumberHooks.driver.get();
        _scenario = CucumberHooks._scenario;
    }

    public boolean isStrEquals(String str1, String str2) {
        boolean result = false;
        if (str1 != null && str2 != null)
            result = str1.equalsIgnoreCase(str2);
        return result;
    }

    public boolean contains(String mainStr, String subStr) {
        boolean result = false;
        if (mainStr != null && subStr != null)
            result = mainStr.trim().toLowerCase().contains(subStr.trim().toLowerCase());
        return result;
    }
}
