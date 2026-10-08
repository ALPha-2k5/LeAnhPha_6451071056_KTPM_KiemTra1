package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginE2ETest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testTC01_CheckPageTitle() {
        assertEquals("Đăng nhập", loginPage.getPageTitle(), "Tiêu đề trang phải là 'Đăng nhập'");
    }

    @Test
    public void testTC02_CheckFormTitleText() {
        assertTrue(loginPage.getFormHeaderText().contains("Tài khoản văn phòng điện tử"), "Form đăng nhập phải chứa chữ 'Tài khoản văn phòng điện tử'");
    }

    @Test
    public void testTC03_CheckUsernameFieldDisplayed() {
        assertTrue(loginPage.isUsernameFieldDisplayed(), "Ô nhập tên đăng nhập phải hiển thị");
    }

    @Test
    public void testTC04_CheckUsernamePlaceholder() {
        assertEquals("Tên đăng nhập", loginPage.getUsernamePlaceholder(), "Placeholder của ô username phải là 'Tên đăng nhập'");
    }

    @Test
    public void testTC05_CheckPasswordFieldDisplayed() {
        assertTrue(loginPage.isPasswordFieldDisplayed(), "Ô nhập mật khẩu phải hiển thị");
    }

    @Test
    public void testTC06_CheckPasswordPlaceholder() {
        assertEquals("Mật khẩu", loginPage.getPasswordPlaceholder(), "Placeholder của ô mật khẩu phải là 'Mật khẩu'");
    }

    @Test
    public void testTC07_CheckPasswordFieldMasked() {
        assertEquals("password", loginPage.getPasswordFieldType(), "Kiểu dữ liệu của ô mật khẩu phải là 'password'");
    }

    @Test
    public void testTC08_CheckPersistentCheckboxDisplayed() {
        assertTrue(loginPage.isPersistentCheckboxDisplayed(), "Ô checkbox 'Giữ tôi luôn đăng nhập' phải tồn tại");
    }

    @Test
    public void testTC09_CheckPersistentCheckboxInitialState() {
        assertFalse(loginPage.isPersistentCheckboxSelected(), "Mặc định ô checkbox 'Giữ tôi luôn đăng nhập' chưa được chọn");
    }

    @Test
    public void testTC10_CheckTogglePersistentCheckbox() {
        loginPage.clickPersistentCheckboxLabel();
        assertTrue(loginPage.isPersistentCheckboxSelected(), "Sau khi click, ô checkbox 'Giữ tôi luôn đăng nhập' phải được chọn");
    }

    @Test
    public void testTC11_CheckLoginButtonDisplayed() {
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Nút Đăng nhập phải hiển thị");
    }

    @Test
    public void testTC12_CheckLoginButtonText() {
        assertEquals("Đăng nhập", loginPage.getSubmitButtonValue(), "Giá trị của nút đăng nhập phải là 'Đăng nhập'");
    }

    @Test
    public void testTC13_CheckGoogleEmailLoginButtonDisplayed() {
        assertTrue(loginPage.isSsoButtonDisplayed(), "Nút Đăng nhập bằng e-mail UTC phải hiển thị");
        assertTrue(loginPage.getSsoButtonText().contains("Đăng nhập bằng e-mail UTC"), "Nút SSO phải chứa văn bản 'Đăng nhập bằng e-mail UTC'");
    }

    @Test
    public void testTC14_CheckGoogleEmailLoginHref() {
        assertTrue(loginPage.getSsoButtonHref().contains("accounts.google.com"), "Đường dẫn nút đăng nhập email UTC phải trỏ tới Google OAuth");
    }

    @Test
    public void testTC15_CheckForgotPasswordLinkDisplayed() {
        assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Liên kết 'Bạn quên mật khẩu đăng nhập ?' phải hiển thị");
    }

    @Test
    public void testTC16_CheckForgotPasswordHref() {
        assertTrue(loginPage.getForgotPasswordHref().contains("/Login/GetPass"), "Liên kết quên mật khẩu phải trỏ tới '/Login/GetPass'");
    }

    @Test
    public void testTC17_CheckEmptyLoginSubmission() {
        loginPage.clickSubmitButton();
        assertTrue(driver.getCurrentUrl().contains("/Login"), "Khi bấm đăng nhập trống, trang phải ở lại URL Login");
    }

    @Test
    public void testTC18_CheckLoginWithInvalidCredentials() {
        loginPage.login("invalid_user_123", "wrong_password");
        assertTrue(driver.getCurrentUrl().contains("/Login"), "Đăng nhập sai tài khoản phải giữ lại ở trang Login");
    }

    @Test
    public void testTC19_CheckInputUsernameText() {
        loginPage.enterUsername("test_user");
        assertEquals("test_user", loginPage.getUsernameValue(), "Giá trị ô username phải là 'test_user'");
    }

    @Test
    public void testTC20_CheckInputPasswordText() {
        loginPage.enterPassword("secret123");
        assertEquals("secret123", loginPage.getPasswordValue(), "Giá trị ô mật khẩu phải chứa đúng text đã nhập");
    }

    @Test
    public void testTC21_CheckBannerTitle() {
        assertEquals("Không chỉ là một giải pháp quản lý", loginPage.getBannerTitleText(), "Tiêu đề banner phải đúng");
    }

    @Test
    public void testTC22_CheckBannerSubtitle() {
        assertEquals("Làm việc mọi lúc mọi nơi", loginPage.getBannerSubtitleText(), "Phụ đề banner phải đúng");
    }

    @Test
    public void testTC23_CheckFooterCopyrightText() {
        assertTrue(loginPage.getFooterCopyrightText().contains("Trường ĐH Giao Thông Vận Tải"), "Footer phải chứa tên trường");
    }

    @Test
    public void testTC24_CheckFooterHelpCenterLink() {
        assertTrue(loginPage.isHelpCenterLinkDisplayed(), "Liên kết Trung tâm trợ giúp phải hiển thị");
    }

    @Test
    public void testTC25_CheckFooterFeedbackEmailLink() {
        assertTrue(loginPage.isFeedbackLinkDisplayed(), "Liên kết Ý kiến phản hồi phải hiển thị");
    }
}
