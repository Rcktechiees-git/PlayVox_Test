# PlayVox Test - FreshWorks Login Automation

This project contains Selenium-based Java automation for the FreshWorks login page at:
https://rcktechiees-874988466824422142.myfreshworks.com

## Project Structure

```
src/
├── main/java/com/playvox/
│   ├── pages/
│   │   └── LoginPage.java          # Page Object Model for login page
│   └── utils/
│       ├── ConfigUtil.java         # Configuration management utility
│       └── WebDriverUtil.java      # WebDriver management utility
└── test/
    ├── java/com/playvox/tests/
    │   ├── BaseTest.java           # Base test class with setup/teardown
    │   └── LoginTest.java          # Login automation test cases
    └── resources/
        ├── config.properties       # Configuration properties
        └── testng.xml             # TestNG test suite configuration
```

## Features

- **Page Object Model (POM)**: Clean separation of page elements and test logic
- **WebDriver Management**: Automatic driver setup using WebDriverManager
- **Cross-browser Support**: Chrome, Firefox, and Edge browsers
- **Configuration Management**: Externalized configuration through properties file
- **TestNG Integration**: Comprehensive test framework with reporting
- **Robust Element Locators**: Multiple fallback strategies for element identification

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Chrome, Firefox, or Edge browser installed

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd PlayVox_Test
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

3. Update test credentials in `src/test/resources/config.properties`:
   ```properties
   test.email=your-actual-email@example.com
   test.password=your-actual-password
   ```

## Running the Tests

### Run all tests:
```bash
mvn test
```

### Run with specific browser:
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
mvn test -Dbrowser=edge
```

### Run specific test class:
```bash
mvn test -Dtest=LoginTest
```

### Run with TestNG XML:
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

## Test Cases

1. **testLoginPageElements**: Verifies all login page elements are displayed
2. **testLoginPageNavigation**: Validates navigation to the login page
3. **testValidLogin**: Tests the complete login flow with credentials
4. **testFormFieldInteractions**: Tests individual form field operations
5. **testLoginPageBasics**: Verifies basic page functionality and title

## Configuration

Edit `src/test/resources/config.properties` to customize:
- Base URL
- Browser type
- Timeout values
- Test credentials

## Key Page Elements Automated

Based on the provided HTML elements:
- **Email Field**: Dynamically located email input field
- **Password Field**: `input[name="password"][id="password"][data-testid="password"]`
- **Sign In Button**: `button[data-testid="login-button"][type="submit"]`
- **Additional Elements**: Forgot Password link, Sign in with Google button

## WebDriver Features

- **Automatic Driver Management**: No need to download drivers manually
- **Implicit Waits**: 10-second default wait for elements
- **Explicit Waits**: Dynamic waiting for specific conditions
- **Window Management**: Automatic window maximization
- **Cross-platform Support**: Works on Windows, macOS, and Linux

## Error Handling

- Robust element location with multiple fallback strategies
- Proper exception handling in utility classes
- Graceful test failure handling
- Comprehensive logging for debugging

## Reporting

TestNG generates detailed HTML reports in `target/surefire-reports/` after test execution.

## Troubleshooting

1. **Browser not found**: Ensure the specified browser is installed
2. **Driver issues**: WebDriverManager automatically handles driver downloads
3. **Element not found**: Check if page structure has changed
4. **Timeout issues**: Increase timeout values in config.properties

## Contributing

1. Follow the existing code structure and naming conventions
2. Add appropriate JavaDoc comments
3. Include test cases for new functionality
4. Update this README for any significant changes