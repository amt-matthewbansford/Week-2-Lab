package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class IframesPage extends Setup{
    public IframesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Iframes")
    private WebElement iframes;

    @FindBy(css = "[itemprop] [width='100\\%']:nth-child(3)")
    private WebElement firstIframe;

    @FindBy(css = ".TVPromo__Title")
    private WebElement tvPromo;

    @FindBy(css = "[itemprop] [width='100\\%']:nth-child(6)")
    private WebElement secondIframe;

    @FindBy(css = "[class] [class='nav-item mr-4 mb-2 mb-lg-0']:nth-of-type(2) span")
    private WebElement secondIframeLink;

    @FindBy(css = "h2#bindings")
    private WebElement frame2Content;

    public void openIframesPage() throws InterruptedException{
        scrollIntoView(iframes);
        sleep(3000);
        iframes.click();
    }

    public void moveToIframe() {
        switchToFrame(firstIframe);
        scrollIntoView(tvPromo);
        Assert.assertTrue(tvPromo.isDisplayed());
        System.out.println(tvPromo.getText());
    }

    public void moveToSecondIframe() {
        switchToFrame(secondIframe);
        Assert.assertTrue(secondIframeLink.isDisplayed());
        secondIframeLink.click();
        scrollIntoView(frame2Content);
        Assert.assertTrue(frame2Content.isDisplayed());
    }

}
