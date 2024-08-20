package Base;

import Test.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    //driverul va fi tot timpul public
    //Arhitectura codului: base test cuprinde preconditiile @before si @aftertest
    //Help cuprinde metodele generale
    //Test cuprinde pasii in sine pe care vrem sa-i rulam

    //Ne declaram driverul

    public WebDriver driver;

    //@before o metoda care ruleaza de fiecare data inaintea metodei de test
    @BeforeMethod
    public void openSite() {
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    //@after metoda care ruleaza dupa fiecare metoda de test

//    @AfterMethod
//    public void closeSite() {
//        driver.quit();
//        //close inchide fereastra curenta a driverului; quit inchide instanta de driver

    }


