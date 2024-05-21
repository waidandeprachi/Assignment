package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }


    By searchBar=By.xpath("//input[@id='twotabsearchtextbox']");
    By searchButton=By.xpath("//input[@value='Go']");
    By sortByDropDown = By.xpath("//span[@class='a-dropdown-container']");
    By lowToHighOption = By.xpath("//a[contains(text(),\"Price: Low to High\")]");
    By firstResultItem = By.xpath("(//span[text()='Results']/ancestor::div[6]//h2//a[contains(@class,'s-underline-text')])[1]");


    public void enterTextIntoSearchField(String text) {
        driver.findElement(searchBar).sendKeys(text);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickOnSortByDropDown(){
        clickOnElement(sortByDropDown);
    }

    public void clickOnLowToHighFilter(){
        clickOnElement(lowToHighOption);
    }

    public void clickOnFirstItemOfResultList(){
        clickOnElement(firstResultItem);
    }

    public void getCurrentTab(){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
}
