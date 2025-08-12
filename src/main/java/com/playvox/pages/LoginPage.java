package com.playvox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

/**
 * Page Object Model class for FreshWorks Login Page
 */
public class LoginPage {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Page Elements using FindBy annotations
    @FindBy(xpath = "//input[@type='email' or contains(@placeholder, 'Email') or @name='email' or @id='email']")
    private WebElement emailField;
    
    @FindBy(xpath = "//input[@name='password' and @id='password' and @data-testid='password']")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@data-testid='login-button' and @type='submit']")
    private WebElement signInButton;
    
    @FindBy(xpath = "//a[contains(text(), 'Forgot Password') or contains(text(), 'Forgot password')]")
    private WebElement forgotPasswordLink;
    
    @FindBy(xpath = "//button[contains(text(), 'Sign in with Google')]")
    private WebElement signInWithGoogleButton;
    
    @FindBy(xpath = "//h1[contains(text(), 'Sign in')] | //h2[contains(text(), 'Sign in')]")
    private WebElement pageTitle;
    
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Navigate to the login page
     * @param url Login page URL
     */
    public void navigateToLoginPage(String url) {
        driver.get(url);
        waitForPageToLoad();
    }
    
    /**
     * Wait for the login page to load completely
     */
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
    }
    
    /**
     * Enter email in the email field
     * @param email Email address
     */
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }
    
    /**
     * Enter password in the password field
     * @param password Password
     */
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    /**
     * Click the Sign In button
     */
    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }
    
    /**
     * Perform complete login operation
     * @param email Email address
     * @param password Password
     */
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignInButton();
    }
    
    /**
     * Click forgot password link
     */
    public void clickForgotPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        forgotPasswordLink.click();
    }
    
    /**
     * Click Sign in with Google button
     */
    public void clickSignInWithGoogle() {
        wait.until(ExpectedConditions.elementToBeClickable(signInWithGoogleButton));
        signInWithGoogleButton.click();
    }
    
    /**
     * Check if login page is displayed
     * @return true if page title is visible
     */
    public boolean isLoginPageDisplayed() {
        try {
            return pageTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get the page title text
     * @return Page title text
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    /**
     * Check if email field is displayed
     * @return true if email field is visible
     */
    public boolean isEmailFieldDisplayed() {
        try {
            return emailField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Check if password field is displayed
     * @return true if password field is visible
     */
    public boolean isPasswordFieldDisplayed() {
        try {
            return passwordField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Check if sign in button is displayed
     * @return true if sign in button is visible
     */
    public boolean isSignInButtonDisplayed() {
        try {
            return signInButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}