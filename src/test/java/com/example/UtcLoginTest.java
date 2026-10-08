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
}
