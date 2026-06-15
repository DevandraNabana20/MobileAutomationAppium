package dibimbing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends BasePage {

    public CartPage(AppiumDriver driver) {
        super(driver);
    }

    // ── Locators ─────────────────────────────────────────────────

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartIcon;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productNameInCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement productPriceInCart;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement productQuantityInCart;

    // ── Actions ──────────────────────────────────────────────────

    public void openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cartIcon));
        cartIcon.click();
    }

    // ── Assertion Helpers ─────────────────────────────────────────

    public boolean isProductInCart(String expectedProductName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(productNameInCart));
            return productNameInCart.getText().contains(expectedProductName);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPriceCorrect(String expectedPrice) {
        return productPriceInCart.getText().equals(expectedPrice);
    }

    public boolean isQuantityCorrect(String expectedQuantity) {
        return productQuantityInCart.getText().equals(expectedQuantity);
    }
}