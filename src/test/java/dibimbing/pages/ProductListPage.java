package dibimbing.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage extends BasePage {

    public ProductListPage(AppiumDriver driver) {
        super(driver);
    }

    // ── Actions ──────────────────────────────────────────────────

    public void clickYellowBackpack() {
        // Scroll sekaligus klik elemen yang ditemukan
        WebElement yellowBackpack = driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productIV\").instance(3))"
                )
        );
        yellowBackpack.click();
    }

    // ── Assertion Helper ─────────────────────────────────────────

    public boolean isYellowBackpackDisplayed() {
        try {
            WebElement title = driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))" +
                                    ".scrollIntoView(new UiSelector().text(\"Sauce Labs Backpack (yellow)\"))"
                    )
            );
            return title.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}