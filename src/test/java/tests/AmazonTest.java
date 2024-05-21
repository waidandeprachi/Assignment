package tests;

import base.BaseTest;
import pages.HomePage;
import pages.ItemDetailPage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonTest extends BaseTest {


    @Test
    public void searchItem(){
        String searchText = "iPhone 13";
        driver.get("https://amazon.in");
        HomePage homePage=new HomePage(driver);
        ItemDetailPage itemDetailPage = new ItemDetailPage(driver);

        homePage.enterTextIntoSearchField(searchText);
        homePage.clickOnSearchButton();

        //Select filter dropdown
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homePage.clickOnSortByDropDown();
        homePage.clickOnLowToHighFilter();
        homePage.clickOnFirstItemOfResultList();
        homePage.getCurrentTab();
        itemDetailPage.clickOnAddToCartButton();
        itemDetailPage.clickOnGoToCartButton();
        itemDetailPage.selectQuantity();
        itemDetailPage.clickOnProceedToBuy();
    }
}
