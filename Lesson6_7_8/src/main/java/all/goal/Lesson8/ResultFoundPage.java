package all.goal.Lesson8;

import com.codeborne.selenide.ElementsCollection;

import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class ResultFoundPage {

   // private List<SelenideElement> foundList = $$(By.xpath("//img[contains(@class,'ls-is-cached')]/."));
private ElementsCollection foundList = $$(By.xpath("//img[contains(@class,'ls-is-cached')]/."));


    public PositionProductForBaying moveToProduct() {
        foundList.get(0).click();

        return page(PositionProductForBaying.class);

    }
}