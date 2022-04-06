import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class GeekBrainsSiteTest {
    final String courseWebUI = "//img [@alt='Автоматизация тестирования Web UI на Java']";
    final String buttonMyEducation = "//a[@class='mn-btn-default']";
    final String listLessons="//a[contains(@class,'lesson-header')]";
    final String checkingTitle="//div[@class='title-block']/h3";
    WebDriver chromeDriver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String PREM_BASE_URL = "https://gb.ru";

    @BeforeAll

    static void registerDriver() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-print-preview");
        chromeDriver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        actions = new Actions(chromeDriver);
        chromeDriver.get(PREM_BASE_URL);

        chromeDriver.manage().addCookie(new Cookie("user_id", "SkRsNmRNcXlqY0lTc1Q2QTN1b3VnZz09LS04ajR6aTJsVzdGeS9" +
                "ENUszOXl2cUJ3PT0%3D--87ddbbd1245493bee0945d70c3b4a57fcacc7877"));

        chromeDriver.manage().addCookie(new Cookie("jwt_token", "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJnZWVrYnJhaW5zIiwia" +
                "WF0IjoxNjQ5MjYwOTc4LCJhdWQiOlsiYWNjZXNzIl0sInVzZXJfaWQiOjcwMDI4ODcsInVwZiI6IndpbmRvd3MiLCJleHAiOj" +
                "E2NTE4NTI5NzgsImF1dGhlbnRpY2F0YWJsZV9zYWx0IjoiJDJhJDExJERWcTZGdzA4TEhxbDEuREYxRHRLZnUiLCJyb2xlcyI" +
                "6WyJ1c2VyIl19.tbvEDXoAG-h3qbvJV4IVVWY3_r5J1GlT49YOAXPlIF8WFH8YYeFK4Fvi4jTkFuNbef_t7NzxDvZO0Lgq3aN" +
                "I4O_3Dn42LKkYuLUwp5ine6lCVoAqGg6in8mSh6bTho9XmqBF_Giu7vUwIR7UPEDiL8G-OsCE280w4KRRDw8POcfr4WwOQU1E" +
                "uiWgoMv3DJ4P8YFhknz87CgTnWHRWPuAYJa7UXAWzL4S_HyG48P4lbObAsopGw4laQx8l4ursjPHcYNRMhvcASU1zD6Il85Or" +
                "T3h7KnjgXvrql_IYgJcp5CKolEUjTpNm48pOKQ8y_YOMHR5gntDBCy5JB_SiTUW5Q"));
        chromeDriver.navigate().refresh();
        System.out.println();
    }


    @Test
    void checkLesson5WebUITest() {


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(buttonMyEducation)));
        chromeDriver.findElement(By.xpath(buttonMyEducation)).click();

        chromeDriver.findElement(By.xpath(courseWebUI)).click();


        System.out.println();
        List<WebElement> lessonsList = chromeDriver.findElements(By.xpath(listLessons));
        lessonsList.get(4).click();


        Assertions.assertEquals(chromeDriver.findElement(By.xpath(checkingTitle)).getText(), "Урок 5. Основы Selenium - часть 2");

    }

    @AfterEach
    void tearDown() {
        chromeDriver.quit();
    }

}


