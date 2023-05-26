package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static stepDefinitions.Hooks.driver;

public class P02_loginPage {

    WebDriver driver;

    public WebElement emailLoginField(){
        return driver.findElement(By.id("Email"));
    }

    public WebElement passwordLoginField(){
        return driver.findElement(By.id("Password"));

    }

    public WebElement loginButton(){
        return driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }

    public WebElement rememberMeCheck(){
        return driver.findElement(By.cssSelector("for=\"RememberMe\""));
    }

    public WebElement forgetPassword(){
        return driver.findElement(By.cssSelector("span[class=\"forgot-password\"]"));
    }

    public WebElement MyAccountTab(){
        return driver.findElement(By.cssSelector("a[href=\"/customer/info\"]"));
    }

    public WebElement FailLoginMessage(){
        return driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }




    public P02_loginPage(WebDriver driver) {
        this.driver = driver;
    }
}
