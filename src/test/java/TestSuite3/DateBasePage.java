package TestSuite3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class DateBasePage {
    private static final String URL = "https://vaadin-database-example.demo.vaadin.com/";

    public void openPage() {
        open(URL);
    }

    public ElementsCollection getTableRows() {
        // Standard HTML table rows
        return $$("table tbody tr");
    }

    public ElementsCollection getGridRows() {
        // Vaadin grid visible rows
        return $$("vaadin-grid vaadin-grid-cell-content");
    }

    // Example: get cell text from a row
    public String getCellText(SelenideElement row, int cellIndex) {
        return row.$$("td").get(cellIndex).getText().trim();
    }
}
