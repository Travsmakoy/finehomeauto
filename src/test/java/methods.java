import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        options.setDeviceName("OPPO Reno10 5G");
        options.setUdid("7D75SKOBXWOVUSDU");
        options.setPlatformName("Android");
        options.setPlatformVersion("14");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.aqary.investment");
        options.setAppActivity("com.aqary.investment.MainActivity");

        URL url = new URL("http://localhost:4723");
        driver = new AndroidDriver(url, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        System.out.println("App launched successfully!");
    }
    @AfterSuite
    public void tearDownSuite() throws InterruptedException {
        // Quit the WebDriver instance
        if (driver != null) {
            Thread.sleep(2000);
            driver.quit();
            System.out.println("ALL TEST COMPLETE");
        }
    }
    public void clicks(By locator){
   WebElement click = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   click.click();
    }
    public void clickdifferent(By locator){
        WebElement click = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String hold = click.getText();
        click.click();
        System.out.println(hold);
    }
    public void EnterText(By locator,String value){
        WebElement click = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        click.click();
        click.sendKeys(value);
    }
}
