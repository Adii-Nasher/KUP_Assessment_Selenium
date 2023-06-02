package checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Setup {

    WebDriver driver;
    Homepage homepage;

    PDP pdp;

    Cart cart;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();

        homepage = new Homepage(driver);

        pdp = new PDP(driver);

        cart = new Cart(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void verifyProduct() {
        pdp.verifyProductIsSameOnPDP();
    }

    @Test (dependsOnMethods = "verifyProduct")
    public void verifyHomeLogo() {
        homepage.verifyHomeLogo();
    }

    @Test (dependsOnMethods = "verifyHomeLogo")
    public void verifyProductPrice() {
        pdp.verifyProductPriceIsListedOnPDP();
    }

    @Test (dependsOnMethods = "verifyProductPrice")
    public void verifyProductDescription() {
        pdp.verifyProductDescriptionOnPDP();
    }

    @Test (dependsOnMethods = "verifyProductDescription")
    public void verifyAddToCart() {
        pdp.verifyAddToCart();
    }

    @Test (dependsOnMethods = "verifyAddToCart")
    public void verifyProductCategory() {
        homepage.verifyProductCategory();
    }

    @Test (dependsOnMethods = "verifyProductCategory")
    public void verifyItemInCart() {
        cart.clickOnCart();
    }

    @Test (dependsOnMethods = "verifyItemInCart")
    public void verifyPlaceOrderButton() {
        cart.clickOnPlaceOrder();
    }

    @Test (dependsOnMethods = "verifyPlaceOrderButton")
    public void verifyPlaceOrderInput() {
        cart.inputOnPlaceOrder();
    }

    @Test (dependsOnMethods = "verifyPlaceOrderInput")
    public void verifyPlaceOrder() {
        cart.placeOrder();
    }
}
