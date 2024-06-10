package Tests;

import Pages.FileDownloadPage;
import Pages.HomePage;
import Pages.Setup;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class FileDownloadTest extends Setup {

    @DataProvider
    private Object[][] download(){
        return new Object[][] {
            {"automateNow"}
        };
    }

    @Test(dataProvider = "download")
    public void fileDownloadTest(String input) throws InterruptedException, IOException {
        HomePage home = new HomePage(driver);
        FileDownloadPage downloadPage = new FileDownloadPage(driver);

        home.openHomePage();
        downloadPage.openDownloadPage();
        downloadPage.clickDownloadButton1();
        downloadPage.assertDownload();

//        Second Download
        downloadPage.clickDownloadButton2();
        downloadPage.enterDownloadPassword(input);
        downloadPage.clickSubmit();
        downloadPage.assertDownload2();
    }
}
