package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{


    public static final By SEARCH_TXT = By.cssSelector("[id='search_query_top']");

    public static final By SEARCH_BTN = By.cssSelector("[name='submit_search']");

    public static final By CONTAINS_FADED = By.xpath("//*[contains(text(), 'Faded Short')]");

    public static final By BLOUSE_IMG = By.cssSelector("img[title='Blouse']");

    public static final By ADD_TO_CART_BTN = By.cssSelector("a[data-id-product='2']");





    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public MainPage searchForText(String text){
        insertText(SEARCH_TXT, text);
        checkAndClick(SEARCH_BTN);
        return this;
    }

    public boolean checkIfSearchingElementPresent(){
        return isElementPresent(CONTAINS_FADED);
    }

    public CartPage addToCart(){
        mouseOver(BLOUSE_IMG);
        checkAndClick(ADD_TO_CART_BTN);
        return new CartPage(driver, wait);
    }





}
