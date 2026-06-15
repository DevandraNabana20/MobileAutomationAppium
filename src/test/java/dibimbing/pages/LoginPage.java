package dibimbing.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // ── Constructor ──────────────────────────────────────────────
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    // ── Locators ─────────────────────────────────────────────────
    @AndroidFindBy(accessibility = "View menu")
    private WebElement viewMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    private WebElement loginMenu;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginTV")
    private WebElement loginText;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/nameET")
    private WebElement nameField;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordET")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Tap to login with given credentials")
    private WebElement loginButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/passwordErrorTV")
    private WebElement errorMessage;

    // ── Action Methods ───────────────────────────────────────────
    public void clickViewMenu() {
        viewMenu.click();
    }

    public void clickLoginMenu() {
        loginMenu.click();
    }

    public void inputUsername(String username) {
        nameField.clear();
        nameField.sendKeys(username);
    }

    public void inputPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    // ── Assertion Helper ─────────────────────────────────────────
    public boolean isLoginPageDisplayed() {
        return loginText.isDisplayed();
    }
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}