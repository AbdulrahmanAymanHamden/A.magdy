package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.Hooks;

public class P01_registerPage {
    WebDriver driver;

    public WebElement genderMale(){
        return driver.findElement(By.cssSelector("input[id=\"gender-male\"]"));
    }

    public WebElement genderFemale(){
        return driver.findElement(By.cssSelector("input[id=\"gender-female\"]"));
    }

    public WebElement firstNameField(){
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement lastNameField(){
        return driver.findElement(By.id("LastName"));
    }

    /*
    public WebElement birthDayDropDown(){
        return driver.findElements(By.name("DateOfBirthDay"));
    }

    public WebElement birthMonthDropDown(){
        return driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement birthYearDropDown(){
        return driver.findElement(By.name("DateOfBirthYear"));
    }
    */


    public WebElement emailRegisterField(){
        return driver.findElement(By.id("Email"));
    }

    public WebElement passwordRegisterField(){
        return driver.findElement(By.id("Password"));
    }
    public WebElement confirmPassword(){
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerButton(){
        return driver.findElement(By.id("register-button"));
    }
    public WebElement successRegisterationMessage(){
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }


    By birthDayDropDown = By.name("DateOfBirthDay");
    By birthMonthDropDown = By.name("DateOfBirthMonth");
    By birthYearDropDown = By.name("DateOfBirthYear");

    public P01_registerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectBirthDay(){
        Select dayDropdown = new Select(driver.findElement(birthDayDropDown));
        dayDropdown.selectByValue("2");
    }
    public void selectBirthMonth(){
        Select monthDropdown = new Select(driver.findElement(birthMonthDropDown));
        monthDropdown.selectByValue("12");
    }
    public void selectBirthYear(){
        Select yearDropdown = new Select(driver.findElement(birthYearDropDown));
        yearDropdown.selectByValue("1999");
    }

    /* By genderMale = By.cssSelector("input[id=\"gender-male\"]");
    By genderFemale = By.cssSelector("input[id=\"gender-female\"]");
    By firstNameField = By.id("FirstName");
    By lastNameField = By.id("LastName");
    By birthDayDropDown = By.name("DateOfBirthDay");
    By birthMonthDropDown = By.name("DateOfBirthMonth");
    By birthYearDropDown = By.name("DateOfBirthYear");
    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By successMessage = By.cssSelector("div[class=\"result\"]");

    public WebElement successRegisterationMessage(){
        return driver.findElement(By.cssSelector("div[class=\"result\"]"));
    }


    public P01_registerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ChooseMale() throws InterruptedException{
        driver.findElement(genderMale).click();
        Thread.sleep(1000);
    }
    public void chooseFemale() {
        driver.findElement(genderFemale).click();
    }
    public void enterFirstName(){
        driver.findElement(firstNameField).sendKeys("automation");
    }
    public void enterLastName(){
        driver.findElement(lastNameField).sendKeys("tester");
    }

    public void enterEmail(){
        driver.findElement(emailField).sendKeys("testRanaA@example.com");
    }

    public void enterPassword(){
        driver.findElement(passwordField).sendKeys("P@ssw0rd");
    }

    public void enterConfirmPassword(){
        driver.findElement(confirmPassword).sendKeys("P@ssw0rd");
    }

    public void clickOnRegisterButton(){
        driver.findElement(registerButton).click();
    }*/




}
