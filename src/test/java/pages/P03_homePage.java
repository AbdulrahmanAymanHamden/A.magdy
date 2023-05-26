package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class P03_homePage {
    WebDriver driver;

    By registerButton = By.className("ico-register");
    By loginButton = By.className("ico-login");
    By wishlistButton = By.className("ico-wishlist");
    By shoppingCartButton = By.className("ico-cart");
    /*By searchBar = By.id("small-searchterms");
    By searchButton = By.cssSelector("button[class=\"button-1 search-box-button\"]");*/

   // By facebookLink = By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]");
//    By twitterLink = By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]");
//    By rssLink = By.cssSelector("a[href=\"/news/rss/1\"]");
//    By youtubeLink = By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]");

    public WebElement AddtoWishlist(){
       // return driver.findElement(By.xpath("(//button[@class=\"button-2 add-to-wishlist-button\"])[3]"));
        return driver.findElement(By.cssSelector("div[class=\"product-grid home-page-product-grid\"] div[class=\"item-grid\"] div[class=\"item-box\"]:nth-child(3) button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    public WebElement AddWishlistSuccessMsg(){
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement facebookLink(){
        return driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
    }
    public WebElement twitterLink(){
        return driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
    }
    public WebElement rssLink(){
        return driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
    }
    public WebElement youtubeLink(){
        return driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
    }



    public WebElement searchBar(){
        return driver.findElement(By.id("small-searchterms"));
    }

    public WebElement searchButton(){
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }

    By currencyList = By.id("customerCurrency");

    public List<WebElement> currencyList(){
        List<WebElement> elementsList = new ArrayList<>();
        elementsList = driver.findElements(By.id("customerCurrency"));
        return elementsList;
    }


    public P03_homePage(WebDriver driver) {
        this.driver = driver;
    }

    public void GoToRegisterPage(){
        driver.findElement(registerButton).click();
    }

    public void GoToLoginPage(){
        driver.findElement(loginButton).click();
    }

    public WebElement GoToWishListPage(){
        return driver.findElement(By.cssSelector("a[class=\"ico-wishlist\"]"));
    }

    public void GoToShoppingCartPage(){
        driver.findElement(shoppingCartButton).click();
    }




    public void selectCurrency(){
        Select currencyDropdown = new Select(driver.findElement(currencyList));
        currencyDropdown.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }



}
