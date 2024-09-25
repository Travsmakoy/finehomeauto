import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class checkNav extends methods {

    @Test(priority = 1)
    public void Agents() throws InterruptedException
    {Thread.sleep(3000);
    clicks(By.xpath("//android.widget.ImageView[@content-desc=\"Agents\"]"));;
    }
    @Test(priority = 2)
    public void Properties(){
        clicks(By.xpath("//android.widget.ImageView[@content-desc=\"Properties\"]"));
    }
    @Test(priority = 3)
    public void Home(){
        clicks(By.xpath("//android.widget.ImageView[@content-desc=\"Home\"]"));
    }
    @Test(priority = 4)
    public void Services(){
        clicks(By.xpath("//android.widget.ImageView[@content-desc=\"Services\"]"));
    }
    @Test(priority = 5)
    public void Settings(){
        clicks(By.xpath("//android.widget.ImageView[@content-desc=\"More\"]"));
    }
    @Test(priority = 6)
    public void Login(){
        clickdifferent(By.xpath("//android.view.View[@content-desc=\"Login\"]"));
    }
}
