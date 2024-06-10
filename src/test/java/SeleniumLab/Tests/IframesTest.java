package Tests;

import Pages.HomePage;
import Pages.IframesPage;
import Pages.Setup;
import org.testng.annotations.Test;

public class IframesTest extends Setup {

    @Test
    public void iframesTest() throws InterruptedException{
        HomePage home = new HomePage(driver);
        IframesPage iframes = new IframesPage(driver);

        home.openHomePage();
        iframes.openIframesPage();
        iframes.moveToIframe();
        switchToDefault();
        iframes.moveToSecondIframe();
    }
}
