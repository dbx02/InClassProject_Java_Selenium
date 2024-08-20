package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void webTablesTest() {
        helpMethods = new HelpMethods(driver);
        String expectedResult = "DEMOQA";
        helpMethods.ValidTitlePage(expectedResult);
        helpMethods.scrollDown();
        // ne declaram lista de elemente de pe Homepage
        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='card mt-4 top-card']"));
//selectam prima optiune disponibila
        optionsList.get(0).click();

        WebElement checkBoxOption = driver.findElement(By.id("item-3"));
        checkBoxOption.click();

       helpMethods.scrollDown();

//       WebElement addBtn = driver.findElement(By.id("addNewRecordButton"));
//       addBtn.click();
//
//       WebElement firstNameField = driver.findElement(By.id("firstName"));
//       firstNameField.sendKeys("FirstNameTest");
       //de continuat acasa pentru toate field-urile

//        WebElement clickEditBtn = driver.findElement(By.xpath("//div[@class='action-buttons']/span"));
//        clickEditBtn.click();
//
//        WebElement firstNameFieldCompleted = driver.findElement(By.id("firstName"));
//        firstNameFieldCompleted.click();
//        firstNameFieldCompleted.clear();
//        firstNameFieldCompleted.sendKeys("Test");

        WebElement searchBar = driver.findElement(By.id("searchBox"));
        helpMethods.scrollIntoViewElement(searchBar);
        searchBar.sendKeys("Alden");

        WebElement deleteOpt = driver.findElement(By.id("delete-record-2"));
        deleteOpt.click();

    }
}
