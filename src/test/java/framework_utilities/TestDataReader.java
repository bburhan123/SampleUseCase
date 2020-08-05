package framework_utilities;

import test_data_variables.RunTimeTestData;
import com.google.gson.JsonObject;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.lang.reflect.Field;

public class TestDataReader {
    public static JsonObject TestDataJsonObj = CucumberHooks.TestDataJsonObj;
    public static JsonObject ActionConstantsJsonObj = CucumberHooks.ActionConstantsJsonObj;
    public Scenario _scenario;
    public WebDriver driver;

    public TestDataReader() {
        driver = CucumberHooks.driver.get();
        _scenario = CucumberHooks._scenario;
    }

    public String readData(String str) {
        boolean errorFlag = false;
        try {
            if (str != null && str.length() > 0) {
                if (str.startsWith("#")) {
                    str = str.substring(1);
                } else if (str.startsWith("RT")) {
                    Field fld = RunTimeTestData.class.getDeclaredField(str);
                    if (fld.getType().toString().equals("class java.lang.String"))
                        str = (String) fld.get(null);
                    else
                        str = fld.getName();
                } else if (str.startsWith("RAND")) {
                    Field fld = RunTimeTestData.class.getDeclaredField(str);

                    if (fld.get(null) != null && fld.getType().toString().equals("class java.lang.String"))
                        str = (String) fld.get(null);
                    else
                        str = fld.getName();
                } else {
                    if (TestDataJsonObj.has(str))
                        str = TestDataJsonObj.get(str).getAsString();
                    else if (ActionConstantsJsonObj.has(str))
                        str = ActionConstantsJsonObj.get(str).getAsString();
                    else {
                        //get the value from stored value
                        Field fld = RunTimeTestData.class.getDeclaredField(str);
                        if (fld.getType().toString().equals("class java.lang.String"))
                            str = (String) fld.get(null);
                        else
                            str = fld.getName();
                    }
                }
            } else
                str = null;
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
            errorFlag = true;
        } finally {
            if (errorFlag)
                Assert.fail("Please check the test data field");
            return str;
        }
    }
}
