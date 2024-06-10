package Tests;

import Pages.HomePage;
import Pages.Setup;
import Pages.WindowOperationsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowOperationsTest extends Setup {

    @Test(priority = 0)
    public void windowOperationsTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WindowOperationsPage window = new WindowOperationsPage(driver);

//      Handling New Tab
        homePage.openHomePage();
        window.openWinOperationsPage();
        window.openNewTab();
        window.openBlog();
        sleep(5000);
        switchToNewTab();

//      Handling Replace Tab
        window.replaceWindow();
        window.openBlog();
    }

        @Test(priority = 1)
        public void handleNewWindow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WindowOperationsPage window = new WindowOperationsPage(driver);
//      Handling New Window
        homePage.openHomePage();
        window.openWinOperationsPage();
        window.openNewWindow();
        window.openBlog();
    }
}
