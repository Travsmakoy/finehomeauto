import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class login extends methods{
    @Test(priority = 1)
    public void username(){
        clickElement(By.xpath("//android.view.View[@content-desc=\"Close sheet\"]\n"));
        enterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText[1]\n"),"mark.casuco5@gmail.com");
    }
    @Test(priority = 2)
    public void password(){
        clickElement(By.xpath("//android.view.View[@content-desc=\"Password\"]"));
        enterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"),"Travsmakoy5!");
        clickElement(By.xpath("//android.widget.ImageView\n"));
    }
    @Test(priority = 3)
    public void forgetpass() throws InterruptedException {
        clickElement(By.xpath("//android.view.View[@content-desc=\"Forget Password?\"]"));
        enterText(By.xpath("//android.widget.EditText"),"test@gmail.com");
        clickElement(By.xpath("//android.view.View[@content-desc=\"Send OTP\"]"));
    }
    @Test(priority = 4)
    public void otpPage(){
        clickElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]"));
    }
    @Test(priority = 5)
    public void createaccount(){
        clickElement(By.xpath("//android.widget.Button[@content-desc=\"Create Account\"]"));
        enterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"),"testusername");
        enterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"),"testpassword");
        enterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[3]"),"testpassword");
        clickElement(By.xpath("//android.widget.ImageView\n"));
        clickElement(By.xpath("//android.widget.Button[@content-desc=\"Login\"]"));
    }
}
