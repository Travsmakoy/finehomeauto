import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
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
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("ignoreHiddenApiPolicyError", true);
//        cap.setCapability("skipUnlock", true);
        cap.setCapability("noReset", true);
        cap.setCapability("deviceName", "OPPO Reno10 5G");
        cap.setCapability("udid", "7D75SKOBXWOVUSDU");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "14");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "com.aqary.investment");
        cap.setCapability("appActivity", "com.aqary.investment.MainActivity");
//        cap.setCapability("appPackage", "com.aqary.aqary_investment");
//        cap.setCapability("appActivity", "com.aqary.aqary_investment.MainActivity");
        URL url = new URL("http://localhost:4723");
        driver = new AndroidDriver(url, cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
