package all.goal.Lesson7;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class BaseClassView {
        WebDriver driver;
        WebDriverWait webDriverWait;
        Actions actions;

        public BaseClassView(WebDriver driver) {
            this.driver = driver;
            webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            actions = new Actions(driver);
            PageFactory.initElements(driver, this);
        }
    }


