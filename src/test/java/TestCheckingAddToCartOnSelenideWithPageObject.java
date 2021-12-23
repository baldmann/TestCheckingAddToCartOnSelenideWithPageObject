import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestCheckingAddToCartOnSelenideWithPageObject {
    private final MainPageLogic mainPageLogic = new MainPageLogic();
    private final SearchPageLogic searchPageLogic = new SearchPageLogic();
    private final CartPageLogic cartPageLogic = new CartPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua/");

    }

    @Test
    public void firstTest() {
        mainPageLogic.clickOnCategory(new MainPageElements().compAndLaptopCategory)
                .clickOnCategory(new CategoryPageElements().laptopCategory);
        String firstLaptopName = searchPageLogic.firstProductTitleOnSearchPageText();
        searchPageLogic.clickOnProductCart(new SearchPageElements().addToCartBtn)
                .cartCounterCheck("1")
                .clickOnCart(new SearchPageElements().cartCounter);
        String cartLaptopName = cartPageLogic.cartItemText();
        Assert.assertEquals(cartLaptopName, firstLaptopName);

    }
}
