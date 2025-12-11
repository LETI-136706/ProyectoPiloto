// src/test/java/testsuite8/DemoVaadinSamplerPageTest.java
package testsuite8;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class DemoVaadinSamplerPageTest {

    @Test
    public void testDemoButtonClick() {
        // Abre la página
        open("https://demo.vaadin.com/sampler");
        DemoVaadinSamplerPage page = new DemoVaadinSamplerPage();

        // Espera a que el botón esté visible y lo hace clic
        page.clickDemoButton();

        // Aquí puedes agregar más verificaciones según el resultado esperado
        // Por ejemplo, verificar que aparece un mensaje o cambia el estado de la página
    }
}
