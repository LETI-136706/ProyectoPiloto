// src/test/java/testsuite5/SamplerInteractionTest.java
package testsuite5;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class SamplerInteractionTest {

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    void opensSamplerAndChecksUrl() {
        SamplerInteractionPage page = new SamplerInteractionPage().open();
        String current = WebDriverRunner.url();
        Assertions.assertTrue(current.startsWith("https://demo.vaadin.com/sampler"),
                "La URL debería comenzar con el host del sampler");
    }
}
