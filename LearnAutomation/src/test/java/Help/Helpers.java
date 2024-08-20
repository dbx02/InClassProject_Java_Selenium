package Help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helpers {




    public void clickElement(WebDriver driver) {
        String elements = "#app > div > div > div.home-body > div > div:nth-child(1) > div";
        WebElement clickElement = driver.findElement(By.cssSelector(elements));
        clickElement.click();
    }

    public void clickOnTextBox(WebDriver driver) {
        String textBox = "//*[@id=\"item-0\"]";
        WebElement textBoxClick = driver.findElement(By.xpath(textBox));
        textBoxClick.click();
    }
}
