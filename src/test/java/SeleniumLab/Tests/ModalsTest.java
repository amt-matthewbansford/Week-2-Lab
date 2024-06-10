package Tests;

import Pages.HomePage;
import Pages.ModalsPage;
import Pages.Setup;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ModalsTest extends Setup {
    @DataProvider
    private Object[][] modals() {
        return new Object[][] {
            { "Matthew","mkbans@gmail.com","This is my message"},
        };
    }

    @Test(dataProvider = "modals")
    public void modalsTest(String name,String email, String message) throws InterruptedException {
        HomePage home = new HomePage(driver);
        ModalsPage modalsPage = new ModalsPage(driver);

        home.openHomePage();
        modalsPage.openModalsPage();
        modalsPage.openSimpleModal();
        modalsPage.assertSimpleModal();
        modalsPage.openAndFillFormModal(name, email, message);
    }
}
