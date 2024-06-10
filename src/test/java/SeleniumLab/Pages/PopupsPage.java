package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PopupsPage extends Setup {
    WebDriver driver;

    public PopupsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Popups")
    private WebElement popups;

    @FindBy(css = "button#alert")
    private WebElement alertPopup;

    @FindBy(css = "button#confirm")
    private WebElement confirmPopup;

    @FindBy(css = "button#prompt")
    private WebElement promptPopup;

    @FindBy(css = ".tooltip_1")
    private WebElement showTooltip;

    @FindBy(css = "#myTooltip")
    public WebElement tooltip;

    public void openPopupPage() {
        popups.click();
    }

    public void openAlertPopup() throws InterruptedException {
        alertPopup.click();
        sleep(3000);
    }

    public void openConfirmPopup() throws InterruptedException {
        confirmPopup.click();
        sleep(3000);
    }

    public void openPromptPopup() throws InterruptedException {
        promptPopup.click();
        sleep(3000);
    }

    public void openTooltipPopup() throws InterruptedException {
        showTooltip.click();
        sleep(3000);
    }

    public void assertTooltip() {
        tooltip.isDisplayed();
        Assert.assertEquals("Cool text", tooltip.getText());
    }



}
