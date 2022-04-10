package all.goal.Lesson8;


import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class TeploCityTest {
    @Given("Пользователь не авторизован на сайте и задает поиск коллектор")
    public void clickFindText() {
        Configuration.timeout = 10000;
        //Configuration.headless = true;
        open("http://teplocity.com/");
        new MainPage().clickFindText("коллектор");
    }

    @When("Наводит мышь на первый найденный товар и медленно кликает")
    public void moveToProduct() {
        new ResultFoundPage().moveToProduct();
    }

    @And("Добавляет в корзину первый продукт")
    public void pushCartButton() {
        new PositionProductForBaying().pushCartButton();
    }

    @And("В открывшемся окне кликает кнопку Корзина")
    public void pushCartButtonInWin() {
        new WindowsBaying().pushCartButtonInWin();
    }

    @Then("Проверяем количество товара в корзине равное 1")
    public void checkListOfProduct() {
        new CartPage().checkListOfProduct(1);
    }
}
