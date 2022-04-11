package all.goal.Lesson7;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BaseClassView {


    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "search_input")
    //<input type="text" name="q" value="" id="search_input" title="Искать товары" class="ty-search-block__input" data-cur-placeholder-string="циркуляционный насос" placeholder="циркуляционный насо">
    public WebElement strForFind;

@FindBy(xpath= "//button[@class='ty-search-magnifier']")
//<button title="Найти" class="ty-search-magnifier" type="submit"><i class="ut2-icon-search"></i></button>
public WebElement buttonToFind;

@Step("Без авторизации задаём поиск по слову 'коллектор'")
public ResultFoundPage clickFindText(String teхtForFind) {
        webDriverWait.until(ExpectedConditions.visibilityOf(strForFind));
        strForFind.sendKeys(teхtForFind);
        buttonToFind.click();

        return new ResultFoundPage(driver);
    }
}
