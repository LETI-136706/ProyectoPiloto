package grupotp013.proyectopilotoalvaro;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // implícita pequeña, la lógica de verdad la hacemos con WebDriverWait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.jetbrains.com/");

        // si hay banner de cookies, intentar cerrarlo
        closeCookiesBannerIfPresent();

        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Intenta cerrar el banner de cookies si existe.
     * Si no lo encuentra, no rompe el test.
     */
    private void closeCookiesBannerIfPresent() {
        try {
            // contenedor típico del banner de cookies
            WebElement banner = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector("div[class*='ch2-container']")
                    )
            );

            // dentro del banner, buscamos un botón (el primero suele ser "Allow all" / "Aceptar")
            WebElement button = banner.findElement(By.tagName("button"));
            button.click();

            // esperar a que el banner desaparezca
            wait.until(ExpectedConditions.invisibilityOf(banner));
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("No se ha mostrado el banner de cookies o no se ha podido cerrar.");
        }
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[data-test-id='search-input']"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        submitButton.click();

        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test-id='search-input']"));
        assertEquals("Selenium", searchPageField.getAttribute("value"));
    }
       // assertEquals("Selenium", searchPageField.getAttribute("value"));



    @Test
    public void toolsMenu() {
        // abrir el menú de Tools
        mainPage.toolsMenu.click();

        // esperamos a que el submenu sea visible
        WebElement menuPopup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[data-test='main-menu']")
                )
        );

        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
