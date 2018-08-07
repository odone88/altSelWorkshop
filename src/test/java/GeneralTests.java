import org.junit.Assert;
import org.junit.Test;
import pageobject.CartPage;
import pageobject.MainPage;

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
        CartPage cartPage = mainPage.addToCart();
        Assert.assertEquals("Item was not added to the cart. Please investigate.","Product successfully added to your shopping cart",cartPage.getSuccessElementText());
        cartPage.clickOnProceedPage();
        Assert.assertEquals("Number of bought items is not proper. Please investigate.","1",cartPage.getQuantityOfBoughtElements());
    }




}
