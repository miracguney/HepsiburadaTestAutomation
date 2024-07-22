package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstProduct() {
        WebElement firstProduct = driver.findElement(By.cssSelector("li.search-item:nth-child(1)"));
        firstProduct.click();
    }
}
