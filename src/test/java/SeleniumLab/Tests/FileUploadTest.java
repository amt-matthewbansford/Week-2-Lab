package Tests;

import Pages.FileUploadPage;
import Pages.HomePage;
import Pages.Setup;
import org.testng.annotations.Test;

public class FileUploadTest extends Setup {

    @Test
    public void fileUploadTest() throws InterruptedException{
        HomePage home = new HomePage(driver);
        FileUploadPage uploadPage = new FileUploadPage(driver);

        home.openHomePage();
        uploadPage.openFileUploadPage();
        uploadPage.uploadFile();
        uploadPage.clickUploadButton();
        uploadPage.assertUploadMessage();
    }
}
