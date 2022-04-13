package all.goal.Lesson6;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
        driver =new ChromeDriver();
        driver.get("https://teplocity.com");

    }



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
        System.out.println();
        driver.quit();
    }
}
