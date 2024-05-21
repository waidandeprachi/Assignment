package utility;

import constant.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    public WebDriver initializeDriver(String browser)
    {
        WebDriver webDriver;
        switch (BrowserType.valueOf(browser)){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver=new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver=new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Incorrect browser name:"+browser);
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return  webDriver;
    }
}
