package framework_utilities;

import com.google.gson.JsonObject;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class UiUtilities {
    public static JsonObject TestDataJsonObj = CucumberHooks.TestDataJsonObj;
    public static JsonObject ActionConstantsJsonObj = CucumberHooks.ActionConstantsJsonObj;
    public Scenario _scenario;
    public WebDriver driver;
    GeneralUtilities generalUtilitiesObj = new GeneralUtilities();

    public UiUtilities() {
        driver = CucumberHooks.driver.get();
        _scenario = CucumberHooks._scenario;
    }

    public void embedScreenShot() {
        _scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
    }

    public void embedFullPageScreenshot() {
        try {
            BufferedImage image = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver).getImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            _scenario.embed(imageInByte, "image/png");
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click(By by) {
        WebElement webElement = driver.findElement(by);
        webElement.click();
    }

    public void click(WebElement webElement) {
        webElement.click();
    }

    public void waitAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void clickByJS(By by) {
        WebElement webElement = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", webElement);
    }

    public void sendKeys(WebElement webElement, String str) {
        webElement.sendKeys(str);
    }

    public void sendKeys(By by, String str) {
        WebElement webElement = driver.findElement(by);
        webElement.sendKeys(str);
    }

    public boolean isElementDisplayed(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public int getElementCount(By by) {
        int result = 0;
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            result = driver.findElements(by).size();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return result;
    }

    public int getElementCount(By parentElementBy, By childElementBy) {
        int result = 0;
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement parentElement = driver.findElement(parentElementBy);
            result = parentElement.findElements(childElementBy).size();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return result;
    }

    public boolean verifyTextInElement(By by, String text) {
        boolean result = false;
        WebElement webElement = driver.findElement(by);
        if (generalUtilitiesObj.isStrEquals(webElement.getText(), text))
            result = true;
        return result;
    }

    public boolean verifyPartialTextInElement(By by, String text) {
        boolean result = false;
        WebElement webElement = driver.findElement(by);
        if (generalUtilitiesObj.contains(webElement.getText(), text))
            result = true;
        return result;
    }

    public String getTextFromElement(By by) {
        WebElement webElement = driver.findElement(by);
        return webElement.getText();
    }

    public String getTextFromChildElement(By parentElementBy, By childElementBy) {
        WebElement parentElement = driver.findElement(parentElementBy);
        return parentElement.findElement(childElementBy).getText();
    }
}
