package dibimbing.tests;

import dibimbing.core.BaseTest;
import dibimbing.core.DriverManager;
import dibimbing.pages.HomePage;
import dibimbing.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final String VALID_USERNAME  = "bod@example.com";
    private static final String VALID_PASSWORD  = "10203040";
    private static final String LOCKED_USERNAME = "alice@example.com";
    private static final String LOCKED_PASSWORD = "10203040";

    @Test(priority = 2, description = "Login berhasil dengan username dan password valid")
    public void testLoginSuccess() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());

        loginPage.clickViewMenu();
        loginPage.clickLoginMenu();

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Halaman Login tidak ditemukan!"
        );

        loginPage.inputUsername(VALID_USERNAME);
        loginPage.inputPassword(VALID_PASSWORD);
        loginPage.clickLoginButton();


        HomePage homePage = new HomePage(DriverManager.getDriver());

        Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Login gagal! Halaman utama tidak tampil."
        );
    }

    @Test(priority = 1, description = "Login gagal dengan akun locked out")
    public void testLoginLockedOut() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());

        loginPage.clickViewMenu();
        loginPage.clickLoginMenu();

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "Halaman Login tidak ditemukan!"
        );

        loginPage.inputUsername(LOCKED_USERNAME);
        loginPage.inputPassword(LOCKED_PASSWORD);
        loginPage.clickLoginButton();

        Assert.assertTrue(
                loginPage.isErrorMessageDisplayed(),
                "Pesan error locked out tidak muncul!"
        );
    }
}