package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import pages.P01_registerPage;
import pages.P03_homePage;

import static stepDefinitions.Hooks.driver;


public class D01_registerStepDefinitions {

    P03_homePage homePage = new P03_homePage(driver);
    P01_registerPage registerPage = new P01_registerPage(driver);
    SoftAssert assertion = new SoftAssert();

    @Given("user go to register page")
    public void UserGoToRegisterPage() throws InterruptedException {
        homePage.GoToRegisterPage();
        Thread.sleep(1000);
    }

    @When("user select gender type")
    public void userSelectGenderType() throws InterruptedException {
        registerPage.genderFemale().click();
        Thread.sleep(500);
    }

    @And("user enter first name and last name")
    public void userEnterFirstNameAndLastName() throws InterruptedException {
        registerPage.firstNameField().sendKeys("automation");
        Thread.sleep(500);
        registerPage.lastNameField().sendKeys("tester");
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() throws InterruptedException{
        registerPage.selectBirthDay();
        Thread.sleep(500);
        registerPage.selectBirthMonth();
        Thread.sleep(500);
        registerPage.selectBirthYear();
        Thread.sleep(500);
    }

    @And("user enter email field")
    public void userEnterEmailField() {
        registerPage.emailRegisterField().sendKeys("testerAana@example.com");
    }

    @And("user fills Password fields")
    public void userFillsPasswordFields() throws InterruptedException{
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        registerPage.passwordRegisterField().sendKeys("P@ssw0rd");
        Thread.sleep(500);
        registerPage.confirmPassword().sendKeys("P@ssw0rd");
    }

    @And("user clicks on register button")
    public void userClicksOnRegisterButton() {
        registerPage.registerButton().click();
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
        String expectedResult = "Your registration completed";
        String actualResult = registerPage.successRegisterationMessage().getText();
        assertion.assertTrue(actualResult.contains(expectedResult));
        /*String ExpectedRes = String.valueOf(Color.fromString("rgba(76, 177, 124, 1)"));*/
        String ActualRes = registerPage.successRegisterationMessage().getCssValue("color");
        String c = Color.fromString(ActualRes).asRgba();
        assertion.assertTrue(c.contains("(76, 177, 124, 1)"));

        assertion.assertAll();
    }

}
