package Test;

//trebuie sa ajungem pana la checkbox

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void checkBox() {
        helpMethods = new HelpMethods(driver);

        String expectedResult = "DEMOQA";
        helpMethods.ValidTitlePage(expectedResult);

// ne declaram lista de elemente de pe Homepage
        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
//selectam prima optiune disponibila
        optionsList.get(0).click();

        WebElement checkBoxOption = driver.findElement(By.id("item-1"));
        checkBoxOption.click();
        helpMethods.scrollDown();

        WebElement expandFirstOption = driver.findElement(By.xpath("//div[@id='tree-node']/ol/li/span/button"));
        expandFirstOption.click();

        ////div[@id='tree-node']//ol/li/span/button//path
        //div[@id='tree-node']/ol/li/span/button

//        WebElement expandDesktopToggle = driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']//li/span/label/span[1]"));
//        expandDesktopToggle.click();

        //am folosit for pentru a face check la toate 3 checbox-uri
        List<WebElement> subOptionsList = driver.findElements(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']//li/span//label/span[1]"));
        for (WebElement checkbox : subOptionsList) {
            checkbox.click();
        }

        WebElement expandAll = driver.findElement(By.xpath("//button[@class='rct-option rct-option-expand-all']"));
        expandAll.click();

        //helpMethods.scrollDown();

        helpMethods.scrollIntoViewCheckbox();

        List<WebElement> resultSubmit = driver.findElements(By.xpath("//div[@id='result']/span"));
        Assert.assertTrue(resultSubmit.get(5).getText().contains("documents"), "The text contains documents");
    }
}
