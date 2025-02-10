import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;



public class checkNav extends methods {

    @Test(priority = 1)
    public void Team() throws InterruptedException {
        Thread.sleep(5000);
        WebElement teamNav = wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("BOTTOM_NAVIGATION_BAR_TEAM\nTeam")));
        teamNav.click();
    }
    @Test(priority = 2)
    public void Properties(){
        WebElement propNav = wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("BOTTOM_NAVIGATION_BAR_LISTING\nListing")));
        propNav.click();
    }
    @Test(priority = 3)
    public void Home(){
        WebElement homenav = wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("BOTTOM_NAVIGATION_BAR_HOME\nHome")));
        homenav.click();    }
    @Test(priority = 4)
    public void Services(){
        WebElement servnav = wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("BOTTOM_NAVIGATION_BAR_SERVICES\nServices")));
        servnav.click();    }
    @Test(priority = 5)
    public void Settings(){
        WebElement setnav = wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("BOTTOM_NAVIGATION_BAR_MORE\nMore")));
        setnav.click();    }
    @Test(priority = 6)
    public void Login(){
        WebElement lognav = wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("PROFILE_LOGIN_BUTTON\nLogin")));
        lognav.click();    }
}
