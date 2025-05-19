import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class methods {

    protected static AppiumDriver driver;
    protected static WebDriverWait wait;

    @BeforeSuite
    public void setUpSuite() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("ignoreHiddenApiPolicyError", true);
        options.setCapability("noReset", true);
        options.setDeviceName("sdk_gphone64_x86_64");
        options.setUdid("emulator-5554");
        options.setPlatformName("Android");
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.aqary.investment");
        options.setAppActivity("com.aqary.aqary_mobile_whitelabel.MainActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723"), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        System.out.println("[INFO] App launched successfully.");
    }

    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
            System.out.println("[INFO] Driver quit successfully. ALL TESTS COMPLETE.");
        }
    }

    // ======================= Utility Methods =======================

    public void clickElement(By locator) {
        try {
            WebElement element = waitUntilClickable(locator);
            element.click();
            System.out.println("[ACTION] Clicked: " + locator.toString());
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to click: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void clickAndLogText(By locator) {
        try {
            WebElement element = waitUntilVisible(locator);
            String text = element.getText();
            element.click();
            System.out.println("[ACTION] Clicked and logged: " + text);
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to click/log text: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void enterText(By locator, String value) {
        try {
            WebElement field = waitUntilVisible(locator);
            field.click();
            field.clear();
            field.sendKeys(value);
            System.out.println("[ACTION] Entered text '" + value + "' into: " + locator.toString());
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to enter text in: " + locator.toString());
            e.printStackTrace();
        }
    }

    public WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return waitUntilVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getElementText(By locator) {
        try {
            return waitUntilVisible(locator).getText();
        } catch (Exception e) {
            System.err.println("[ERROR] Failed to get text from: " + locator.toString());
            return "";
        }
    }
}
