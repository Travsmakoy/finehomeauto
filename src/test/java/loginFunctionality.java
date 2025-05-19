import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginFunctionality extends BaseMethods {

    private final By USERNAME_FIELD = By.xpath("//android.widget.EditText[1]");
    private final By PASSWORD_FIELD = By.xpath("//android.widget.EditText[2]");
    private final By CLOSE_SHEET = By.xpath("//android.view.View[@content-desc='Close sheet']");
    private final By LOGIN_BUTTON = By.xpath("//android.view.View[@content-desc='Login']");
    private final By LOGOUT = By.xpath("//android.view.View[@content-desc='Log Out']");
    private final By MORE = By.xpath("//android.widget.ImageView[@content-desc='BOTTOM_NAVIGATION_BAR_MORE\nMore']");
    private final By HOME = By.xpath("//android.widget.ImageView[@content-desc='BOTTOM_NAVIGATION_BAR_HOME\nHome']");
    private final By PROFILE_LOGIN_BUTTON = By.xpath("//android.view.View[@content-desc='PROFILE_LOGIN_BUTTON\nLogin']");
    private final By POST_LOGIN_ELEMENT = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]");

    @Test(priority = 1)
    public void enterUsername() {
        clickElement(MORE);
        clickElement(PROFILE_LOGIN_BUTTON);
        clickElement(CLOSE_SHEET);
        enterText(USERNAME_FIELD, "mark.casuco5@gmail.com");
    }

    @Test(priority = 2)
    public void enterPassword() {
        enterText(PASSWORD_FIELD, "Travsmakoy5!");
        clickAndLogText(PASSWORD_FIELD); // Optional: to dismiss keyboard
    }

    @Test(priority = 3)
    public void login() {
        clickElement(LOGIN_BUTTON);
        clickElement(CLOSE_SHEET);
        clickElement(POST_LOGIN_ELEMENT);
        clickElement(HOME);
    }

    @Test(priority = 4)
    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(MORE));
        clickElement(MORE);
        clickElement(LOGOUT);
    }

}


//    @Test(priority = 3)
//    public void testForgetPasswordFlow() {
//        clickElement(By.xpath("//android.view.View[@content-desc='Forget Password?']"));
//        enterText(By.xpath("//android.widget.EditText"), "test@gmail.com");
//        clickElement(By.xpath("//android.view.View[@content-desc='Send OTP']"));
//    }
//
//    @Test(priority = 4)
//    public void openOtpPage() {
//        clickElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
//    }
//
//    @Test(priority = 5)
//    public void createAccount() {
//        clickElement(By.xpath("//android.widget.Button[@content-desc='Create Account']"));
//
//        enterText(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"), "testusername");
//        enterText(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"), "testpassword");
//        enterText(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]"), "testpassword");
//
//        clickElement(By.xpath("//android.widget.ImageView"));
//        clickElement(By.xpath("//android.widget.Button[@content-desc='Login']"));
//    }

