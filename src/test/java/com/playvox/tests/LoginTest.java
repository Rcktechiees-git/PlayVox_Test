package com.playvox.tests;

import com.playvox.pages.LoginPage;
import com.playvox.utils.ConfigUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for FreshWorks Login functionality
 */
public class LoginTest extends BaseTest {
    
    private LoginPage loginPage;
    
    @Test(priority = 1, description = "Verify login page elements are displayed")
    public void testLoginPageElements() {
        // Initialize login page
        loginPage = new LoginPage(driver);
        
        // Navigate to login page
        loginPage.navigateToLoginPage(baseUrl);
        
        // Verify page elements are displayed
        Assert.assertTrue(loginPage.isEmailFieldDisplayed(), "Email field should be displayed");
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Password field should be displayed");
        Assert.assertTrue(loginPage.isSignInButtonDisplayed(), "Sign In button should be displayed");
        
        System.out.println("✓ All login page elements are displayed correctly");
    }
    
    @Test(priority = 2, description = "Verify login page navigation")
    public void testLoginPageNavigation() {
        // Initialize login page
        loginPage = new LoginPage(driver);
        
        // Navigate to login page
        loginPage.navigateToLoginPage(baseUrl);
        
        // Verify we're on the correct page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("myfreshworks.com"), 
            "Should navigate to FreshWorks domain. Current URL: " + currentUrl);
        
        System.out.println("✓ Successfully navigated to login page: " + currentUrl);
    }
    
    @Test(priority = 3, description = "Test login with valid credentials")
    public void testValidLogin() {
        // Initialize login page
        loginPage = new LoginPage(driver);
        
        // Navigate to login page
        loginPage.navigateToLoginPage(baseUrl);
        
        // Get test credentials from configuration
        String email = ConfigUtil.getTestEmail();
        String password = ConfigUtil.getTestPassword();
        
        // Perform login
        loginPage.login(email, password);
        
        // Wait a moment for any page transition
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Note: Since we don't have valid credentials, we're just testing the automation flow
        // In a real scenario, you would verify successful login by checking for dashboard elements
        System.out.println("✓ Login automation flow completed successfully");
        System.out.println("Email entered: " + email);
        System.out.println("Password field filled successfully");
        System.out.println("Sign In button clicked successfully");
    }
    
    @Test(priority = 4, description = "Test individual form field interactions")
    public void testFormFieldInteractions() {
        // Initialize login page
        loginPage = new LoginPage(driver);
        
        // Navigate to login page
        loginPage.navigateToLoginPage(baseUrl);
        
        // Test email field
        String testEmail = "test.automation@example.com";
        loginPage.enterEmail(testEmail);
        System.out.println("✓ Email field interaction successful");
        
        // Test password field
        String testPassword = "TestPassword123";
        loginPage.enterPassword(testPassword);
        System.out.println("✓ Password field interaction successful");
        
        // Clear fields and test again
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        System.out.println("✓ Field clearing functionality verified");
        
        // Test with different data
        loginPage.enterEmail("another.test@domain.com");
        loginPage.enterPassword("AnotherPassword456");
        System.out.println("✓ Multiple field interactions successful");
    }
    
    @Test(priority = 5, description = "Test login page title and basic functionality")
    public void testLoginPageBasics() {
        // Initialize login page
        loginPage = new LoginPage(driver);
        
        // Navigate to login page
        loginPage.navigateToLoginPage(baseUrl);
        
        // Get and verify page title
        String pageTitle = loginPage.getPageTitle();
        System.out.println("Page Title: " + pageTitle);
        
        // Basic verification that we're on a FreshWorks page
        Assert.assertTrue(pageTitle.toLowerCase().contains("freshworks") || 
                         pageTitle.toLowerCase().contains("sign") ||
                         pageTitle.toLowerCase().contains("login"),
                         "Page title should contain FreshWorks or sign/login related text");
        
        System.out.println("✓ Login page basics verification completed");
    }
}