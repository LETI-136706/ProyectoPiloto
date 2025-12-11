package TestSuite3;

import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DateBaseTest {

    @Test
    public void testMovieRowsPresent() {
        DateBasePage page = new DateBasePage();
        page.openPage();

        ElementsCollection tableRows = page.getTableRows();
        ElementsCollection gridRows = page.getGridRows();

        if (!tableRows.isEmpty()) {
            tableRows.first().shouldBe(visible);
        } else if (!gridRows.isEmpty()) {
            gridRows.first().shouldBe(visible);
        } else {
            fail("No table or grid rows found on the page");
        }

        ElementsCollection rows = !tableRows.isEmpty() ? tableRows : gridRows;
        assertTrue(rows.size() > 0, "There should be at least one movie row present");
    }
}
