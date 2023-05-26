package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P03_homePage;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class D04_searchStepDefinitions {
    P03_homePage homePage = new P03_homePage(driver);
    SoftAssert assertions = new SoftAssert();



    @When("user could search using product name \"(.*)\"$")
    public void userCouldSearchUsingProductName(String productName) throws InterruptedException {
        homePage.searchBar().sendKeys(productName);
        Thread.sleep(500);
        homePage.searchButton().click();
    }


    @Then("Check the URL contains search?q=")
    public void checkTheURLContainsSearchQ() throws InterruptedException {
        String ActualResult = driver.getCurrentUrl();
        Assert.assertTrue(ActualResult.contains("https://demo.nopcommerce.com/search?q="));
        Thread.sleep(500);
    }

    @Then("search shows relevant results \"(.*)\"$")
    public void searchShowsRelevantResults(String prodName) {
        List<WebElement> search = driver.findElements(By.cssSelector("h2[class=\"product-title\"] a"));
        int count = search.size();
        for (int i = 0; i < search.size(); i++) {
            String productName = search.get(i).getText().toLowerCase();
            assertions.assertTrue(productName.contains(prodName), "element (" + i + ") does not has " + prodName);
        }
        System.out.println(count);
        assertions.assertAll();
    }
    @When("user could search for product using sku \"(.*)\"$")
    public void userCouldSearchForProductUsingSku(String productSku) throws InterruptedException {
        homePage.searchBar().sendKeys(productSku);
        Thread.sleep(500);
        homePage.searchButton().click();
    }

    @And("click on this product")
    public void clickOnThisProduct() throws InterruptedException {
        WebElement SearchSKUResult = driver.findElement(By.cssSelector("h2[class=\"product-title\"] a"));
        Thread.sleep(500);
        SearchSKUResult.click();
    }

    @Then("verify this sku {string} is the retrieved sku")
    public void verifyThisSkuIsTheRetrievedSku(String sku) {
        String expectedResult = sku;
        String actualResult = driver.findElement(By.cssSelector("div[class=\"sku\"]")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
