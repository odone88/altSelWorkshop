package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewPage extends BasePage {

    public static By addToCartButton = By.cssSelector("[name='Submit'] span");

    public static By iconPlus = By.cssSelector(".icon-plus");

    public static By size = By.id("group_1");






    public ViewPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }



    public CartPage addDressToCart(){
        chooseItemFromDropDownByName(size, "M");
        waitForElementAndClick(iconPlus);
        checkAndClick(addToCartButton);
        return new CartPage(driver, wait);
    }





}
