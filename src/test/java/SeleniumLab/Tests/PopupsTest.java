package Tests;

import Pages.HomePage;
import Pages.PopupsPage;
import Pages.Setup;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PopupsTest extends Setup {
    @DataProvider
    private Object[][] popups() {
        return new Object[][] {
            { "Matthew"},
        };
    }

    @Test (dataProvider = "popups")
    public void popupsTest(String message) throws InterruptedException {
        PopupsPage popups = new PopupsPage(driver);
        HomePage home = new HomePage(driver);

        home.openHomePage();
        popups.openPopupPage();
//        Testing alert popup
        popups.openAlertPopup();
//        Clicking OK button
        acceptAlert();

//        Testing confirm popup
        popups.openConfirmPopup();
//        Clicking Cancel button
        dismissAlert();

//        Testing prompt popup
        popups.openPromptPopup();
        enterAlertMessage(message);
        acceptAlert();

//        Testing Tooltip
        popups.openTooltipPopup();
        popups.assertTooltip();
    }
}
