package grupotp013.proyectopiloto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputsPage {

    private WebDriver driver;
    private By inputField = By.cssSelector("input[type='number']");

    public InputsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    public void typeNumber(String number) {
        WebElement input = driver.findElement(inputField);
        input.clear();
        input.sendKeys(number);
    }

    public String getValue() {
        return driver.findElement(inputField).getAttribute("value");
    }
}
