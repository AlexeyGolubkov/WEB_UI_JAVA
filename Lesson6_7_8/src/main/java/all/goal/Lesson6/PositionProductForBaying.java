package all.goal.Lesson6;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PositionProductForBaying extends BaseClassView{
    public PositionProductForBaying(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath ="//button[@class='ty-btn__primary ty-btn__add-to-cart cm-form-dialog-closer ty-btn']")
    // <button id="button_cart_9796" class="ty-btn__primary ty-btn__add-to-cart cm-form-dialog-closer ty-btn" type="submit" name="dispatch[checkout.add..9796]"><span><i class="ut2-icon-outline-cart"></i><span>В корзину</span></span></button>
    private WebElement goingToCartButton;

public WindowsBaying pushCartButton (){
    driver.manage ().window ().setSize (new Dimension(1000, 1000));
    webDriverWait.until(ExpectedConditions.visibilityOf(goingToCartButton));
    actions.moveToElement(goingToCartButton).click().perform();
    return new WindowsBaying(driver);
}
}
