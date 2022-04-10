package all.goal.Lesson8;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    private ElementsCollection listProductInCart=$$(By.xpath("//input[@class='ty-value-changer__input cm-amount']"));
    public boolean checkListOfProduct (int number) {
        return listProductInCart.size() == number;
    }
}
