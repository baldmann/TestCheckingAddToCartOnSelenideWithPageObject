import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;


public class SearchPageLogic extends SearchPageElements {

    public String firstProductTitleOnSearchPageText() {
        return firstProductTitleOnSearchPage.text();
    }

    public SearchPageLogic clickOnProductCart(SelenideElement addToCartBtn) {
        addToCartBtn.shouldBe(Condition.visible).click();
        return this;
    }

    public SearchPageLogic cartCounterCheck(String counter) {
        cartCounter.innerText();
        cartCounter.shouldHave(Condition.text(counter));
        return this;
    }

    public CartPageLogic clickOnCart(SelenideElement cartCounter) {
        cartCounter.shouldBe(Condition.visible).click();
        return page(CartPageLogic.class);
    }
}
