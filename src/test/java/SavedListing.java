import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class SavedListing extends BaseMethods {
    private final By propertyFilter = By.xpath("//android.view.View[contains(@content-desc, 'Show Result ')]");

    private final By LISTING_PROJECTS = By.xpath("//android.view.View[contains(@content-desc, 'Listing Projects')]");
    private final By LISTING_PROPERTY = By.xpath("//android.view.View[contains(@content-desc, 'Property And Luxury')]");
    private final By LISTING_UNIT = By.xpath("//android.view.View[contains(@content-desc, 'Unit And Luxury')]");
    private final By MAYAR_CARD = By.xpath("//android.view.View[contains(@content-desc, 'Al Mahra Residence')]/android.view.View[2]");
    private final By PROP_CARD = By.xpath("//android.view.View[contains(@content-desc, 'Commercial Building')]/android.view.View[2]");
    private final By UNIT_CARD = By.xpath("//android.view.View[contains(@content-desc, 'Apartment')]/android.view.View[2]");

    private final By CLOSE_SHEET = By.xpath("//android.view.View[@content-desc='Close sheet']");
    private final By EMAIL_FIELD = By.xpath("//android.widget.EditText[1]");
    private final By PASSWORD_FIELD = By.xpath("//android.widget.EditText[2]");
    private final By LOGIN_BUTTON = By.xpath("//android.view.View[@content-desc='Login']");
    private final By SAVE_BUTTON = By.xpath("//android.widget.Button");
    private final By MORE_TAB = By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_MORE\n" +
            "More\"]");
    private final By SAVED_LISTINGS = By.xpath("//android.widget.ImageView[@content-desc='Saved Listings']");
    private final By LISTING_PROJECT = By.xpath("//android.view.View[@content-desc='Listing Project\nTab 3 of 3']");
    private final By TAB_PROPERTY = By.xpath("//android.view.View[@content-desc='Property\nTab 2 of 3']");
    private final By TAB_UNIT = By.xpath("//android.view.View[@content-desc='Unit\nTab 1 of 3']");

    private final By LOGOUT = By.xpath("//android.view.View[@content-desc=\"Log Out\"]");
    private final By HOME = By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_HOME\n" +
            "Home\"]");
    private final By projectTile = By.xpath("//android.view.View[contains(@content-desc, 'Listing Projects')]");

    private void swipeHorizontally(int startX, int y, int distance) {
        int endX = startX + distance;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 2);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }
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
    public void ListingProjects() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME));
        clickElement(HOME);
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(projectTile));
        clickElement(projectTile);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAYAR_CARD));
        clickElement(MAYAR_CARD);
    }

//    @Test(priority = 2)
//    public void loginAsUser() {
//        clickElement(CLOSE_SHEET);
//        enterText(EMAIL_FIELD, "mark.casuco5@gmail.com");
////        clickdifferent(PASSWORD_FIELD); // Brings keyboard focus
//        enterText(PASSWORD_FIELD, "Travsmakoy5!");
//        clickAndLogText(PASSWORD_FIELD);
//        clickElement(LOGIN_BUTTON);
//        clickElement(CLOSE_SHEET);
//    }

    @Test(priority = 2)
    public void SaveProject() {
        clickElement(MAYAR_CARD);
        clickElement(SAVE_BUTTON);
    }
    @Test(priority = 3)
    public void SaveProperty(){
        swipeHorizontally(1000, 1100, -600); // swipe left
        wait.until(ExpectedConditions.visibilityOfElementLocated(LISTING_PROPERTY));
        clickElement(LISTING_PROPERTY);
        clickElement(propertyFilter);
        clickElement(PROP_CARD);
        clickElement(SAVE_BUTTON);
    }
    @Test(priority = 3)
    public void SaveUnit(){
        swipeHorizontally(1000, 1100, -600); // swipe left
        wait.until(ExpectedConditions.visibilityOfElementLocated(LISTING_UNIT));
        clickElement(LISTING_UNIT);
        clickElement(propertyFilter);
        clickElement(UNIT_CARD);
        clickElement(SAVE_BUTTON);
    }

    @Test(priority = 5)
    public void UnSavedProjectListing() {
        clickElement(MORE_TAB);
        clickElement(SAVED_LISTINGS);
        clickElement(LISTING_PROJECT);
        boolean isSaved = driver.findElements(MAYAR_CARD).size() > 0;
        Assert.assertTrue(isSaved, "Project Saved listing is not displayed.");
        clickElement(MAYAR_CARD);
//        clickElement(SAVE_BUTTON);
    }
    @Test(priority = 6)
    public void UnsavedPropertyListing(){
        clickElement(TAB_PROPERTY);
        boolean isPropertySaved = driver.findElements(PROP_CARD).size() > 0;
        Assert.assertTrue(isPropertySaved, "Property Saved listing is not displayed.");
        clickElement(PROP_CARD);
    }
    @Test(priority = 7)
    public void UnsavedUnitListing(){
        clickElement(TAB_UNIT);
        boolean isUnitSaved = driver.findElements(UNIT_CARD).size() > 0;
        Assert.assertTrue(isUnitSaved, "Unit Saved listing is not displayed.");
        clickElement(UNIT_CARD);
        clickElement(SAVE_BUTTON);
    }
//    @Test(priority = 4)
//
//    public void LogOut() {
//        swipeVertically(500, 2500, -1500);
//        clickElement(LOGOUT);
//    }
}
