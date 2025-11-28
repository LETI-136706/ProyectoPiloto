package grupotp013.proyectopiloto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;

    private By uploadInput = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedMessage = By.tagName("h3");

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadInput).sendKeys(filePath);
        driver.findElement(uploadButton).click();
    }

    public String getUploadedMessage() {
        return driver.findElement(uploadedMessage).getText();
    }
}
