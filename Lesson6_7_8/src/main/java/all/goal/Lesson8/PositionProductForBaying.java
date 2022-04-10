package all.goal.Lesson8;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PositionProductForBaying {
    private SelenideElement goingToCartButton=$(By.xpath("//button[@class='ty-btn__primary ty-btn__add-to-cart cm-form-dialog-closer ty-btn']"));

    public WindowsBaying pushCartButton (){
     //   driver.manage ().window ().setSize (new Dimension(1000, 1000));
        goingToCartButton.hover().click();
        return page(WindowsBaying.class);
    }
}
