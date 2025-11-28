package grupotp013.proyectopiloto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicLoadingPageTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDynamicLoading() {
        DynamicLoadingPage page = new DynamicLoadingPage(driver);
        page.goTo();

        page.clickStart();

        WebElement finish = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );

        assertEquals("Hello World!", finish.getText());
    }
}
