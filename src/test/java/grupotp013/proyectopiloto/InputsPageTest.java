package grupotp013.proyectopiloto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputsPageTest {

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
    public void testEnteringNumbers() {
        InputsPage page = new InputsPage(driver);
        page.goTo();

        page.typeNumber("123");
        assertEquals("123", page.getValue());
    }
}
