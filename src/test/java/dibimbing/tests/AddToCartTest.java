package dibimbing.tests;

import dibimbing.core.BaseTest;
import dibimbing.core.DriverManager;
import dibimbing.pages.CartPage;
import dibimbing.pages.ProductDetailPage;
import dibimbing.pages.ProductListPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    private static final String PRODUCT_NAME  = "Sauce Labs Backpack (yellow)";
    private static final String PRODUCT_PRICE = "$ 29.99";
    private static final String QUANTITY      = "1";

    @Test(description = "Add Sauce Labs Backpack Yellow to cart")
    public void testAddYellowBackpackToCart() {

        // ── Step 1: Scroll & klik produk di list ─────────────────
        ProductListPage productListPage = new ProductListPage(DriverManager.getDriver());

        Assert.assertTrue(
                productListPage.isYellowBackpackDisplayed(),
                "Produk Yellow Backpack tidak ditemukan di list!"
        );

        productListPage.clickYellowBackpack();

        // ── Step 2: Assert halaman detail produk ─────────────────
        ProductDetailPage detailPage = new ProductDetailPage(DriverManager.getDriver());

        Assert.assertTrue(
                detailPage.isDetailPageDisplayed(),
                "Halaman detail produk tidak tampil!"
        );
        Assert.assertEquals(
                detailPage.getProductTitle(),
                PRODUCT_NAME,
                "Judul produk tidak sesuai!"
        );
        Assert.assertEquals(
                detailPage.getProductPrice(),
                PRODUCT_PRICE,
                "Harga produk tidak sesuai!"
        );
        Assert.assertEquals(
                detailPage.getQuantity(),
                QUANTITY,
                "Quantity awal seharusnya 1!"
        );

        // ── Step 3: Klik Add to Cart ──────────────────────────────
        detailPage.clickAddToCart();

        // ── Step 4: Buka cart & validasi produk ada di dalam ──────
        CartPage cartPage = new CartPage(DriverManager.getDriver());
        cartPage.openCart();

        Assert.assertTrue(
                cartPage.isProductInCart(PRODUCT_NAME),
                "Produk tidak ditemukan di cart!"
        );
        Assert.assertTrue(
                cartPage.isPriceCorrect(PRODUCT_PRICE),
                "Harga produk di cart tidak sesuai!"
        );
        Assert.assertTrue(
                cartPage.isQuantityCorrect(QUANTITY),
                "Quantity produk di cart tidak sesuai!"
        );
    }
}