package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    protected void waitForElementAndClick(By by){
        waitForElementAndReturn(by, 15);
        click(by);
    }

    public void click(By locator) {
        try{
            waitForElement(locator);
            driver.findElement(locator).click();
        }
        catch(StaleElementReferenceException e){
            driver.findElement(locator).click();
        }
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
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

    public void chooseItemFromDropDownByName(By dropdownLocator, String name){
        waitForElementAndReturn(dropdownLocator, 20);
        new Select(driver.findElement(dropdownLocator)).selectByVisibleText(name);
    }

    public WebElement waitForElementAndReturn(By locator, int timeoutInSeconds){ WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds); wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    return driver.findElement(locator); }


}
