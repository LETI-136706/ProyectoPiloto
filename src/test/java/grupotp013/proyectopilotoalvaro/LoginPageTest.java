package grupotp013.proyectopilotoalvaro;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest {

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
    public void validLoginTest() {
        LoginPage page = new LoginPage(driver);
        page.goTo();

        page.login("tomsmith", "SuperSecretPassword!");
        assertTrue(page.isSuccessVisible());
    }
}
