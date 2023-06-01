package checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Cart {
    WebDriver driver;

    WebDriverWait wait;

    public Cart(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='cartur']")
    WebElement cart;

    @FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
    WebElement productMobile;

    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement addToCart;

    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    WebElement placeOrder;

    @FindBy(id = "name")
    WebElement inputName;

    @FindBy(id = "country")
    WebElement inputCountry;

    @FindBy(id = "city")
    WebElement inputCity;

    @FindBy(id = "card")
    WebElement inputCard;

    @FindBy(id = "month")
    WebElement inputMonth;

    @FindBy(id = "year")
    WebElement inputYear;

    @FindBy(css = "button[onclick='purchaseOrder()']")
    WebElement clickPurchase;


    public boolean clickOnCart() {
        wait.until(ExpectedConditions.visibilityOf(productMobile));
        productMobile.click();
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart is not displayed on the PDP.");
        addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
        wait.until(ExpectedConditions.visibilityOf(placeOrder));
        return placeOrder.isDisplayed();
    }

    public void clickOnPlaceOrder() {
        wait.until(ExpectedConditions.visibilityOf(productMobile));
        productMobile.click();
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart is not displayed on the PDP.");
        addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
        wait.until(ExpectedConditions.visibilityOf(placeOrder));
        placeOrder.click();
    }

    public void inputOnPlaceOrder() {
        wait.until(ExpectedConditions.visibilityOf(productMobile));
        productMobile.click();
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart is not displayed on the PDP.");
        addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
        wait.until(ExpectedConditions.visibilityOf(placeOrder));
        placeOrder.click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys("abcde");
        inputCountry.sendKeys("India");
        inputCity.sendKeys("Noida");
        inputCard.sendKeys("123456789012");
        inputMonth.sendKeys("08");
        inputYear.sendKeys("27");
        Assert.assertTrue(clickPurchase.isDisplayed(),"Purchase button is not displayed.");
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.visibilityOf(productMobile));
        productMobile.click();
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart is not displayed on the PDP.");
        addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.visibilityOf(cart));
        cart.click();
        wait.until(ExpectedConditions.visibilityOf(placeOrder));
        placeOrder.click();
        driver.switchTo().activeElement();
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys("abcde");
        inputCountry.sendKeys("India");
        inputCity.sendKeys("Noida");
        inputCard.sendKeys("123456789012");
        inputMonth.sendKeys("08");
        inputYear.sendKeys("27");
        Assert.assertTrue(clickPurchase.isDisplayed(),"Purchase button is not displayed.");
        clickPurchase.click();
    }
}
