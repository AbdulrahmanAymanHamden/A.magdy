package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import pages.P02_loginPage;
import pages.P03_homePage;

import static stepDefinitions.Hooks.driver;

public class D02_loginStepDefinitions {

    P03_homePage homePage = new P03_homePage(driver);
    P02_loginPage loginPage = new P02_loginPage(driver);
    SoftAssert assertion = new SoftAssert();

    @Given("user go to login page")
    public void UserGoToLoginPage() throws InterruptedException {
        homePage.GoToLoginPage();
        Thread.sleep(1000);
    }

    @When("user login with valid email{string}")
    public void userLoginWithValidEmailEmail(String Email) throws InterruptedException {
        loginPage.emailLoginField().sendKeys(Email);
        Thread.sleep(500);
    }

    @And("user login with valid password{string}")
    public void userLoginWithValidPassword(String Password) {
        loginPage.passwordLoginField().sendKeys(Password);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        loginPage.loginButton().click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        String ExpectedResult = "https://demo.nopcommerce.com/";
        String ActualResult = driver.getCurrentUrl();
        assertion.assertEquals(ActualResult,ExpectedResult);
        assertion.assertTrue(loginPage.MyAccountTab().isDisplayed());
        assertion.assertAll();
    }


    @When("user login with invalid email{string}")
    public void userLoginWithInvalidEmail(String mail) {
        loginPage.emailLoginField().sendKeys(mail);
    }

    @And("user login with invalid password{string}")
    public void userLoginWithInvalidPassword(String pass) {
        loginPage.passwordLoginField().sendKeys(pass);
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {

        String expectedResult = "Login was unsuccessful";
        String actualResult = loginPage.FailLoginMessage().getText();
        assertion.assertTrue(actualResult.contains(expectedResult));
        /*String ExpectedRes = String.valueOf(Color.fromString("rgba(76, 177, 124, 1)"));*/
        String ActualRes = loginPage.FailLoginMessage().getCssValue("color");
        String c = Color.fromString(ActualRes).asHex();
        assertion.assertEquals(c,"#e4434b");

        assertion.assertAll();
    }



}
