package checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PDP {
    WebDriver driver;

    WebDriverWait wait;

    public PDP(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
    WebElement productMobile;

    @FindBy(css = "h2[class='name']")
    WebElement productTitle;

    @FindBy(css = "h3[class='price-container']")
    WebElement productPrice;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement productDes;

    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    WebElement addToCart;

    public void verifyProductIsSameOnPDP() {
        wait.until(ExpectedConditions.visibilityOf(productMobile));
        productMobile.click();
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        Assert.assertTrue(productTitle.isDisplayed(), "Product title is not displayed on the PDP.");
    }

    public void verifyProductPriceIsListedOnPDP() {
        wait.until(ExpectedConditions.visibilityOf(productMobile));
        productMobile.click();
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed on the PDP.");
    }

    public void verifyProductDescriptionOnPDP() {
        wait.until(ExpectedConditions.visibilityOf(productMobile));
        productMobile.click();
        wait.until(ExpectedConditions.visibilityOf(productDes));
        Assert.assertTrue(productDes.isDisplayed(), "Product Description is not displayed on the PDP.");
    }

    public void verifyAddToCart() {
        wait.until(ExpectedConditions.visibilityOf(productMobile));
        productMobile.click();
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart is not displayed on the PDP.");
        addToCart.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

