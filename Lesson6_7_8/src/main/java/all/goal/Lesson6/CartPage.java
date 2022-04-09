package all.goal.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BaseClassView {


    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@class='ty-value-changer__input cm-amount']")
    private List<WebElement> listProductInCart;


    public boolean checkListOfProduct (int number) {
        webDriverWait.until(ExpectedConditions.visibilityOf(listProductInCart.get(0)));
        if (listProductInCart.size()==number) {return true;}
        return false;
    }
}
