package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utility.DriverManager;

public class BaseTest {

    protected  WebDriver driver;


    @BeforeMethod
    @Parameters("browser")
    public void LaunchBrowserWindow(String browser){
        driver = new DriverManager().initializeDriver(browser);
    }

    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }

}
