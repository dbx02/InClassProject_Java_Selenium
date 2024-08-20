package Help;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Set;

public class HelpMethods {
    private WebDriver driver;

    //creem un constructor
    //this arata spre variabila din clasa in momentul in care am aceelasi nume la parametru
    //constructorii vor fi 90% de tipul public

    public HelpMethods(WebDriver driver){
        this.driver = driver;
    }



    //creem o metoda generala care ne valideaza pagina curenta

    public void ValidTitlePage(String title){
        String actualResult = driver.getTitle();
        Assert.assertTrue(actualResult.equals(title), "Titlul paginii nu este cel corect");
    }


    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void scrollIntoViewCheckbox(){
        // Stating the Javascript Executor driver
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
// Find Problem of the day text
        WebElement Stop = driver.findElement(By.id("result"));
// Scroll to the specific position
        js1.executeScript("arguments[0].scrollIntoView(true);", Stop);
    }

    public void verifyOptions(WebElement element, String name){
        Assert.assertTrue(element.getText().equals(name), "The radio option was not correctly selected");
    }

    public void switchToNewTab(int indexTab){
        ArrayList<String> tabOpen = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabOpen.get(indexTab));
        System.out.println("Titlul paginii este: " + driver.getTitle());
        driver.close();
    }

    public void switchToMainTab(){
        ArrayList<String> mainTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(mainTab.get(0));
        System.out.println("Titlul paginii este: " + driver.getTitle());
    }

    public void scrollIntoViewText(){
        // Stating the Javascript Executor driver
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
// Find Problem of the day text
        WebElement Stop = driver.findElement(By.id("linkResponse"));
// Scroll to the specific position
        js1.executeScript("arguments[0].scrollIntoView(true);", Stop);
    }

    public void verifyText(WebElement element, String name){
        Assert.assertTrue(element.getText().equals(name), "The response text is  not correctly displayed");
    }

    public void verifyContainText(){
        WebElement responseTxt = driver.findElement(By.id("linkResponse"));
        System.out.println(responseTxt.getText());
        Assert.assertTrue(responseTxt.getText().contains("201"), "The text does not contain '201' ");
        Assert.assertTrue(responseTxt.getText().contains("Created"), "The text does not contain 'Created' ");

    }

    public void scrollIntoViewElement(WebElement element){
        // Stating the Javascript Executor driver
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
// Scroll to the specific position
        js1.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void doubleClick(WebElement element){
        Actions doubleClick = new Actions(driver);
        doubleClick.doubleClick(element).perform();
    }

    public void verifyMessageFromClick(WebElement element, String textMessage){
        Assert.assertTrue(element.getText().equals(textMessage), "The message is not properly displayed");
    }

    public void rightClick(WebElement element){
        Actions rightClick = new Actions(driver);
        rightClick.contextClick(element).perform();
    }

    public void switchSecondaryWindow() {
        String mainWindowHandle = driver.getWindowHandle();

        // Get all window handles after the pop-up might appear
        Set<String> allHandlesAfter = driver.getWindowHandles();

        // Identify the pop-up window handle
        String popUpHandle = "";
        for (String handle : allHandlesAfter) {
            if (!handle.equals(mainWindowHandle)) {
                popUpHandle = handle;
                break;
            }
        }
    }

    public void switchMainWindow() {
        String mainWindowHandle = "";
        driver.switchTo().window(mainWindowHandle);
    }

}
