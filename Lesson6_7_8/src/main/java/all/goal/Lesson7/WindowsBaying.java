package all.goal.Lesson7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowsBaying extends BaseClassView {
    public WindowsBaying(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//*[contains(@class,'ty-btn ty-btn__primary')]/span[.='Корзина']/.")

    //<a href="https://teplocity.com/cart/" class="ty-btn ty-btn__primary "><span>Корзина</span></a>

    private WebElement cartGoingButton;

   @Step("В открывшемся окне кликаем кнопку Корзина")
    public CartPage pushCartButtonInWin(){
        webDriverWait.until(ExpectedConditions.visibilityOf(cartGoingButton));
       // driver.switchTo().frame(cartGoingButton);
        actions.moveToElement(cartGoingButton).click().perform();
        //  driver.switchTo().parentFrame();
        System.out.println();
        return new CartPage(driver);
    }
}
