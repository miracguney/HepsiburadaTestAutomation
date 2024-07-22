package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        WebElement emailField = driver.findElement(By.id("txtUserName"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }
}
