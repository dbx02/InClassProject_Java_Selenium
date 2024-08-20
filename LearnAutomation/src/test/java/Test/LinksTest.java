package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LinksTest extends BaseTest {

    public HelpMethods helpMethods;

    @Test
    public void linksTest() {
        helpMethods = new HelpMethods(driver);

        String expectedResult = "DEMOQA";
        helpMethods.ValidTitlePage(expectedResult);
        helpMethods.scrollDown();
        // ne declaram lista de elemente de pe Homepage
        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
//selectam prima optiune disponibila
        optionsList.get(0).click();

        WebElement checkBoxOption = driver.findElement(By.id("item-5"));
        checkBoxOption.click();

//        WebElement clickHomeFirstLink = driver.findElement(By.id("simpleLink"));
//        clickHomeFirstLink.click();
//
//        helpMethods.switchToNewTab(1);
//        helpMethods.switchToMainTab();

        WebElement clickHomeFirstLink2 = driver.findElement(By.id("dynamicLink"));
        clickHomeFirstLink2.click();
        helpMethods.switchToNewTab(1);
        helpMethods.switchToMainTab();

        WebElement clickCreated = driver.findElement(By.id("created"));
        clickCreated.click();
        helpMethods.scrollIntoViewText();
        //validare pe tot textul
        String expectedYes = "Link has responded with staus 201 and status text Created";
        WebElement messageArea = driver.findElement(By.id("linkResponse"));
        helpMethods.verifyText(messageArea, expectedYes);
        //validare daca contine 201/Created
        helpMethods.verifyContainText();
    }

}
