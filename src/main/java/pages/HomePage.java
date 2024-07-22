package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://www.hepsiburada.com/");
    }

    public void goToLoginPage() {
        WebElement loginButton = driver.findElement(By.cssSelector("div.account-user a"));
        loginButton.click();
    }

    public void searchForProduct(String product) {
        WebElement searchBox = driver.findElement(By.cssSelector("input.desktopOldAutosuggestTheme-input"));
        searchBox.sendKeys(product);
        WebElement searchButton = driver.findElement(By.cssSelector("div.SearchBoxOld-buttonContainer"));
        searchButton.click();
    }
}
