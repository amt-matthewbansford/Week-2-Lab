package Tests;

import Pages.HomePage;
import Pages.Setup;
import Pages.TablesPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TablesTest extends Setup {
    @DataProvider
    private Object[][] tableData() {
        return new Object[][] {
            { "In"},
        };
    }

    @Test (dataProvider = "tableData")
    public void tablesTest(String input) throws InterruptedException {
        HomePage home = new HomePage(driver);
        TablesPage tables = new TablesPage(driver);

        home.openHomePage();
        tables.openTablesPage();
        tables.getLaptopAndPrice();
        tables.getSearchResults(input);
    }
}
