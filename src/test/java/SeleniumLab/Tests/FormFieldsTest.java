package Tests;

import Pages.HomePage;
import Pages.FormFieldsPage;
import Pages.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormFieldsTest extends Setup {

    @DataProvider
    private Object[][] data() {
        return new Object[][] {
            { "Matthew Bansford", "mkbansford@gmail.com" , "This is a test message"},

        };
    }



    // Open Form Fields Page and perform Actions
    @Test (dataProvider = ("data"))
    public void openFormFieldsPage(String fullName, String email, String message) throws InterruptedException {
        //  Creating a new instance of FormFieldsPage
        HomePage openHomePage = new HomePage(driver);
        FormFieldsPage formFieldsPage = new FormFieldsPage(driver);

        //  Opening Home Page
        openHomePage.openHomePage();

        //  Performing Page actions
        formFieldsPage.clickButton();
        formFieldsPage.enterFullName(fullName);
        formFieldsPage.selectDrinks();
        formFieldsPage.selectColor();
        formFieldsPage.selectYes();
        formFieldsPage.getListTexts();
        formFieldsPage.enterEmail(email);
        formFieldsPage.enterMessage(message);
        formFieldsPage.clickSubmit();
        acceptAlert();
    }


}
