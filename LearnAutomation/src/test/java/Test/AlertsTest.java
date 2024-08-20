package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AlertsTest extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void alertsTest() {
        helpMethods = new HelpMethods(driver);
        String expectedResult = "DEMOQA";
        helpMethods.ValidTitlePage(expectedResult);
        helpMethods.scrollDown();
        // ne declaram lista de elemente de pe Homepage
        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
//selectam prima optiune disponibila
        optionsList.get(2).click();


        List<WebElement> optionsListFrames = driver.findElements(By.xpath("//div[@class='element-list collapse show']/ul/li"));
//selectam prima optiune disponibila
        optionsListFrames.get(1).click();

        WebElement titleAlerts = driver.findElement(By.xpath("//div[@id='javascriptAlertsWrapper']/h1"));
        helpMethods.scrollIntoViewElement(titleAlerts);

        Assert.assertTrue(titleAlerts.getText().equals("Alerts"),"The title is not correct displayed");

//        WebElement firstAlert = driver.findElement(By.id("alertButton"));
//        firstAlert.click();
//
//        Alert alertOK = driver.switchTo().alert();
//        alertOK.accept();
//
//
//        WebElement secondAlert = driver.findElement(By.id("timerAlertButton"));
//        secondAlert.click();
//
//        WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(10));
//        waitAlert.until(ExpectedConditions.alertIsPresent());
//
//        Alert alertOk5seconds = driver.switchTo().alert();
//        alertOk5seconds.accept();

//        WebElement thirdAlert = driver.findElement(By.id("confirmButton"));
//        thirdAlert.click();
//
//        Alert alertThirdCancel = driver.switchTo().alert();
//        alertThirdCancel.dismiss();
//
//        WebElement cancelText = driver.findElement(By.id("confirmResult"));
//        helpMethods.verifyText(cancelText, "You selected Cancel");
//
//        thirdAlert.click();
//        alertThirdCancel.accept();
//        WebElement acceptText = driver.findElement(By.id("confirmResult"));
//        helpMethods.verifyText(acceptText, "You selected Ok");

        WebElement fourthAlert = driver.findElement(By.id("promtButton"));
        fourthAlert.click();

        Alert alert4thOk = driver.switchTo().alert();
        alert4thOk.sendKeys("Alin");
        alert4thOk.accept();

        WebElement accept4thText = driver.findElement(By.id("promptResult"));
        helpMethods.verifyText(accept4thText, "You entered Alin");
    }
}
