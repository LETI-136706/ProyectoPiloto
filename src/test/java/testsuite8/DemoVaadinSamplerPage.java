package testsuite8;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://demo.vaadin.com/sampler
public class DemoVaadinSamplerPage {
    // Localiza el botón por su texto o clase
   // public SelenideElement demoButton = $("button.demo");

    public SelenideElement demoButton = $("html > body > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div:nth-of-type(1) > div:nth-of-type(1) > div > div > div:nth-of-type(1) > div:nth-of-type(1) > div > div:nth-of-type(2) > div:nth-of-type(2)");

    // Espera a que el botón esté visible y lo hace clic
    public void clickDemoButton() {
        // Espera explícita de Selenide
        demoButton.shouldBe(com.codeborne.selenide.Condition.visible);
        demoButton.click();
    }

}