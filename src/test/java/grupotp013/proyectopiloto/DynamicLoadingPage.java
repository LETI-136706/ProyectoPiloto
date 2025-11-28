package grupotp013.proyectopiloto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLoadingPage {

    private WebDriver driver;

    private By startButton = By.cssSelector("#start button");
    private By finishText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void clickStart() {
        driver.findElement(startButton).click();
    }

    public String waitForFinishText() {
        WebElement finish = driver.findElement(finishText);
        return finish.getText();
    }
}
