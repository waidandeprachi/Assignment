package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickOnElement(By elementLocator){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement webElement =  wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.click();
    }
}
