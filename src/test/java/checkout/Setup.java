package checkout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {

    WebDriver driver;
    Homepage homepage;

    PDP pdp;

    Cart cart;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();

        homepage = new Homepage(driver);

        pdp = new PDP(driver);

        cart = new Cart(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void verifyProductTest() {
        pdp.verifyProductIsSameOnPDP();
    }

    @Test
    public void verifyHomeLogo() {
        homepage.verifyHomeLogo();
    }

    @Test
    public void verifyProductPrice() {
        pdp.verifyProductPriceIsListedOnPDP();
    }

    @Test
    public void verifyProductDescription() {
        pdp.verifyProductDescriptionOnPDP();
    }

    @Test
    public void verifyAddToCart() {
        pdp.verifyAddToCart();
    }

    @Test
    public void verifyProductCategory() {
        homepage.verifyProductCategory();
    }

    @Test
    public void verifyItemInCart() {
        cart.clickOnCart();
    }

    @Test
    public void verifyPlaceOrderButton() {
        cart.clickOnPlaceOrder();
    }

    @Test
    public void verifyPlaceOrderInput() {
        cart.inputOnPlaceOrder();
    }

    @Test
    public void verifyPlaceOrder() {
        cart.placeOrder();
    }
}
