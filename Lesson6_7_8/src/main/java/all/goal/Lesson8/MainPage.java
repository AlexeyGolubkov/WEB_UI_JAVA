package all.goal.Lesson8;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

private SelenideElement strForFind=$(By.id("search_input"));
    private SelenideElement buttonToFind=$(By.xpath("//button[@class='ty-search-magnifier']"));


    public ResultFoundPage clickFindText(String teхtForFind) {

        strForFind.sendKeys(teхtForFind);
        buttonToFind.click();

        return page(ResultFoundPage.class);
    }
}
