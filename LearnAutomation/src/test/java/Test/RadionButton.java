package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RadionButton extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void radioButton() {
        helpMethods = new HelpMethods(driver);

        String expectedResult = "DEMOQA";
        helpMethods.ValidTitlePage(expectedResult);

        helpMethods.scrollDown();

        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
//selectam prima optiune disponibila
        optionsList.get(0).click();

        WebElement radioButtonOpt = driver.findElement(By.id("item-2"));
        radioButtonOpt.click();

        helpMethods.scrollDown();
//

        List<WebElement> radioButtonList = driver.findElements(By.xpath("//div/label"));
//selectam prima optiune disponibila
        radioButtonList.get(0).click();

//        WebElement checkYesRadioButton = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[2]/div[2]"));
//        checkYesRadioButton.click();
        String expectedYes = "You have selected Yes";
        WebElement messageArea = driver.findElement(By.xpath("//p[@class='mt-3']"));

        helpMethods.verifyOptions(messageArea, expectedYes);

        radioButtonList.get(1).click();
        String expectedImpressive = "You have selected Impressive";
        helpMethods.verifyOptions(messageArea, expectedImpressive);

        //validam faptul ca butonul no este disabled
        //trebuie sa verific faptul ca in valarea atributului exista meniunea disabled

        String disabledAttribute = radioButtonList.get(2).getAttribute("class");
        Assert.assertTrue(disabledAttribute.contains("disabled"), "The text doens not contains disabled");
    }
}


