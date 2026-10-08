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
        assertEquals("Đăng nhập", title, "Tiêu đề trang phải là 'Đăng nhập'");
    }

    @Test
    public void testTC02_CheckFormTitleText() {
        WebElement form = driver.findElement(By.className("form"));
        assertTrue(form.getText().contains("Tài khoản văn phòng điện tử"), "Form đăng nhập phải chứa chữ 'Tài khoản văn phòng điện tử'");
    }

    @Test
    public void testTC03_CheckUsernameFieldDisplayed() {
        WebElement usernameInput = driver.findElement(By.name("username"));
        assertTrue(usernameInput.isDisplayed(), "Ô nhập tên đăng nhập phải hiển thị");
    }

    @Test
    public void testTC04_CheckUsernamePlaceholder() {
        WebElement usernameInput = driver.findElement(By.name("username"));
        assertEquals("Tên đăng nhập", usernameInput.getAttribute("placeholder"), "Placeholder của ô username phải là 'Tên đăng nhập'");
    }

    @Test
    public void testTC05_CheckPasswordFieldDisplayed() {
        WebElement passwordInput = driver.findElement(By.name("userpwd"));
        assertTrue(passwordInput.isDisplayed(), "Ô nhập mật khẩu phải hiển thị");
    }

    @Test
    public void testTC06_CheckPasswordPlaceholder() {
        WebElement passwordInput = driver.findElement(By.name("userpwd"));
        assertEquals("Mật khẩu", passwordInput.getAttribute("placeholder"), "Placeholder của ô mật khẩu phải là 'Mật khẩu'");
    }

    @Test
    public void testTC07_CheckPasswordFieldMasked() {
        WebElement passwordInput = driver.findElement(By.name("userpwd"));
        assertEquals("password", passwordInput.getAttribute("type"), "Kiểu dữ liệu của ô mật khẩu phải là 'password'");
    }

    @Test
    public void testTC08_CheckPersistentCheckboxDisplayed() {
        WebElement checkbox = driver.findElement(By.id("persistent"));
        assertNotNull(checkbox, "Ô checkbox 'Giữ tôi luôn đăng nhập' phải tồn tại");
    }

    @Test
    public void testTC09_CheckPersistentCheckboxInitialState() {
        WebElement checkbox = driver.findElement(By.id("persistent"));
        assertFalse(checkbox.isSelected(), "Mặc định ô checkbox 'Giữ tôi luôn đăng nhập' chưa được chọn");
    }

    @Test
    public void testTC10_CheckTogglePersistentCheckbox() {
        WebElement label = driver.findElement(By.cssSelector("label[for='persistent']"));
        label.click();
        WebElement checkbox = driver.findElement(By.id("persistent"));
        assertTrue(checkbox.isSelected(), "Sau khi click, ô checkbox 'Giữ tôi luôn đăng nhập' phải được chọn");
    }

    @Test
    public void testTC11_CheckLoginButtonDisplayed() {
        WebElement submitBtn = driver.findElement(By.className("submit_login"));
        assertTrue(submitBtn.isDisplayed(), "Nút Đăng nhập phải hiển thị");
    }

    @Test
    public void testTC12_CheckLoginButtonText() {
        WebElement submitBtn = driver.findElement(By.className("submit_login"));
        assertEquals("Đăng nhập", submitBtn.getAttribute("value"), "Giá trị của nút đăng nhập phải là 'Đăng nhập'");
    }

    @Test
    public void testTC13_CheckGoogleEmailLoginButtonDisplayed() {
        WebElement ssoBtn = driver.findElement(By.cssSelector("a.button"));
        assertTrue(ssoBtn.isDisplayed(), "Nút Đăng nhập bằng e-mail UTC phải hiển thị");
        assertTrue(ssoBtn.getText().contains("Đăng nhập bằng e-mail UTC"), "Nút SSO phải chứa văn bản 'Đăng nhập bằng e-mail UTC'");
    }

    @Test
    public void testTC14_CheckGoogleEmailLoginHref() {
        WebElement ssoBtn = driver.findElement(By.cssSelector("a.button"));
        String href = ssoBtn.getAttribute("href");
        assertTrue(href.contains("accounts.google.com"), "Đường dẫn nút đăng nhập email UTC phải trỏ tới Google OAuth");
    }

    @Test
    public void testTC15_CheckForgotPasswordLinkDisplayed() {
        WebElement forgotLink = driver.findElement(By.cssSelector("div.helps a"));
        assertTrue(forgotLink.isDisplayed(), "Liên kết 'Bạn quên mật khẩu đăng nhập ?' phải hiển thị");
    }

    @Test
    public void testTC16_CheckForgotPasswordHref() {
        WebElement forgotLink = driver.findElement(By.cssSelector("div.helps a"));
        String href = forgotLink.getAttribute("href");
        assertTrue(href.contains("/Login/GetPass"), "Liên kết quên mật khẩu phải trỏ tới '/Login/GetPass'");
    }

    @Test
    public void testTC17_CheckEmptyLoginSubmission() {
        WebElement submitBtn = driver.findElement(By.className("submit_login"));
        submitBtn.click();
        assertTrue(driver.getCurrentUrl().contains("/Login"), "Khi bấm đăng nhập trống, trang phải ở lại URL Login");
    }

    @Test
    public void testTC18_CheckLoginWithInvalidCredentials() {
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("userpwd"));
        WebElement submitBtn = driver.findElement(By.className("submit_login"));

        usernameInput.sendKeys("invalid_user_123");
        passwordInput.sendKeys("wrong_password");
        submitBtn.click();

        assertTrue(driver.getCurrentUrl().contains("/Login"), "Đăng nhập sai tài khoản phải giữ lại ở trang Login");
    }

    @Test
    public void testTC19_CheckInputUsernameText() {
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("test_user");
        assertEquals("test_user", usernameInput.getAttribute("value"), "Giá trị ô username phải là 'test_user'");
    }

    @Test
    public void testTC20_CheckInputPasswordText() {
        WebElement passwordInput = driver.findElement(By.name("userpwd"));
        passwordInput.sendKeys("secret123");
        assertEquals("secret123", passwordInput.getAttribute("value"), "Giá trị ô mật khẩu phải chứa đúng text đã nhập");
    }

    @Test
    public void testTC21_CheckBannerTitle() {
        WebElement bannerH1 = driver.findElement(By.cssSelector("div.left div.caption h1"));
        assertEquals("Không chỉ là một giải pháp quản lý", bannerH1.getText(), "Tiêu đề banner phải đúng");
    }

    @Test
    public void testTC22_CheckBannerSubtitle() {
        WebElement bannerSpan = driver.findElement(By.cssSelector("div.left div.caption span"));
        assertEquals("Làm việc mọi lúc mọi nơi", bannerSpan.getText(), "Phụ đề banner phải đúng");
    }

    @Test
    public void testTC23_CheckFooterCopyrightText() {
        WebElement copyright = driver.findElement(By.cssSelector("div.footer div.left span.a"));
        assertTrue(copyright.getText().contains("Trường ĐH Giao Thông Vận Tải"), "Footer phải chứa tên trường");
    }

    @Test
    public void testTC24_CheckFooterHelpCenterLink() {
        WebElement helpLink = driver.findElement(By.cssSelector("a[href*='hotrokythuat.utc.edu.vn']"));
        assertTrue(helpLink.isDisplayed(), "Liên kết Trung tâm trợ giúp phải hiển thị");
    }

    @Test
    public void testTC25_CheckFooterFeedbackEmailLink() {
        WebElement feedbackLink = driver.findElement(By.cssSelector("a[href^='mailto:hotrokythuat@utc.edu.vn']"));
        assertTrue(feedbackLink.isDisplayed(), "Liên kết Ý kiến phản hồi phải hiển thị");
    }
}
