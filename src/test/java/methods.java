import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("ignoreHiddenApiPolicyError", true);
        cap.setCapability("skipUnlock", true);
        cap.setCapability("noReset", true);
        cap.setCapability("deviceName", "OPPO Reno10 5G");
        cap.setCapability("udid", "7D75SKOBXWOVUSDU");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "14");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "com.example.verygoodcore.finehome_new.dev");
        cap.setCapability("appActivity", "com.example.verygoodcore.finehome_new.MainActivity");
        URL url = new URL("http://localhost:4723");
        driver = new AndroidDriver(url, cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
}
