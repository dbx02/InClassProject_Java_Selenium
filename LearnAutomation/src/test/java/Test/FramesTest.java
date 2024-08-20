package Test;

import Base.BaseTest;
import Help.HelpMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FramesTest extends BaseTest {
    public HelpMethods helpMethods;

    @Test
    public void frames() {
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
        optionsListFrames.get(2).click();

        //exemplu de xpath care identifica un element dupa text-ul pe care il contine, in acest caz Alerts
        //versiunea 2  - //span[contains(text(),"Alerts")]


        WebElement framesTitle = driver.findElement(By.xpath("//div[@id='framesWrapper']/h1"));
        String title = "Frames";
        helpMethods.verifyText(framesTitle,title);

       // helpMethods.scrollDown();

        //Frame: pagina principala;
        //iFrame: pagina secundara(pagina mica in pagina mare)
        //iFrame-ul poate sa fie identificat dupa id, name sau locator

        driver.switchTo().frame("frame1");

        WebElement textSample = driver.findElement(By.id("sampleHeading"));
        System.out.println(textSample.getText());

        optionsListFrames.get(3).click();
    }
}
