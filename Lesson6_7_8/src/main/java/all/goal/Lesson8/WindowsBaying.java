package all.goal.Lesson8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class WindowsBaying {
    private SelenideElement cartGoingButton=$(By.xpath("//*[contains(@class,'ty-btn ty-btn__primary')]/span[.='Корзина']/."));

    public CartPage pushCartButtonInWin(){

        cartGoingButton.click();

        return page(CartPage.class);
    }
}
