// src/test/java/testsuite5/SamplerInteractionPage.java
package testsuite5;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.Condition;

public class SamplerInteractionPage {

    private static final String BASE_URL = "https://demo.vaadin.com/sampler/";

    public SamplerInteractionPage open() {
        com.codeborne.selenide.Selenide.open(BASE_URL);
        return this;
    }

    public SamplerInteractionPage openComponent(String componentName) {
        $(byText(componentName)).shouldBe(Condition.visible).click();
        return this;
    }

    public String getHeaderText() {
        return $("h1").shouldBe(Condition.visible).getText();
    }
}
