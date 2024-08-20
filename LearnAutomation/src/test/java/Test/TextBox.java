package Test;

import Base.BaseTest;
import Help.HelpMethods;
import Help.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TextBox extends BaseTest {

    //declar un obiect cu metode generale pentru pagina
    public HelpMethods helpMethods;
    //declar un obiect de tipul HelpMethods care ma va lasa sa apelez metodele din clasa respectiva


    @Test
    public void completeForm() {


        helpMethods = new HelpMethods(driver);

        String expectedResult = "DEMOQA";
        helpMethods.ValidTitlePage(expectedResult);
        helpMethods.scrollDown();

// ne declaram lista de elemente de pe Homepage
        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
//selectam prima optiune disponibila
        optionsList.get(0).click();

        WebElement textBoxOption = driver.findElement(By.id("item-0"));
        textBoxOption.click();
        helpMethods.scrollDown();

        WebElement fullNameField = driver.findElement(By.id("userName"));
        fullNameField.sendKeys("Popescu Ion");

        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys("abc@email.com");

        WebElement addressField = driver.findElement(By.id("currentAddress"));
        addressField.sendKeys("Test");

        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        permanentAddressField.sendKeys("Test");

        helpMethods.scrollDown();

        WebElement submitBtn = driver.findElement(By.id("submit"));
        submitBtn.click();

        List<WebElement> resultSubmit = driver.findElements(By.xpath("//div[@class='border col-md-12 col-sm-12']/p"));


        Assert.assertTrue(resultSubmit.get(0).getText().contains("Popescu Ion"), "Numele afisat nu este cel introdus");
        Assert.assertTrue(resultSubmit.get(1).getText().contains("abc@email.com"), "Email-ul afisat nu este cel introdus");
        Assert.assertTrue(resultSubmit.get(2).getText().contains("Test"), "Adressa afisat nu este cel introdus");
        Assert.assertTrue(resultSubmit.get(3).getText().contains("Test"), "Permanent Address afisat nu este cel introdus");


//        helper.clickElement(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        System.out.println("A dat click");
//
////        helper.expandElementClick(driver);
////        System.out.println("A dat click pe expand");
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        WebElement textBox = driver.findElement(By.id("item-0"));
//        Assert.assertTrue(textBox.isDisplayed(), "Text box is not displayed");
//        System.out.println("Textbox a fost gasit");
//
//        helper.clickOnTextBox(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        System.out.println("A dat click");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        WebElement text = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/h1"));
//        Assert.assertTrue(text.isDisplayed(), "TextBox is not displayed");
//        System.out.println("TextBox a fost deschis");


    }
}