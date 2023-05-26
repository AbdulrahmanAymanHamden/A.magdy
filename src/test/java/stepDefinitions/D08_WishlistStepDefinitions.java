package stepDefinitions;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.P03_homePage;

import java.time.Duration;

import static stepDefinitions.Hooks.driver;

public class D08_WishlistStepDefinitions {

    P03_homePage homePage = new P03_homePage(driver);
    SoftAssert assertions = new SoftAssert();

    @When("user click on wishlist button ❤️ on this product {string}")
    public void userClickOnWishlistButton️OnThisProductHTCOneMAndroidLLollipop(String mobile) throws InterruptedException {
        Thread.sleep(1000);
        homePage.AddtoWishlist().click();
    }

    @Then("success message is displayed {string} with green background color")
    public void SuccessMessageIsDisplayedWithGreenBackgroundColor(String expectedResult) throws InterruptedException {
        String actualResult = homePage.AddtoWishlist().getText();
        assertions.assertTrue(actualResult.contains(expectedResult));

        String ActualRes = homePage.AddWishlistSuccessMsg().getCssValue("background-color");
        String c = Color.fromString(ActualRes).asHex();
        System.out.println(c);
        assertions.assertEquals(c,"#4bb07a");
        //assertions.assertAll();

    }

    @And("after the success message disappear, click on Wishlist Tab on the top of the page")
    public void afterTheSuccessMessageWithGreenColorToDisappearClickOnTabOnTheTopOfThePage() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class=\"ico-wishlist\"]")));
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        homePage.GoToWishListPage().click();
    }

    @Then("get Qty value and verify it's bigger than zero")
    public void getQtyValueAndVerifyItSBiggerThanZero() {
        WebElement Qty = driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
        String actualResult = Qty.getAttribute("value");
        int value = Integer.parseInt(actualResult);
        assertions.assertTrue(value>0);
        assertions.assertAll();
    }
}
