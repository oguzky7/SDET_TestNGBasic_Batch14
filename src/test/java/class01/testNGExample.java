package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGExample {
    public static WebDriver driver;

    @BeforeMethod
    public void SetupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod()
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }

    //  --Test1--
    //  go to syntax HRMS
    //  enter the username and password, verify that u logged in
    //  close the browser

    @Test
    public void LoginFunctionality(){
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement login = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        login.click();
    }
    //  --Test2--
    //  go to syntax HRMS
    //  verify the login button is there
    //  close the browser
    @Test
    public void LoginBtnVerification(){
        WebElement login = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        System.out.println(login.isDisplayed());
    }


}
