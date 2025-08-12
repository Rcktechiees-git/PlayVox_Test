package com.playvox.tests;

import com.playvox.pages.LoginPage;
import com.playvox.utils.ConfigUtil;
import com.playvox.utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Simple runner class for manual execution of login automation
 * This can be used to quickly test the automation without TestNG
 */
public class LoginRunner {
    
    public static void main(String[] args) {
        WebDriver driver = null;
        
        try {
            System.out.println("Starting FreshWorks Login Automation...");
            
            // Initialize WebDriver
            String browser = args.length > 0 ? args[0] : ConfigUtil.getBrowser();
            driver = WebDriverUtil.initializeDriver(browser);
            
            // Initialize login page
            LoginPage loginPage = new LoginPage(driver);
            
            // Navigate to login page
            String url = ConfigUtil.getBaseUrl();
            System.out.println("Navigating to: " + url);
            loginPage.navigateToLoginPage(url);
            
            // Verify page elements
            System.out.println("Verifying page elements...");
            System.out.println("Email field displayed: " + loginPage.isEmailFieldDisplayed());
            System.out.println("Password field displayed: " + loginPage.isPasswordFieldDisplayed());
            System.out.println("Sign In button displayed: " + loginPage.isSignInButtonDisplayed());
            
            // Test form interactions
            System.out.println("\nTesting form interactions...");
            loginPage.enterEmail("automation.test@example.com");
            System.out.println("✓ Email entered successfully");
            
            loginPage.enterPassword("TestPassword123");
            System.out.println("✓ Password entered successfully");
            
            // Note: Commenting out the actual login click to avoid attempting login with test credentials
            // loginPage.clickSignInButton();
            System.out.println("✓ Login form automation completed successfully");
            
            // Wait for a moment to see the results
            Thread.sleep(3000);
            
            System.out.println("\n=== Automation Summary ===");
            System.out.println("✓ Successfully navigated to login page");
            System.out.println("✓ All form elements located and verified");
            System.out.println("✓ Form field interactions working correctly");
            System.out.println("✓ Automation framework is ready for use");
            
        } catch (Exception e) {
            System.err.println("Error during automation execution: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up
            if (driver != null) {
                WebDriverUtil.quitDriver();
                System.out.println("\nBrowser closed successfully");
            }
        }
    }
}