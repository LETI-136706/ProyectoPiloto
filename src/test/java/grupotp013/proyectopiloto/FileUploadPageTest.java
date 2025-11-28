package grupotp013.proyectopiloto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUploadPageTest {

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
    public void fileUploadTest() {
        FileUploadPage page = new FileUploadPage(driver);
        page.goTo();

        // Ruta a un archivo real en tu equipo
        page.uploadFile("/home/alvaro/Escritorio/testfile.txt");

        assertEquals("File Uploaded!", page.getUploadedMessage());
    }
}
