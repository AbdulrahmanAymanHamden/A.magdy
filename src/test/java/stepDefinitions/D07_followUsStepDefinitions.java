package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.P03_homePage;

import java.util.ArrayList;

import static stepDefinitions.Hooks.driver;

public class D07_followUsStepDefinitions {

    P03_homePage homePage = new P03_homePage(driver);



    @When("user opens facebook link")
    public void userOpensFacebookLink() throws InterruptedException {
        Thread.sleep(500);
        homePage.facebookLink().click();

    }

    @And("user opens twitter link")
    public void userOpensTwitterLink() throws InterruptedException {
        Thread.sleep(500);
        homePage.twitterLink().click();
    }



    @And("user opens youtube link")
    public void userOpensYoutubeLink() throws InterruptedException {
        Thread.sleep(500);
        homePage.youtubeLink().click();
    }

    @And("{string} is opened in new tab correctly")
    public void isOpenedInNewTab(String exResult) throws InterruptedException {
        //2- get window list inside array
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());
        Assert.assertTrue(tabs.size()>1);

        //3- switch from tab 0 to tab 1
        driver.switchTo().window(tabs.get(1));
        System.out.println("tab 1:  " +driver.getCurrentUrl());

        String actualResult = driver.getCurrentUrl();
        System.out.println(exResult);
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,exResult);

        Thread.sleep(1000);
        driver.close();
    }
    @And("user opens rss link")
    public void userOpensRssLink() throws InterruptedException {
        Thread.sleep(500);
        homePage.rssLink().click();
    }


}
