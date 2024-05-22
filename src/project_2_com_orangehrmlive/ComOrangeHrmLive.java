package project_2_com_orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 *Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class ComOrangeHrmLive {
    //setup chrome browser
    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
        } else {
            System.out.println("Wrong Browser name");
        }
        //open url
        driver.get(baseUrl);
        //windows manage
        driver.manage().window().maximize();
        //set duration time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Print the title of the page
        System.out.println("Title of the page: " + driver.getTitle());
        //print the current url
        System.out.println("Current URL: " + driver.getCurrentUrl());
        //print the page source
        System.out.println("Page source: " + driver.getPageSource());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Click on 'Forgot your password?' link

        driver.findElement(By.className("orangehrm-login-forgot")).click();

        //Print the current Url.
        System.out.println("Current Url: " + driver.getCurrentUrl());

        //Navigate back to the login page.
        driver.navigate().back();

        //Refresh the page.
        driver.navigate().refresh();

        //Enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        //Click on the Login Button
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        //Close the browser.
        driver.close();
    }
}
