package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginServiceTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mansheen Kaur\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Optional: run in headless mode
        driver = new ChromeDriver(options);
    }

    @Test
    public void testLoginSuccess() {
        driver.get("file:\\C:\\Users\\Mansheen Kaur\\Desktop\\Trimester-3\\Software Quality & Testing\\java_projects\\pages\\login.html");

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement dob = driver.findElement(By.id("dob"));

        // Enter username and password
        usernameInput.sendKeys("ahsan");
        passwordInput.sendKeys("ahsan_pass");
        dob.sendKeys("07-05-2000");

        // Submit the form
        passwordInput.submit();

        // Wait for the login status element to be present
        WebElement loginStatusElement = driver.findElement(By.id("login-status"));
        String loginStatus = loginStatusElement.getText();

        Assert.assertEquals("success", loginStatus);
    }

    @Test
    public void testLoginFailure() {
        driver.get("file:\\C:\\Users\\Mansheen Kaur\\Desktop\\Trimester-3\\Software Quality & Testing\\java_projects\\pages\\login.html");

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        WebElement dob = driver.findElement(By.id("dob"));

        // Enter incorrect username and password
        usernameInput.sendKeys("wrong_username");
        passwordInput.sendKeys("wrong_password");
        dob.sendKeys("07-04-2000");

        // Submit the form
        passwordInput.submit();

        // Wait for the login status element to be present
        WebElement loginStatusElement = driver.findElement(By.id("login-status"));
        String loginStatus = loginStatusElement.getText();

        Assert.assertEquals("fail", loginStatus);
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
