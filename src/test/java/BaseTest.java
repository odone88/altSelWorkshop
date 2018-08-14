
import org.junit.After;


import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }


}
