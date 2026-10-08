package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Văn phòng điện tử UTC")
@Feature("Chức năng Đăng nhập & Giao diện")
public class LoginE2ETest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    @Story("Kiểm tra Tiêu đề trang")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("TC01 - Kiểm tra tiêu đề trang web")
    public void testTC01_CheckPageTitle() {
        assertEquals("Đăng nhập", loginPage.getPageTitle(), "Tiêu đề trang phải là 'Đăng nhập'");
    }

    @Test
    @Story("Kiểm tra Tiêu đề Form")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC02 - Kiểm tra tiêu đề Form đăng nhập")
    public void testTC02_CheckFormTitleText() {
        assertTrue(loginPage.getFormHeaderText().contains("Tài khoản văn phòng điện tử"), "Form đăng nhập phải chứa chữ 'Tài khoản văn phòng điện tử'");
    }

    @Test
    @Story("Kiểm tra Trường Tên đăng nhập")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC03 - Kiểm tra ô nhập Tên đăng nhập hiển thị")
    public void testTC03_CheckUsernameFieldDisplayed() {
        assertTrue(loginPage.isUsernameFieldDisplayed(), "Ô nhập tên đăng nhập phải hiển thị");
    }

    @Test
    @Story("Kiểm tra Trường Tên đăng nhập")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC04 - Kiểm tra Placeholder Tên đăng nhập")
    public void testTC04_CheckUsernamePlaceholder() {
        assertEquals("Tên đăng nhập", loginPage.getUsernamePlaceholder(), "Placeholder của ô username phải là 'Tên đăng nhập'");
    }

    @Test
    @Story("Kiểm tra Trường Mật khẩu")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC05 - Kiểm tra ô nhập Mật khẩu hiển thị")
    public void testTC05_CheckPasswordFieldDisplayed() {
        assertTrue(loginPage.isPasswordFieldDisplayed(), "Ô nhập mật khẩu phải hiển thị");
    }

    @Test
    @Story("Kiểm tra Trường Mật khẩu")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC06 - Kiểm tra Placeholder Mật khẩu")
    public void testTC06_CheckPasswordPlaceholder() {
        assertEquals("Mật khẩu", loginPage.getPasswordPlaceholder(), "Placeholder của ô mật khẩu phải là 'Mật khẩu'");
    }

    @Test
    @Story("Kiểm tra Trường Mật khẩu")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("TC07 - Kiểm tra ô Mật khẩu bị ẩn ký tự (type=password)")
    public void testTC07_CheckPasswordFieldMasked() {
        assertEquals("password", loginPage.getPasswordFieldType(), "Kiểu dữ liệu của ô mật khẩu phải là 'password'");
    }

    @Test
    @Story("Kiểm tra Ô Ghi nhớ đăng nhập")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC08 - Kiểm tra ô Checkbox 'Giữ tôi luôn đăng nhập' hiển thị")
    public void testTC08_CheckPersistentCheckboxDisplayed() {
        assertTrue(loginPage.isPersistentCheckboxDisplayed(), "Ô checkbox 'Giữ tôi luôn đăng nhập' phải tồn tại");
    }

    @Test
    @Story("Kiểm tra Ô Ghi nhớ đăng nhập")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC09 - Kiểm tra mặc định Checkbox chưa được chọn")
    public void testTC09_CheckPersistentCheckboxInitialState() {
        assertFalse(loginPage.isPersistentCheckboxSelected(), "Mặc định ô checkbox 'Giữ tôi luôn đăng nhập' chưa được chọn");
    }

    @Test
    @Story("Kiểm tra Ô Ghi nhớ đăng nhập")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC10 - Kiểm tra chọn/bỏ chọn Checkbox 'Giữ tôi luôn đăng nhập'")
    public void testTC10_CheckTogglePersistentCheckbox() {
        loginPage.clickPersistentCheckboxLabel();
        assertTrue(loginPage.isPersistentCheckboxSelected(), "Sau khi click, ô checkbox 'Giữ tôi luôn đăng nhập' phải được chọn");
    }

    @Test
    @Story("Kiểm tra Nút Đăng nhập")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("TC11 - Kiểm tra nút Đăng nhập hiển thị")
    public void testTC11_CheckLoginButtonDisplayed() {
        assertTrue(loginPage.isSubmitButtonDisplayed(), "Nút Đăng nhập phải hiển thị");
    }

    @Test
    @Story("Kiểm tra Nút Đăng nhập")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC12 - Kiểm tra văn bản hiển thị nút Đăng nhập")
    public void testTC12_CheckLoginButtonText() {
        assertEquals("Đăng nhập", loginPage.getSubmitButtonValue(), "Giá trị của nút đăng nhập phải là 'Đăng nhập'");
    }

    @Test
    @Story("Kiểm tra Đăng nhập SSO UTC")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC13 - Kiểm tra nút 'Đăng nhập bằng e-mail UTC' hiển thị")
    public void testTC13_CheckGoogleEmailLoginButtonDisplayed() {
        assertTrue(loginPage.isSsoButtonDisplayed(), "Nút Đăng nhập bằng e-mail UTC phải hiển thị");
        assertTrue(loginPage.getSsoButtonText().contains("Đăng nhập bằng e-mail UTC"), "Nút SSO phải chứa văn bản 'Đăng nhập bằng e-mail UTC'");
    }

    @Test
    @Story("Kiểm tra Đăng nhập SSO UTC")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC14 - Kiểm tra liên kết nút đăng nhập email UTC")
    public void testTC14_CheckGoogleEmailLoginHref() {
        assertTrue(loginPage.getSsoButtonHref().contains("accounts.google.com"), "Đường dẫn nút đăng nhập email UTC phải trỏ tới Google OAuth");
    }

    @Test
    @Story("Kiểm tra Quên mật khẩu")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC15 - Kiểm tra liên kết 'Bạn quên mật khẩu đăng nhập ?'")
    public void testTC15_CheckForgotPasswordLinkDisplayed() {
        assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Liên kết 'Bạn quên mật khẩu đăng nhập ?' phải hiển thị");
    }

    @Test
    @Story("Kiểm tra Quên mật khẩu")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC16 - Kiểm tra đường dẫn trang Quên mật khẩu")
    public void testTC16_CheckForgotPasswordHref() {
        assertTrue(loginPage.getForgotPasswordHref().contains("/Login/GetPass"), "Liên kết quên mật khẩu phải trỏ tới '/Login/GetPass'");
    }

    @Test
    @Story("Kiểm tra Luồng Đăng nhập")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC17 - Kiểm tra gửi Form khi để trống thông tin")
    public void testTC17_CheckEmptyLoginSubmission() {
        loginPage.clickSubmitButton();
        assertTrue(driver.getCurrentUrl().contains("/Login"), "Khi bấm đăng nhập trống, trang phải ở lại URL Login");
    }

    @Test
    @Story("Kiểm tra Luồng Đăng nhập")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("TC18 - Kiểm tra đăng nhập với tài khoản sai")
    public void testTC18_CheckLoginWithInvalidCredentials() {
        loginPage.login("invalid_user_123", "wrong_password");
        assertTrue(driver.getCurrentUrl().contains("/Login"), "Đăng nhập sai tài khoản phải giữ lại ở trang Login");
    }

    @Test
    @Story("Kiểm tra Nhập dữ liệu")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC19 - Kiểm tra nhập văn bản vào ô Tên đăng nhập")
    public void testTC19_CheckInputUsernameText() {
        loginPage.enterUsername("test_user");
        assertEquals("test_user", loginPage.getUsernameValue(), "Giá trị ô username phải là 'test_user'");
    }

    @Test
    @Story("Kiểm tra Nhập dữ liệu")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("TC20 - Kiểm tra nhập văn bản vào ô Mật khẩu")
    public void testTC20_CheckInputPasswordText() {
        loginPage.enterPassword("secret123");
        assertEquals("secret123", loginPage.getPasswordValue(), "Giá trị ô mật khẩu phải chứa đúng text đã nhập");
    }

    @Test
    @Story("Kiểm tra Giao diện Banner")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC21 - Kiểm tra tiêu đề Banner quảng bá")
    public void testTC21_CheckBannerTitle() {
        assertEquals("Không chỉ là một giải pháp quản lý", loginPage.getBannerTitleText(), "Tiêu đề banner phải đúng");
    }

    @Test
    @Story("Kiểm tra Giao diện Banner")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC22 - Kiểm tra phụ đề Banner quảng bá")
    public void testTC22_CheckBannerSubtitle() {
        assertEquals("Làm việc mọi lúc mọi nơi", loginPage.getBannerSubtitleText(), "Phụ đề banner phải đúng");
    }

    @Test
    @Story("Kiểm tra Giao diện Footer")
    @Severity(SeverityLevel.TRIVIAL)
    @DisplayName("TC23 - Kiểm tra thông tin bản quyền ở Footer")
    public void testTC23_CheckFooterCopyrightText() {
        assertTrue(loginPage.getFooterCopyrightText().contains("Trường ĐH Giao Thông Vận Tải"), "Footer phải chứa tên trường");
    }

    @Test
    @Story("Kiểm tra Giao diện Footer")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC24 - Kiểm tra liên kết Trung tâm trợ giúp")
    public void testTC24_CheckFooterHelpCenterLink() {
        assertTrue(loginPage.isHelpCenterLinkDisplayed(), "Liên kết Trung tâm trợ giúp phải hiển thị");
    }

    @Test
    @Story("Kiểm tra Giao diện Footer")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("TC25 - Kiểm tra liên kết Ý kiến phản hồi")
    public void testTC25_CheckFooterFeedbackEmailLink() {
        assertTrue(loginPage.isFeedbackLinkDisplayed(), "Liên kết Ý kiến phản hồi phải hiển thị");
    }
}
