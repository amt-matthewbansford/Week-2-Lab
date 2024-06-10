package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ModalsPage extends Setup{
    public ModalsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Modals")
    private WebElement modals;

    @FindBy(css = "#simpleModal")
    private WebElement simpleModal;

    @FindBy(css = "#formModal")
    private WebElement formModal;

    @FindBy(xpath = "//body[@id='body']/div[5]/div")
    private WebElement modal;

    @FindBy(xpath = "//body[@id='body']/div[5]//p[.='Hi, I’m a simple modal.']")
    private WebElement simpleModalText;

    @FindBy(xpath = "//body[@id='body']/div[5]//button[@type='button']")
    private WebElement closeButton;

    @FindBy(css = ".name.grunion-field")
    private WebElement nameField;

    @FindBy(css = ".email.grunion-field")
    private WebElement emailField;

    @FindBy(css = ".textarea.grunion-field")
    private WebElement messageField;

    @FindBy(css = ".pushbutton-wide")
    private WebElement submitButton;

    public void openModalsPage() throws InterruptedException {
        scrollIntoView(modals);
        sleep(2000);
        modals.click();
    }

    public void openSimpleModal() throws InterruptedException {
        scrollIntoView(simpleModal);
        simpleModal.click();
        sleep(3000);
    }

    public void assertSimpleModal() throws InterruptedException {
        modal.isDisplayed();
        Assert.assertTrue(simpleModalText.isDisplayed());
        closeButton.click();
        sleep(5000);
    }

    public void openAndFillFormModal(String name, String email, String message){
        formModal.click();
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        messageField.sendKeys(message);
        submitButton.click();
    }
}
