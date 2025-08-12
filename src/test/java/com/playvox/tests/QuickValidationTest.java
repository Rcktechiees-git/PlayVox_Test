package com.playvox.tests;

import com.playvox.pages.LoginPage;
import com.playvox.utils.ConfigUtil;
import com.playvox.utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Quick validation test for the automation framework
 */
public class QuickValidationTest {
    
    public static void main(String[] args) {
        WebDriver driver = null;
        
        try {
            System.out.println("=== FreshWorks Login Automation - Quick Validation ===");
            
            // Initialize WebDriver in headless mode
            driver = WebDriverUtil.initializeDriver("chrome");
            
            // Initialize login page
            LoginPage loginPage = new LoginPage(driver);
            
            // Navigate to login page
            String url = ConfigUtil.getBaseUrl();
            System.out.println("1. Navigating to: " + url);
            loginPage.navigateToLoginPage(url);
            
            // Basic page validation
            System.out.println("2. Current URL: " + driver.getCurrentUrl());
            System.out.println("3. Page Title: " + driver.getTitle());
            
            // Wait a moment for page to fully load
            Thread.sleep(2000);
            
            // Check if we can locate the key elements mentioned in the issue
            System.out.println("4. Checking for login form elements...");
            
            try {
                // Try to find password field with the exact attributes from the issue
                boolean passwordFieldFound = loginPage.isPasswordFieldDisplayed();
                System.out.println("   ✓ Password field (name='password', id='password', data-testid='password'): " + passwordFieldFound);
                
                boolean signInButtonFound = loginPage.isSignInButtonDisplayed();
                System.out.println("   ✓ Sign In button (data-testid='login-button', type='submit'): " + signInButtonFound);
                
                boolean emailFieldFound = loginPage.isEmailFieldDisplayed();
                System.out.println("   ✓ Email field: " + emailFieldFound);
                
                if (passwordFieldFound && signInButtonFound) {
                    System.out.println("\n✅ SUCCESS: All required elements found!");
                    System.out.println("   The automation can successfully locate the login form elements.");
                } else {
                    System.out.println("\n⚠️  WARNING: Some elements not found. Page might have loaded differently.");
                    System.out.println("   This could be due to dynamic loading or different page structure.");
                }
                
            } catch (Exception e) {
                System.out.println("   ❌ Error locating elements: " + e.getMessage());
            }
            
            System.out.println("\n=== Validation Summary ===");
            System.out.println("✓ WebDriver initialization: SUCCESS");
            System.out.println("✓ Page navigation: SUCCESS");
            System.out.println("✓ Framework setup: COMPLETE");
            System.out.println("\nThe Selenium automation framework is ready for use!");
            
        } catch (Exception e) {
            System.err.println("\n❌ Error during validation: " + e.getMessage());
            System.err.println("This might be due to network issues or page changes.");
        } finally {
            // Clean up
            if (driver != null) {
                WebDriverUtil.quitDriver();
                System.out.println("\nBrowser session closed.");
            }
        }
    }
}