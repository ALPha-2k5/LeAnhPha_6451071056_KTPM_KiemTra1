package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By formHeader = By.className("form");
    private final By usernameInput = By.name("username");
    private final By passwordInput = By.name("userpwd");
    private final By persistentCheckbox = By.id("persistent");
    private final By persistentLabel = By.cssSelector("label[for='persistent']");
    private final By submitButton = By.className("submit_login");
    private final By ssoButton = By.cssSelector("a.button");
    private final By forgotPasswordLink = By.cssSelector("div.helps a");
    private final By bannerTitle = By.cssSelector("div.left div.caption h1");
    private final By bannerSubtitle = By.cssSelector("div.left div.caption span");
    private final By footerCopyright = By.cssSelector("div.footer div.left span.a");
    private final By helpCenterLink = By.cssSelector("a[href*='hotrokythuat.utc.edu.vn']");
    private final By feedbackLink = By.cssSelector("a[href^='mailto:hotrokythuat@utc.edu.vn']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getFormHeaderText() {
        return getText(formHeader);
    }

    public boolean isUsernameFieldDisplayed() {
        return isDisplayed(usernameInput);
    }

    public String getUsernamePlaceholder() {
        return getAttribute(usernameInput, "placeholder");
    }

    public boolean isPasswordFieldDisplayed() {
        return isDisplayed(passwordInput);
    }

    public String getPasswordPlaceholder() {
        return getAttribute(passwordInput, "placeholder");
    }

    public String getPasswordFieldType() {
        return getAttribute(passwordInput, "type");
    }

    public boolean isPersistentCheckboxDisplayed() {
        return isDisplayed(persistentCheckbox);
    }

    public boolean isPersistentCheckboxSelected() {
        return isSelected(persistentCheckbox);
    }

    public void clickPersistentCheckboxLabel() {
        click(persistentLabel);
    }

    public boolean isSubmitButtonDisplayed() {
        return isDisplayed(submitButton);
    }

    public String getSubmitButtonValue() {
        return getAttribute(submitButton, "value");
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public boolean isSsoButtonDisplayed() {
        return isDisplayed(ssoButton);
    }

    public String getSsoButtonText() {
        return getText(ssoButton);
    }

    public String getSsoButtonHref() {
        return getAttribute(ssoButton, "href");
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return isDisplayed(forgotPasswordLink);
    }

    public String getForgotPasswordHref() {
        return getAttribute(forgotPasswordLink, "href");
    }

    public void enterUsername(String username) {
        type(usernameInput, username);
    }

    public String getUsernameValue() {
        return getAttribute(usernameInput, "value");
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public String getPasswordValue() {
        return getAttribute(passwordInput, "value");
    }

    public String getBannerTitleText() {
        return getText(bannerTitle);
    }

    public String getBannerSubtitleText() {
        return getText(bannerSubtitle);
    }

    public String getFooterCopyrightText() {
        return getText(footerCopyright);
    }

    public boolean isHelpCenterLinkDisplayed() {
        return isDisplayed(helpCenterLink);
    }

    public boolean isFeedbackLinkDisplayed() {
        return isDisplayed(feedbackLink);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
    }
}
