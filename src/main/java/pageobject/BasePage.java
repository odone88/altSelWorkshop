package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage{

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void checkAndClick(By by) {
        waitForElement(by);
        click(by);
    }

    public void click(By locator) {
        try{
            driver.findElement(locator).click();
        }
        catch(StaleElementReferenceException e){
            driver.findElement(locator).click();
        }
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void insertText(By locator, String text) {
        waitForElement(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void open(String url){
        driver.get(url);
    }

    protected void mouseOver(By by) {
        waitForElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).build().perform();
    }


}
