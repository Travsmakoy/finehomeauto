import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class login extends methods{
    @Test
    public void username(){
    EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"),"mark@admin.com");
    }
    @Test
    public void password(){
        EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"),"mark");
    }
}
