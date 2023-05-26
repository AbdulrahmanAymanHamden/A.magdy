package stepDefinitions;
import io.cucumber.java.bs.A;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.P03_homePage;
import java.util.List;
import static stepDefinitions.Hooks.driver;

public class D03_CurrenciesStepDefinitions {
 P03_homePage homePage = new P03_homePage(driver);
 JavascriptExecutor js = (JavascriptExecutor) driver;
 @When("Select Euro currency from the dropdown list on the top left of home page")
   public void SelectEuroCurrencyFromTheDropdownListOnTheTopLeftOfHomePage() throws InterruptedException {
          homePage.selectCurrency();
          Thread.sleep(1000);
 }

 @Then("verify Euro Symbol is shown on the products displayed in Home page")
   public void verifyEuroSymbolIsShownOnTheProductsDisplayedInHomePage() {
         JavascriptExecutor js =(JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,1250)");
         for(int i=0 ; i<=3 ; i++){
             List<WebElement> CurrencyDropDown =  driver.findElements(By.cssSelector("div [class=\"prices\"]"));
             String AcutalResult =CurrencyDropDown.get(i).getText();
             Assert.assertTrue(AcutalResult.contains("€"));
             System.out.println(AcutalResult);
         }
   }


}