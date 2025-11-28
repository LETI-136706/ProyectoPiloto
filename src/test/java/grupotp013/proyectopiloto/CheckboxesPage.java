package grupotp013.proyectopiloto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {

    private WebDriver driver;

    private By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public void checkCheckbox1() {
        WebElement cb1 = driver.findElement(checkbox1);
        if (!cb1.isSelected()) cb1.click();
    }

    public void uncheckCheckbox1() {
        WebElement cb1 = driver.findElement(checkbox1);
        if (cb1.isSelected()) cb1.click();
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }
}
