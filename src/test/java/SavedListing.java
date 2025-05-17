import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SavedListing extends  methods{
    @Test(priority = 1)
    public void CheckSavedListing() {
        clicks(By.xpath("//android.view.View[@content-desc=\"35 Listing Projects\n" +
                "01\n" +
                "Listing Projects\n" +
                "Discover our collection of ongoing and completed real estate development projects.\"]"));
        clicks(By.xpath("//android.view.View[@content-desc=\"0%, Available\n" +
                "1/10\n" +
                "Single Phase\n" +
                "Mayar\n" +
                "From \n" +
                "0\n" +
                " AED\n" +
                "Ref.6421814000019889013\n" +
                "Najmat Abu Dhabi, Al Reem Island, Abu Dhabi, United Arab Emirates\n" +
                "1 week ago\n" +
                "3-4\n" +
                "0%\n" +
                " Completed\n" +
                "Handover:\n" +
                "Q1 1\"]/android.view.View[2]"));
    }
    @Test(priority = 2)
    public void LogggedIn(){
        clicks(By.xpath("//android.view.View[@content-desc=\"Close sheet\"]"));
        EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText[1]"),"mark.casuco5@gmail.com");
        clickdifferent(By.xpath("//android.view.View[@content-desc=\"Password\"]"));
        EnterText(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.EditText[2]"),"Travsmakoy5!");
        clickdifferent(By.xpath("//android.view.View[@content-desc=\"Password\"]"));

        clicks(By.xpath("//android.view.View[@content-desc=\"Login\"]"));
        clicks(By.xpath("//android.view.View[@content-desc=\"Close sheet\"]"));
    }
    @Test(priority = 3)
    public void checkSaved(){

        clicks(By.xpath("//android.view.View[@content-desc=\"0%, Available\n" +
                "1/10\n" +
                "Single Phase\n" +
                "Mayar\n" +
                "From \n" +
                "0\n" +
                " AED\n" +
                "Ref.6421814000019889013\n" +
                "Najmat Abu Dhabi, Al Reem Island, Abu Dhabi, United Arab Emirates\n" +
                "1 week ago\n" +
                "3-4\n" +
                "0%\n" +
                " Completed\n" +
                "Handover:\n" +
                "Q1 1\"]/android.view.View[2]"));
        clicks(By.xpath("//android.widget.Button"));
        clicks(By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_MORE\n" +
                "More\"]"));
        clicks(By.xpath("//android.widget.ImageView[@content-desc=\"Saved Listings\"]"));
        clicks(By.xpath("//android.view.View[@content-desc=\"Listing Project\n" +
                "Tab 3 of 3\"]"));

    }
    @Test(priority = 4)
    public void unsaved(){
        clicks(By.xpath("//android.view.View[@content-desc=\"0%, Available\n" +
                "1/10\n" +
                "Single Phase\n" +
                "Mayar\n" +
                "From \n" +
                "0\n" +
                " AED\n" +
                "Ref.6421814000019889013\n" +
                "Najmat Abu Dhabi, Al Reem Island, Abu Dhabi, United Arab Emirates\n" +
                "1 week ago\n" +
                "0\n" +
                "3-4\n" +
                "0\n" +
                "0%\n" +
                " Completed\n" +
                "Handover:\n" +
                "Q1 1\"]/android.view.View[2]"));

        clicks(By.xpath("//android.widget.Button"));

    }
}
