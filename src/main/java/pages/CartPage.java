package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyProductInCart(String product) {
        WebElement cartItem = driver.findElement(By.cssSelector("div.product_name"));
        assert cartItem.getText().contains(product) : "Sepette ürün bulunamadı.";
    }
}
