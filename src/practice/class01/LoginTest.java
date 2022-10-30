package practice.class01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
   // @BeforeMethod
    @BeforeClass
    public void openAndNavigate() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void validAdminLogin() {
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        WebElement validationMsg =driver.findElement(By.xpath("//h2[contains(text(),'List of All Orders')]"));
        if(validationMsg.isDisplayed()){
            System.out.println("Login Test Pass");
        }else{
            System.out.println("Login Test Fail");
        }

    }
    @Test(priority = 2)
    public void titleValidation(){
        String expectedTitle="Web Orders";
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title is valid. Test Pass");
        }else{
            System.out.println("Title isn't valid. Test Fail");
        }
    }
   // @AfterMethod
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

    }
