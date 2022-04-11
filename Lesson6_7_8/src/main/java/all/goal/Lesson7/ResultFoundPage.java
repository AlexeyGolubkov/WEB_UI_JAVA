package all.goal.Lesson7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ResultFoundPage extends BaseClassView {
    public ResultFoundPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//img[contains(@class,'ls-is-cached')]/.")
    //<img class="ty-pict     cm-image ls-is-cached lazyloaded" alt="Заглушка внутренняя полипропиленовая 20 сер. HEISSKRAFT, фото " title="Заглушка внутренняя полипропиленовая 20 сер. HEISSKRAFT, фото " src="https://teplocity.com/images/ab__webp/thumbnails/270/270/detailed/1/c99e1cc0eb6a11e59fc9525400ab8105_caf01adebabc11e6e490525400ca329b.jpg.webp" lazy_load_disabled="" id="det_img_9796desktop" width="270" height="270">
    private List<WebElement> foundList;

@Step("Наводим мышь на первый найденный товар и медленно кликаем")
    public PositionProductForBaying moveToProduct() {
        webDriverWait.until(ExpectedConditions.visibilityOf(foundList.get(0)));

        actions.moveToElement(foundList.get(0)).click().perform();
        //foundList.get(0).click();
       //                  .moveToElement(listCart.get(0));
        return new PositionProductForBaying(driver);
    }

}
