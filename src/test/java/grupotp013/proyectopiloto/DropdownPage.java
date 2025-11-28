package grupotp013.proyectopiloto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    private WebDriver driver;

    private By dropdownMenu = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String visibleText) {
        WebElement dropdown = driver.findElement(dropdownMenu);
        Select menu = new Select(dropdown);
        menu.selectByVisibleText(visibleText);
    }

    public String getSelectedOption() {
        WebElement dropdown = driver.findElement(dropdownMenu);
        Select menu = new Select(dropdown);
        return menu.getFirstSelectedOption().getText();
    }
}
