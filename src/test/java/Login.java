import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class Login extends BaseMethods {

    private final By USERNAME_FIELD = By.xpath("//android.widget.EditText[1]");
    private final By PASSWORD_FIELD = By.xpath("//android.widget.EditText[2]");
    private final By CLOSE_SHEET = By.xpath("//android.view.View[@content-desc='Close sheet']");
    private final By LOGIN_BUTTON = By.xpath("//android.view.View[@content-desc='Login']");
    private final By LOGOUT = By.xpath("//android.view.View[@content-desc='Log Out']");
    private final By MORE = By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_MORE\n" +
            "More\"]");
    private final By PROFILE_LOGIN_BUTTON = By.xpath("//android.view.View[@content-desc='PROFILE_LOGIN_BUTTON\nLogin']");

    private void swipeVertically(int x, int startY, int distance) {
        int endY = startY + distance;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), x, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

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
        clickAndLogText(PASSWORD_FIELD);
    }

    @Test(priority = 3)
    public void Login() {
        clickElement(LOGIN_BUTTON);
        clickElement(CLOSE_SHEET);
    }
//    @Test(priority = 4)
//    public void logout()throws InterruptedException {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Home\"]")));
//        Thread.sleep(1500);
//        WebElement more = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_MORE\n" +
//                "More\"]")));
//        more.click();
//        swipeVertically(500, 2500, -1500);
//        clickElement(LOGOUT);
//    }



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

