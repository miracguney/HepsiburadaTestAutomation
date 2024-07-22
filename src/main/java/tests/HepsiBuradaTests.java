package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class HepsiBuradaTests {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mirac\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    @Description("HepsiBurada ana sayfasına gidilir, kullanıcı giriş yapar, ürün aranır, ürün detay sayfasına gidilir ve sepete eklenir.")
    @DisplayName("Ürün Sepete Ekleme ve Doğrulama Testi")
    public void addProductToCartTest() {
        navigateToHomePage();
        goToLoginPage();
        login("email@example.com", "password");
        searchForProduct("laptop");
        selectFirstProduct();
        addToCart();
        goToCart();
        verifyProductInCart("laptop");
    }

    @Step("Ana sayfaya gidilir.")
    public void navigateToHomePage() {
        homePage.navigateToHomePage();
    }

    @Step("Giriş sayfasına gidilir.")
    public void goToLoginPage() {
        homePage.goToLoginPage();
    }

    @Step("Kullanıcı giriş yapar: {email}")
    public void login(String email, String password) {
        loginPage.login(email, password);
    }

    @Step("Ürün araması yapılır: {product}")
    public void searchForProduct(String product) {
        homePage.searchForProduct(product);
    }

    @Step("İlk ürün seçilir.")
    public void selectFirstProduct() {
        searchResultsPage.selectFirstProduct();
    }

    @Step("Ürün sepete eklenir.")
    public void addToCart() {
        productPage.addToCart();
    }

    @Step("Sepete gidilir.")
    public void goToCart() {
        productPage.goToCart();
    }

    @Step("Sepette ürün doğrulanır: {product}")
    public void verifyProductInCart(String product) {
        cartPage.verifyProductInCart(product);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

