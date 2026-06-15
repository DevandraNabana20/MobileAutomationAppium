package dibimbing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement cartIcon;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productLabel;

    public boolean isHomePageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Tunggu cartIcon dulu
            wait.until(ExpectedConditions.visibilityOf(cartIcon));

            // Lalu cek productLabel
            wait.until(ExpectedConditions.visibilityOf(productLabel));

            return cartIcon.isDisplayed() && productLabel.isDisplayed();
        } catch (Exception e) {
            System.out.println("HomePage not displayed: " + e.getMessage());
            return false;
        }
    }
}