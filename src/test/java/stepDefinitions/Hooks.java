package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.P03_homePage;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    public static P03_homePage homePage;

    @Before
    public static void a_user_opens_chrome_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver  = new ChromeDriver(options);
        homePage = new P03_homePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @After
    public void the_browser_is_closed() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
