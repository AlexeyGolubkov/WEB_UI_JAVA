//import com.github.javafaker.Lorem;
//import com.thedeanda.lorem.Lorem;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;

import java.time.Duration;
import java.util.List;

public class Main {



    public static void main(String[] args) throws InterruptedException {
        openChromeWebSiteWithCookie("https://diary.ru/");

            }

    private static void openChromeWebSiteWithCookie(String httpsAddress) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-print-preview");
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get(httpsAddress);

        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        chromeDriver.manage().addCookie(
                new Cookie("_identity_", "9029d4ef0363fd4e3d9341bcabf908f8753d67e1da03b2b8e44c9d43cb10e87ba" +
                        "%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3565055%2C%22bWR-nMSwqAh4X3VNGa4p" +
                        "d87L9uL6CZOs%22%2C2592000%5D%22%3B%7D"));

        chromeDriver.navigate().refresh();
        chromeDriver.findElement(By.xpath("//a[@title='Новая запись']")).click();
        newRecDiary(chromeDriver);
        Thread.sleep(5000);
        chromeDriver.quit();
    }


    private static void newRecDiary(WebDriver driver) {
        Faker faker=new Faker();
        String postName=faker.funnyName().name() + " with "+faker.name().fullName()+" "+faker.animal().name()+" "+faker.artist().name();
        System.out.println(postName);

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postTitle")));

        driver.findElement(By.id("postTitle")).sendKeys(postName);
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));

        String post=faker.lorem().sentence(25,7);
                //artist().name()+" "+faker.animal().name()+ " "+faker.aquaTeenHungerForce().character()+" "+faker.ancient().hero()+".";

        driver.findElement(By.id("tinymce")).click();
        driver.findElement(By.id("tinymce")).sendKeys(post);

        driver.switchTo().parentFrame();

        driver.findElement(By.id("rewrite")).click();

        List<WebElement> posts = driver.findElements(By.xpath("//a[@class='title']"));
        posts.stream().filter(p -> p.getText().contains(postName)).findFirst().get().click();
        driver.findElement(By.xpath("//*[@class='name_likes']")).click();

    };

    }
