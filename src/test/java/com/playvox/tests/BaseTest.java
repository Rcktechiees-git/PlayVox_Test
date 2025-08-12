package com.playvox.tests;

import com.playvox.utils.ConfigUtil;
import com.playvox.utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Base test class for common setup and teardown operations
 */
public class BaseTest {
    
    protected WebDriver driver;
    protected String baseUrl;
    
    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        // Use parameter if provided, otherwise use config
        String browserType = (browser != null) ? browser : ConfigUtil.getBrowser();
        
        // Initialize WebDriver
        driver = WebDriverUtil.initializeDriver(browserType);
        
        // Get base URL from configuration
        baseUrl = ConfigUtil.getBaseUrl();
        
        System.out.println("Test setup completed with browser: " + browserType);
        System.out.println("Base URL: " + baseUrl);
    }
    
    @AfterMethod
    public void tearDown() {
        // Close browser and quit driver
        WebDriverUtil.quitDriver();
        System.out.println("Test teardown completed");
    }
}