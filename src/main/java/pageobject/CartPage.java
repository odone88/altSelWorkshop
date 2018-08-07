package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    By SUCCESS_ELEMENT = By.xpath("//div[starts-with(@class, 'layer_cart_product')]//h2");

    By PROCEED_BTN = By.xpath("//*[contains(text(), 'Proceed')]");

    By QUANTITY_ELEMENT = By.cssSelector("[class*='cart_quantity_input']");


    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getSuccessElementText(){
        waitForElement(SUCCESS_ELEMENT);
        return driver.findElement(SUCCESS_ELEMENT).getText();
    }

    public CartPage clickOnProceedPage(){
        checkAndClick(PROCEED_BTN);
        return new CartPage(driver, wait);
    }

    public String getQuantityOfBoughtElements(){
        waitForElement(QUANTITY_ELEMENT);
        return driver.findElement(QUANTITY_ELEMENT).getAttribute("value");
    }


}
