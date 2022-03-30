import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LifeJournal {


    public static void main(String[] args) throws InterruptedException {
        openChromeWebSiteWithCookie("https://livejournal.com/");

    }

    private static void openChromeWebSiteWithCookie(String httpsAddress) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-print-preview");
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.get(httpsAddress);
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

/*        chromeDriver.switchTo().frame(chromeDriver.findElement(By.xpath("//*[@name='lsgetframe']")));
        chromeDriver.findElement(By.xpath("//*[@name='lsgetframe']")).click();
        chromeDriver.switchTo().parentFrame();*/

        chromeDriver.findElement(By.xpath("//a[.='Войти']")).click();
        chromeDriver.switchTo().frame(chromeDriver.findElement(By.id("user")));
 //       chromeDriver.findElement(By.id("user")).click();

        chromeDriver.findElement(By.id("user")).sendKeys("Allgoal");
        chromeDriver.findElement(By.id("lj_loginwidget_password")).sendKeys("0990002aA");
        chromeDriver.findElement(By.xpath("//a[.='Войти']")).click();
        chromeDriver.switchTo().parentFrame();


        Thread.sleep(5000);
        System.out.println();
        //       chromeDriver.navigate().refresh();
        chromeDriver.findElement(By.xpath("//*[@class='s-header-item-post--short']")).click();
        newRecDiary(chromeDriver);
        Thread.sleep(5000);
        chromeDriver.quit();
    }


    private static void newRecDiary(WebDriver driver) {
        Faker faker=new Faker();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='public-DraftStyleDefault-bloc']")));
        String post=faker.lorem().sentence(25,7);
        System.out.println(post);
        driver.findElement(By.xpath("//*[@class='public-DraftStyleDefault-bloc']")).sendKeys(post);
 //
        String postName=faker.funnyName().name() + " with "+faker.name().fullName()+" "+faker.animal().name()+" "+faker.artist().name();
        System.out.println(postName);
        driver.findElement(By.id("content")).click();
        driver.findElement(By.id("content")).sendKeys(post);



        driver.findElement(By.xpath("/html/body/div[10]/footer/div/div/div[2]/div[2]/button")).click();

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        //       driver.switchTo().parentFrame();
        System.out.println();
        List<WebElement> posts = driver.findElements(By.xpath("//a[@class='title']"));
        posts.stream().filter(p -> p.getText().contains(postName)).findFirst().get().click();
        driver.findElement(By.xpath("//*[@class='name_likes']")).click();

    };

}
