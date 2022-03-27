import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestGB {
    @Test
    public void openSiteWithCookie (){
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://gb.ru");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        chromeDriver.manage().addCookie(new Cookie("user_id", "d1VqT3JHb3BSRVpnSFRZWG9xNk4yUT09LS1mMEVwMVZCMDU4N3VZZmswQWlPNXh3PT0%"+
                "3D--e1b152c4f84fd367a8e1bbce224eb817e2d3abb0"));

        chromeDriver.manage().addCookie(new Cookie("jwt_token","LCJleHAiOjE2NTA4NjcxNjUsImF1dGhlbnRpY2F0YWJsZV9zYWx0IjoiJDJhJDExJERWcTZGdzA4TEh"+
                "xbDEuREYxRHRLZnUiLCJyb2xlcyI6WyJ1c2VyIl19.WwtVb3oD5sto2lNu"));
        chromeDriver.navigate().refresh();
        chromeDriver.quit();

    }
}
