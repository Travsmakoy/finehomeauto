import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class login extends methods{
    @Test(priority = 1)
    public void username(){
    EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"),"mark@admin.com");
    }
    @Test(priority = 2)
    public void password(){
        EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"),"mark");
        clicks(By.xpath("//android.widget.ImageView\n"));
    }
    @Test(priority = 3)
    public void forgetpass() throws InterruptedException {
        clicks(By.xpath("//android.view.View[@content-desc=\"Forget Password?\"]"));
        EnterText(By.xpath("//android.widget.EditText"),"test@gmail.com");
        clicks(By.xpath("//android.view.View[@content-desc=\"Send OTP\"]"));
    }
    @Test(priority = 4)
    public void otpPage(){
        clicks(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
    }
    @Test(priority = 5)
    public void createaccount(){
        clicks(By.xpath("//android.widget.Button[@content-desc=\"Create Account\"]"));
        EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"),"testusername");
        EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"),"testpassword");
        EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]"),"testpassword");
        clicks(By.xpath("//android.widget.ImageView\n"));
        clicks(By.xpath("//android.widget.Button[@content-desc=\"Login\"]"));
    }
}
