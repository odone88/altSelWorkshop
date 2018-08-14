import org.junit.Assert;
import org.junit.Test;
import pageobject.CartPage;
import pageobject.MainPage;
import pageobject.ViewPage;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneralTests extends BaseTest{

    private final String AUTOMATION_WEBSITE = "http://automationpractice.com";


    @Test
    public void shouldUserSearchForElement(){
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.open(AUTOMATION_WEBSITE);
        mainPage.searchForText("Faded");
        Assert.assertTrue(mainPage.checkIfSearchingElementPresent());
    }

    @Test
    public void shouldUserAddBlouseToTheCart(){
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.open(AUTOMATION_WEBSITE);
        CartPage cartPage = mainPage.addBlouseToCart();
        Assert.assertEquals("Item was not added to the cart. Please investigate.","Product successfully added to your shopping cart",cartPage.getSuccessElementText());
        cartPage.clickOnProceedPage();
        Assert.assertEquals("Number of bought items is not proper. Please investigate.","1",cartPage.getQuantityOfBoughtElements());
    }

    @Test
    public void shouldUserBuyTwoDresses(){
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.open(AUTOMATION_WEBSITE);
        mainPage.searchForText("Printed Dress");
        assertThat(mainPage.getDress().isDisplayed()).as("Given Dress is displayed").isTrue();
        ViewPage viewPage = mainPage.viewDress();
        CartPage cartPage = viewPage.addDressToCart();
        Assert.assertEquals("Item was not added to the cart. Please investigate.","Product successfully added to your shopping cart",cartPage.getSuccessElementText());
        cartPage.clickOnProceedPage();
        Assert.assertEquals("Price of cart is not proper. Please check it.",true,cartPage.getPriceOfCart().contains("32.80"));
        Assert.assertEquals("Number of bought items is not proper. Please investigate.","2",cartPage.getQuantityOfBoughtElements());

    }





}
