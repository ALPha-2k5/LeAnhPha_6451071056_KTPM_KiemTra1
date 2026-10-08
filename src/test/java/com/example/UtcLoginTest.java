package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class UtcLoginTest {

    private WebDriver driver;
    private final String BASE_URL = "https://vanphongdientu.utc.edu.vn/Login?r=https%3A%2F%2Fvanphongdientu.utc.edu.vn%2F";

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testTC01_CheckPageTitle() {
        String title = driver.getTitle();
        assertEquals("ÄÄƒng nháº­p", title, "TiÃªu Ä‘á» trang pháº£i lÃ  'ÄÄƒng nháº­p'");
    }
    @Test
    public void testTC02_CheckFormTitleText() {
        WebElement form = driver.findElement(By.className("form"));
        assertTrue(form.getText().contains("TÃ i khoáº£n vÄƒn phÃ²ng Ä‘iá»‡n tá»­"), "Form Ä‘Äƒng nháº­p pháº£i chá»©a chá»¯ 'TÃ i khoáº£n vÄƒn phÃ²ng Ä‘iá»‡n tá»­'");
    }
    @Test
    public void testTC03_CheckUsernameFieldDisplayed() {
        WebElement usernameInput = driver.findElement(By.name("username"));
        assertTrue(usernameInput.isDisplayed(), "Ã” nháº­p tÃªn Ä‘Äƒng nháº­p pháº£i hiá»ƒn thá»‹");
    }
    @Test
    public void testTC04_CheckUsernamePlaceholder() {
        WebElement usernameInput = driver.findElement(By.name("username"));
        assertEquals("TÃªn Ä‘Äƒng nháº­p", usernameInput.getAttribute("placeholder"), "Placeholder cá»§a Ã´ username pháº£i lÃ  'TÃªn Ä‘Äƒng nháº­p'");
    }
    @Test
    public void testTC05_CheckPasswordFieldDisplayed() {
        WebElement passwordInput = driver.findElement(By.name("userpwd"));
        assertTrue(passwordInput.isDisplayed(), "Ã” nháº­p máº­t kháº©u pháº£i hiá»ƒn thá»‹");
    }
    @Test
    public void testTC06_CheckPasswordPlaceholder() {
        WebElement passwordInput = driver.findElement(By.name("userpwd"));
        assertEquals("Máº­t kháº©u", passwordInput.getAttribute("placeholder"), "Placeholder cá»§a Ã´ máº­t kháº©u pháº£i lÃ  'Máº­t kháº©u'");
    }
    @Test
    public void testTC07_CheckPasswordFieldMasked() {
        WebElement passwordInput = driver.findElement(By.name("userpwd"));
        assertEquals("password", passwordInput.getAttribute("type"), "Kiá»ƒu dá»¯ liá»‡u cá»§a Ã´ máº­t kháº©u pháº£i lÃ  'password'");
    }
    @Test
    public void testTC08_CheckPersistentCheckboxDisplayed() {
        WebElement checkbox = driver.findElement(By.id("persistent"));
        assertNotNull(checkbox, "Ã” checkbox 'Giá»¯ tÃ´i luÃ´n Ä‘Äƒng nháº­p' pháº£i tá»“n táº¡i");
    }
    @Test
    public void testTC09_CheckPersistentCheckboxInitialState() {
        WebElement checkbox = driver.findElement(By.id("persistent"));
        assertFalse(checkbox.isSelected(), "Máº·c Ä‘á»‹nh Ã´ checkbox 'Giá»¯ tÃ´i luÃ´n Ä‘Äƒng nháº­p' chÆ°a Ä‘Æ°á»£c chá»n");
    }
    @Test
    public void testTC10_CheckTogglePersistentCheckbox() {
        WebElement label = driver.findElement(By.cssSelector("label[for='persistent']"));
        label.click();
        WebElement checkbox = driver.findElement(By.id("persistent"));
        assertTrue(checkbox.isSelected(), "Sau khi click, Ã´ checkbox 'Giá»¯ tÃ´i luÃ´n Ä‘Äƒng nháº­p' pháº£i Ä‘Æ°á»£c chá»n");
    }
    @Test
    public void testTC11_CheckLoginButtonDisplayed() {
        WebElement submitBtn = driver.findElement(By.className("submit_login"));
        assertTrue(submitBtn.isDisplayed(), "NÃºt ÄÄƒng nháº­p pháº£i hiá»ƒn thá»‹");
    }
    @Test
    public void testTC12_CheckLoginButtonText() {
        WebElement submitBtn = driver.findElement(By.className("submit_login"));
        assertEquals("ÄÄƒng nháº­p", submitBtn.getAttribute("value"), "GiÃ¡ trá»‹ cá»§a nÃºt Ä‘Äƒng nháº­p pháº£i lÃ  'ÄÄƒng nháº­p'");
    }
    @Test
    public void testTC13_CheckGoogleEmailLoginButtonDisplayed() {
        WebElement ssoBtn = driver.findElement(By.cssSelector("a.button"));
        assertTrue(ssoBtn.isDisplayed(), "NÃºt ÄÄƒng nháº­p báº±ng e-mail UTC pháº£i hiá»ƒn thá»‹");
        assertTrue(ssoBtn.getText().contains("ÄÄƒng nháº­p báº±ng e-mail UTC"), "NÃºt SSO pháº£i chá»©a vÄƒn báº£n 'ÄÄƒng nháº­p báº±ng e-mail UTC'");
    }
    @Test
    public void testTC14_CheckGoogleEmailLoginHref() {
        WebElement ssoBtn = driver.findElement(By.cssSelector("a.button"));
        String href = ssoBtn.getAttribute("href");
        assertTrue(href.contains("accounts.google.com"), "ÄÆ°á»ng dáº«n nÃºt Ä‘Äƒng nháº­p email UTC pháº£i trá» tá»›i Google OAuth");
    }
    @Test
    public void testTC15_CheckForgotPasswordLinkDisplayed() {
        WebElement forgotLink = driver.findElement(By.cssSelector("div.helps a"));
        assertTrue(forgotLink.isDisplayed(), "LiÃªn káº¿t 'Báº¡n quÃªn máº­t kháº©u Ä‘Äƒng nháº­p ?' pháº£i hiá»ƒn thá»‹");
    }
    @Test
    public void testTC16_CheckForgotPasswordHref() {
        WebElement forgotLink = driver.findElement(By.cssSelector("div.helps a"));
        String href = forgotLink.getAttribute("href");
        assertTrue(href.contains("/Login/GetPass"), "LiÃªn káº¿t quÃªn máº­t kháº©u pháº£i trá» tá»›i '/Login/GetPass'");
    }
    @Test
    public void testTC17_CheckEmptyLoginSubmission() {
        WebElement submitBtn = driver.findElement(By.className("submit_login"));
        submitBtn.click();
        assertTrue(driver.getCurrentUrl().contains("/Login"), "Khi báº¥m Ä‘Äƒng nháº­p trá»‘ng, trang pháº£i á»Ÿ láº¡i URL Login");
    }
}
