package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        WebElement addToCartButton = driver.findElement(By.cssSelector("button.add-to-basket"));
        addToCartButton.click();
    }

    public void goToCart() {
        WebElement cartButton = driver.findElement(By.cssSelector("a#shoppingCart"));
        cartButton.click();
    }
}
