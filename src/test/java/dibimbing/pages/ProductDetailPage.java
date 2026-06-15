package dibimbing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(AppiumDriver driver) {
        super(driver);
    }

    // ── Locators ─────────────────────────────────────────────────

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productIV")
    private WebElement productImage;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement productPrice;

    @AndroidFindBy(accessibility = "Tap to add product to cart")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantityNumber;

    @AndroidFindBy(accessibility = "Increase item quantity")
    private WebElement increaseButton;

    @AndroidFindBy(accessibility = "Decrease item quantity")
    private WebElement decreaseButton;

    // Cart icon yang berubah idnya setelah produk ditambahkan
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement cartIcon;

    // ── Actions ──────────────────────────────────────────────────

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void increaseQuantity() {
        increaseButton.click();
    }

    public void decreaseQuantity() {
        decreaseButton.click();
    }

    // ── Assertion Helpers ─────────────────────────────────────────

    public boolean isDetailPageDisplayed() {
        return productTitle.isDisplayed()
                && productImage.isDisplayed()
                && productPrice.isDisplayed();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getQuantity() {
        return quantityNumber.getText();
    }

    public boolean isCartIconUpdated() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(cartIcon));
            return cartIcon.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}