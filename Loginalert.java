package selenium.textscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Loginalert
{
    static WebDriver driver;
    //launching browser
    public static void start()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    //Automating the login page by sending  user data
    public static void senddata() throws IOException {
        Properties properties=new Properties();
        String propertiesPath=("user.dir")+"url2";
        FileInputStream fileInputStream=new FileInputStream( propertiesPath);
        properties.load(fileInputStream);
        Loginalert.driver.get(properties.getProperty("url1"));

        WebElement username = driver.findElement(By.id("userId"));
        System.out.println(" Is Displayed "+ username.isDisplayed());
        WebElement password = driver.findElement(By.id("pwd"));
        System.out.println(" Is Displayed "+ password.isDisplayed());
        WebElement login = driver.findElement(By.xpath("login_button"));
        username.sendKeys("email");
        password.sendKeys("pass");
        login.click();

    }
    //Testing the url is login to the next page
    public static void test()
    {
        String actualUrl="Url3";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("True");

        }
        else
        {
            System.out.println("False");
        }
    }
    //close the driver
    public static void close()
    {
        driver.quit();
    }
}


