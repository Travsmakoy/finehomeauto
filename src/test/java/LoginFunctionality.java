import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginFunctionality extends methods {

    private final By PASSWORD_FIELD = By.xpath("//android.widget.EditText[2]");

    @Test(priority = 1)
    public void enterUsername() {
        clickElement(By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_MORE\n" +
                "More\"]"));
        clickElement(By.xpath("//android.view.View[@content-desc=\"PROFILE_LOGIN_BUTTON\n" +
                "Login\"]"));
        clickElement(By.xpath("//android.view.View[@content-desc='Close sheet']"));
        enterText(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText[1]"), "mark.casuco5@gmail.com");
    }

    @Test(priority = 2)
    public void enterPassword() {
//        clickElement(By.xpath("//android.view.View[@content-desc='Password']"));
        enterText(PASSWORD_FIELD, "Travsmakoy5!");
        clickAndLogText(PASSWORD_FIELD); // Ensure the keyboard is dismissed or focus retained
        clickElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
        clickElement(By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_HOME\n" +
                "Home\"]"));
        System.out.println("TEST LOGIN DONE");
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
}
