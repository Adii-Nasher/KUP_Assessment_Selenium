package checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Homepage {
    WebDriver driver;

    WebDriverWait wait;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath ="//a[contains(text(),'Laptops')]")
    WebElement productCategory;

    @FindBy(css = "div[class='card h-100']")
    WebElement productLaptop;

    @FindBy(xpath = "//a[@id='nava']")
    WebElement homeLogo;

    public boolean verifyHomeLogo() {
        try {
            wait.until(ExpectedConditions.visibilityOf(homeLogo));
            return homeLogo.isDisplayed();
        } catch (WebDriverException e) {
            // DO nothing
        }
        return false;
    }


    public void verifyProductCategory() {
        wait.until(ExpectedConditions.visibilityOf(productCategory));
        productCategory.click();
        wait.until(ExpectedConditions.visibilityOf(productLaptop));
        Assert.assertTrue(productLaptop.isDisplayed(),"product Laptop is not displayed on Plp");
    }

}
