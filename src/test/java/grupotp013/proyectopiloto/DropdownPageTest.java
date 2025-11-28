package grupotp013.proyectopiloto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownPageTest {

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
    public void testDropdown() {
        DropdownPage page = new DropdownPage(driver);
        page.goTo();

        page.selectOption("Option 1");
        assertEquals("Option 1", page.getSelectedOption());

        page.selectOption("Option 2");
        assertEquals("Option 2", page.getSelectedOption());
    }
}
