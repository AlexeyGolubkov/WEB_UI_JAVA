package all.goal.Lesson7;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

@Story("Теплосити-стори")
public class TeploCityTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registrationDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver(){
 
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        
        driver.get("https://teplocity.com");

    }

@Feature("Добавление товара в корзину - фича")
    @Test
    void addToCart(){
        MainPage mainPage = new MainPage(driver);

       Assertions.assertTrue
                          ( mainPage.clickFindText("коллектор")
                                    .moveToProduct()
                                    .pushCartButton()
                                    .pushCartButtonInWin()
                                    .checkListOfProduct(1));


    }
    @AfterEach
    void tearDown() {
        LogEntries logEntries=driver.manage().logs()
.get(LogType.BROWSER);

for(LogEntry log: logEntries){
Allure.addAttachment("Лог бага:", log.getMessage());
}
        driver.quit();
    }
}
