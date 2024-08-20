package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.time.Duration;
import java.util.List;

public class ButtonTest extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void buttonTest() {
        helpMethods = new HelpMethods(driver);


        String expectedResult = "DEMOQA";
        helpMethods.ValidTitlePage(expectedResult);
        helpMethods.scrollDown();
        // ne declaram lista de elemente de pe Homepage
        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
//selectam prima optiune disponibila
        optionsList.get(0).click();

        WebElement checkBoxOption = driver.findElement(By.id("item-4"));
        checkBoxOption.click();

        //helpMethods.scrollDown();

//        WebElement clickMe = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[2]/div[3]/button"));
//        clickMe.click();

//        String expectedYes = "You have done a dynamic click";
//        WebElement messageArea = driver.findElement(By.id("dynamicClickMessage"));
//        helpMethods.verifyText(messageArea, expectedYes);

//        WebElement clickDoubleClickMe = driver.findElement(By.id("doubleClickBtn"));
//        helpMethods.doubleClick(clickDoubleClickMe);
//
        helpMethods.scrollDown();

//        String expectedResults = "You have done a double click";
//        WebElement messageArea = driver.findElement(By.id("doubleClickMessage"));
//        helpMethods.verifyMessageFromClick(messageArea,expectedResults);

        WebElement rightClickMe = driver.findElement(By.id("rightClickBtn"));
        helpMethods.rightClick(rightClickMe);


        String expectedResults = "You have done a right click";
        WebElement messageArea = driver.findElement(By.id("rightClickMessage"));
        helpMethods.scrollIntoViewElement(messageArea);
        helpMethods.verifyMessageFromClick(messageArea, expectedResults);

    }
}
