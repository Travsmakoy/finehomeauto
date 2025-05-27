import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SectionCounts extends BaseMethods {

    // === Locators ===
    private final By projectTile = By.xpath("//android.view.View[contains(@content-desc, 'Listing Projects')]");
    private final By projectHeader = By.xpath("//android.view.View[contains(@content-desc, 'All Project')]");
    private final By projectLocation = By.xpath("//android.view.View[contains(@content-desc, 'Abu Dhabi')]");
    private final By propertyTile = By.xpath("//android.view.View[contains(@content-desc, 'Property And Luxury')]");
    private final By propertyFilter = By.xpath("//android.view.View[contains(@content-desc, 'Show Result ')]");
    private final By propertyLocation = By.xpath("//android.view.View[contains(@content-desc, 'Abu Dhabi')]");
    private final By backButton = By.xpath("//android.widget.Button");
    private final By HOME = By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_HOME\n" +
            "Home\"]");
    private int totalSectionCount = 0;
    // === Utility Methods ===

    private String extractFirstNumber(String text) {
        Matcher matcher = Pattern.compile("\\d+").matcher(text);
        return matcher.find() ? matcher.group() : "0";
    }

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

    private void backAndSwipeLeft() {
        clickElement(backButton);
//        waitForAnyElement(projectTile, propertyTile);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@content-desc, 'Sections')]")));
        swipeHorizontally(1000, 1100, -600); // swipe left
    }

    private void waitForAnyElement(By... locators) {
        for (By locator : locators) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                return; // found one, exit early
            } catch (Exception ignored) {

            }
        }
        throw new RuntimeException("None of the expected elements were found on screen.");
    }

    // === Test Cases ===

    @Test(priority = 1)
    public void VerifyListingProjectCounts() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_HOME\n" +
                "Home\"]")));
        clickElement(By.xpath("//android.widget.ImageView[@content-desc=\"BOTTOM_NAVIGATION_BAR_HOME\n" +
                "Home\"]"));
        String outerCount = extractFirstNumber(wait.until(ExpectedConditions.elementToBeClickable(projectTile)).getAttribute("content-desc"));
        System.out.println("Listing Project Count: " + outerCount);
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(projectTile));
        clickElement(projectTile);

        String headerCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(projectHeader)).getAttribute("content-desc"));
        String locationCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(projectLocation)).getAttribute("content-desc"));

        System.out.println("Header Count: " + headerCount);
        System.out.println("Location Count: " + locationCount);
//        totalSectionCount += Integer.parseInt(outerCount);
        backAndSwipeLeft();

        Assert.assertEquals(headerCount, outerCount, "Mismatch: Project header count does not match listing count.");
        Assert.assertEquals(locationCount, outerCount, "Mismatch: Project location count does not match listing count.");
    }

    @Test(priority = 2)
    public void VerifyPropertyCounts() throws InterruptedException {
        String outerCount = extractFirstNumber(wait.until(ExpectedConditions.elementToBeClickable(propertyTile)).getAttribute("content-desc"));
        System.out.println("Listing Property Count: " + outerCount);

        clickElement(propertyTile);

        String filterCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyFilter)).getAttribute("content-desc"));
        System.out.println("Filter Count: " + filterCount);
        Thread.sleep(800);
        clickElement(propertyFilter);

        String locationCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyLocation)).getAttribute("content-desc"));
        System.out.println("Location Count: " + locationCount);
        totalSectionCount += Integer.parseInt(outerCount);

        backAndSwipeLeft();

        Assert.assertEquals(filterCount, outerCount, "Mismatch: Property filter count does not match listing count.");
        Assert.assertEquals(locationCount, outerCount, "Mismatch: Property location count does not match listing count.");
    }
    @Test(priority = 3)
    public void VerifyUnitCounts() throws InterruptedException {
        String outerCount = extractFirstNumber(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc, 'Unit And Luxury')]"))).getAttribute("content-desc"));
        System.out.println("Listing Unit Count: " + outerCount);

        clickElement(By.xpath("//android.view.View[contains(@content-desc, 'Unit And Luxury')]"));
        Thread.sleep(1500);
        String filterCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyFilter)).getAttribute("content-desc"));
        System.out.println("Sale Filter Count: " + filterCount);
        clickElement(By.xpath("//android.widget.ImageView[@content-desc=\"Rent\"]"));
        Thread.sleep(1000);
        String RentfilterCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyFilter)).getAttribute("content-desc"));
        System.out.println("Rent Filter Count: " + RentfilterCount);
        int sum = Integer.parseInt(RentfilterCount) + Integer.parseInt(filterCount);
//      System.out.println("Total Unit Counts: " + sum);

        clickElement(propertyFilter);

        String locationCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyLocation)).getAttribute("content-desc"));
        totalSectionCount += Integer.parseInt(outerCount);

        backAndSwipeLeft();

        Assert.assertEquals(String.valueOf(sum), outerCount, "Mismatch: Unit filter count does not match listing count.");
//        Assert.assertEquals(locationCount, outerCount, "Mismatch: Property location count does not match listing count.");
    }
    @Test(priority = 4)
    public void VerifyAgriCounts() throws InterruptedException {
            String outerCount = extractFirstNumber(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc, 'Agriculture')]"))).getAttribute("content-desc"));
            System.out.println("Listing Agriculture Count: " + outerCount);

            clickElement(By.xpath("//android.view.View[contains(@content-desc, 'Agriculture')]"));
            Thread.sleep(800);
            String filterCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyFilter)).getAttribute("content-desc"));
            System.out.println("Filter Count: " + filterCount);

            clickElement(propertyFilter);

            String locationCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyLocation)).getAttribute("content-desc"));
            System.out.println("Location Count: " + locationCount);
            totalSectionCount += Integer.parseInt(outerCount);

            backAndSwipeLeft();

            Assert.assertEquals(filterCount, outerCount, "Mismatch: Agri filter count does not match listing count.");
            Assert.assertEquals(locationCount, outerCount, "Mismatch: Agri location count does not match listing count.");
    }
    @Test(priority = 5)
    public void VerifyIndustryCounts() throws InterruptedException {
        String outerCount = extractFirstNumber(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc, 'Industry')]"))).getAttribute("content-desc"));
        System.out.println("Listing Agriculture Count: " + outerCount);

        clickElement(By.xpath("//android.view.View[contains(@content-desc, 'Industry')]"));

        String filterCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyFilter)).getAttribute("content-desc"));
        System.out.println("Filter Count: " + filterCount);
        Thread.sleep(800);
        clickElement(propertyFilter);

        String locationCount = extractFirstNumber(wait.until(ExpectedConditions.visibilityOfElementLocated(propertyLocation)).getAttribute("content-desc"));
        System.out.println("Location Count: " + locationCount);
        totalSectionCount += Integer.parseInt(outerCount);

        backAndSwipeLeft();

        Assert.assertEquals(filterCount, outerCount, "Mismatch: Industry filter count does not match listing count.");
        Assert.assertEquals(locationCount, outerCount, "Mismatch: Industry location count does not match listing count.");
    }
    @Test(priority = 6)
    public void VerifyMapCount() {
        String outerCountStr = extractFirstNumber(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[contains(@content-desc, 'Map')]"))).getAttribute("content-desc"));
        int mapCount = Integer.parseInt(outerCountStr);
        System.out.println("Map Count: " + mapCount);
        System.out.println("Total Section Count: " + totalSectionCount);
        Assert.assertEquals(mapCount, totalSectionCount,
                "Mismatch: Map count does not match the total of all section counts.");
    }
}
