package grupotp013.proyectopiloto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CheckboxesPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckboxes() {
        CheckboxesPage page = new CheckboxesPage(driver);
        page.goTo();

        // Seleccionar checkbox 1
        page.checkCheckbox1();
        assertTrue(page.isCheckbox1Selected());

        // Deseleccionar checkbox 1
        page.uncheckCheckbox1();
        assertFalse(page.isCheckbox1Selected());

        // Checkbox 2 viene seleccionado por defecto → comprobamos
        assertTrue(page.isCheckbox2Selected());
    }
}
