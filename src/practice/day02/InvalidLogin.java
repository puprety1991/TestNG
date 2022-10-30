package practice.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InvalidLogin {
    WebDriver driver;
    @BeforeClass
    public void openAndNavigate() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void InvalidAdminLogin() {
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Teter");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        String errorMsgText = driver.findElement(By.xpath("//span[contains(text(),'Invalid Login or Password.')]")).getText();
        String expectedErrorMsg = "Invalid Login or Password.";

        /*
        if(errorMsgText.equals(expectedErrorMsg)){
            System.out.println("Error message 'Invalid Login or Password' is displayed. Test Passed");
        }else{
            System.out.println("Error message is not present. Test Fail");
        }*/
        Assert.assertEquals(errorMsgText,expectedErrorMsg);

    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
