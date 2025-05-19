import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SavedListing extends methods {

    // ==================== Locators ====================
    private final By LISTING_PROJECTS = By.xpath("//android.view.View[@content-desc=\"35 Listing Projects\n" +
            "01\n" +
            "Listing Projects\n" +
            "Discover our collection of ongoing and completed real estate development projects.\"]");
    private final By MAYAR_CARD = By.xpath("//android.view.View[contains(@content-desc, 'Mayar')]/android.view.View[2]");
    private final By CLOSE_SHEET = By.xpath("//android.view.View[@content-desc='Close sheet']");
    private final By EMAIL_FIELD = By.xpath("//android.widget.EditText[1]");
    private final By PASSWORD_FIELD = By.xpath("//android.widget.EditText[2]");
    private final By LOGIN_BUTTON = By.xpath("//android.view.View[@content-desc='Login']");
    private final By SAVE_BUTTON = By.xpath("//android.widget.Button");
    private final By MORE_TAB = By.xpath("//android.widget.ImageView[@content-desc='BOTTOM_NAVIGATION_BAR_MORE\nMore']");
    private final By SAVED_LISTINGS = By.xpath("//android.widget.ImageView[@content-desc='Saved Listings']");
    private final By LISTING_TAB = By.xpath("//android.view.View[@content-desc='Listing Project\nTab 3 of 3']");
    private final By LOGOUT = By.xpath("//android.view.View[@content-desc=\"Log Out\"]");

    // ==================== Test 1: Navigate to Listings ====================
    @Test(priority = 1)
    public void openListingProjects() throws InterruptedException {
        Thread.sleep(250);
        clickElement(LISTING_PROJECTS);
        clickElement(MAYAR_CARD);
    }

    // ==================== Test 2: Perform Login ====================
    @Test(priority = 2)
    public void loginAsUser() {
        clickElement(CLOSE_SHEET);
        enterText(EMAIL_FIELD, "mark.casuco5@gmail.com");
//        clickdifferent(PASSWORD_FIELD); // Brings keyboard focus
        enterText(PASSWORD_FIELD, "Travsmakoy5!");
        clickAndLogText(PASSWORD_FIELD); // Ensure the keyboard is dismissed or focus retained
        clickElement(LOGIN_BUTTON);
        clickElement(CLOSE_SHEET); // Close popup if appears again
    }

    // ==================== Test 3: Save a Listing and Verify ====================
    @Test(priority = 3)
    public void saveAndVerifyListing() {
        clickElement(MAYAR_CARD);
        clickElement(SAVE_BUTTON);
        clickElement(MORE_TAB);
        clickElement(SAVED_LISTINGS);
        clickElement(LISTING_TAB);

        // Verification: Ensure saved listing appears
        boolean isSaved = driver.findElements(MAYAR_CARD).size() > 0;
        Assert.assertTrue(isSaved, "Saved listing is not displayed.");
    }

    // ==================== Test 4: Unsave the Listing ====================
    @Test(priority = 4)
    public void unSaveListing() {
        clickElement(MAYAR_CARD);
        clickElement(SAVE_BUTTON); // Toggle to unsave
        // Optional: Add assertion here to verify removal
    }
    @Test(priority = 5)
    public void LogOut() {
        clickElement(LOGOUT);
    }
}
