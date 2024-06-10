package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FileUploadPage extends Setup {
    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String userHome = System.getProperty("user.home");
    String downloadPath = userHome + "\\Downloads\\test.pdf";


    @FindBy(linkText = "File Upload")
    private WebElement fileUpload;

    @FindBy(css = "input#file-upload")
    private WebElement chooseFile;

    @FindBy(css = "input#upload-btn")
    private WebElement uploadButton;

    @FindBy(css = ".wpcf7-response-output")
    private WebElement uploadMessage;
    public void openFileUploadPage() throws InterruptedException{
        scrollIntoView(fileUpload);
        sleep(3000);
        fileUpload.click();
    }

    public void uploadFile() {
        chooseFile.sendKeys(downloadPath);
    }

    public void clickUploadButton() throws InterruptedException {
        uploadButton.click();
        sleep(10000);
    }

    public void assertUploadMessage() {
        uploadMessage.isDisplayed();
        Assert.assertEquals("Thank you for your message. It has been sent.", uploadMessage.getText());
    }
}
