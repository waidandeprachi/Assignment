package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ItemDetailPage extends BasePage {

    public ItemDetailPage(WebDriver driver) {
        super(driver);
    }

    By addToCartButton = By.xpath("//div[@data-csa-c-content-id='addToCart']//input[@type='submit']");
    By goToCartButton = By.xpath("//span[contains(@class,'cart-button')]");
    By quantity = By.xpath("//span[@id=\"a-autoid-0-announce\"]");
    By quantityValue = By.xpath("//a[@id='quantity_3']");
    By proceedToBuyButton = By.xpath("//input[@name='proceedToRetailCheckout']");

    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
    }

    public void clickOnGoToCartButton(){
        clickOnElement(goToCartButton);
    }

    public void selectQuantity(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(quantity)).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement visibleText = driver.findElement(quantityValue);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",visibleText);
        visibleText.click();
    }

    public void clickOnProceedToBuy(){
        clickOnElement(proceedToBuyButton);
    }
}
