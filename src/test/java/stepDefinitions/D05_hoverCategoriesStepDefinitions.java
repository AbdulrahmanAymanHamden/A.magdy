package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;
import java.util.Random;

import static stepDefinitions.Hooks.*;

public class D05_hoverCategoriesStepDefinitions {

    Actions action = new Actions(driver);
    Random rand = new Random();
    int random_integer1 = rand.nextInt(3) + 1;
    int random_integer2 = rand.nextInt(3) + 1;
    String sub;
    String pageTitle;

//    public void hovering(){
//        Actions action = new Actions(Hooks.driver);
////        action.click(hoverCategories.subCategoriesMenu()).perform();
//        action.moveToElement(Hooks.driver.findElement(By.cssSelector("a[href=\"/computers\"]")));
//    }


    @When("select random one of the three main categories and hover on it")
    public void selectRandomOneOfTheThreeMainCategoriesAndHoverIt() throws InterruptedException {
        WebElement mainCategoriesMenu =  driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+random_integer1+"]"));
        action.moveToElement(mainCategoriesMenu).perform();
        Thread.sleep(1000);
    }

    @And("select random one of the sub categories and click on it")
    public void youShouldHoverOnTheSelectedCategory() throws InterruptedException {
        WebElement subCategoriesMenu = driver.findElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li["+random_integer1+"]/ul[@class=\"sublist first-level\"]/li["+random_integer2+"]"));
        action.moveToElement(subCategoriesMenu).perform();
        sub = subCategoriesMenu.getText();
        subCategoriesMenu.click();
        System.out.println(sub);
        pageTitle = driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText();
        System.out.println(pageTitle);
        Thread.sleep(1000);
    }

    @Then("verify that the sub-category title is equal or contains the one you get it while selecting random sub-category")
    public void verifyThatTheSubCategoryTitleIsEqualOrContainsTheOneYouGetItWhileSelectingRandomSubCategory() {
        String ActualResult = pageTitle.toLowerCase().trim();
        String ExpectedResult = sub.toLowerCase().trim();
        Assert.assertEquals(ActualResult,ExpectedResult);
        System.out.println(ActualResult);
        System.out.println(ExpectedResult);
    }
}
