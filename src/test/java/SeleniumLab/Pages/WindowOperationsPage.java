package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WindowOperationsPage extends Setup {
    public WindowOperationsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Window Operations")
    private WebElement winOperationsPage;

    @FindBy(css = "[onclick='newTab\\(\\)']")
    private WebElement newTab;

    @FindBy(xpath = "//ul[@id='menu-main']/li/a/span[@class='nav-menu-item-inside']")
    private WebElement blog;

    @FindBy(xpath = "/html//div[@id='layout']//div[@class='grid-wrapper']/div[9]/article//h2[@class='entry-title']/a[@href='https://automatenow.io/java-convert-int-to-char/']")
    private WebElement blogLink;

    @FindBy(css = "[onclick='newWindowSelf\\(\\)'] b")
    private WebElement repWindow;

    @FindBy(css = "[onclick='newWindow\\(\\)']")
    private WebElement newWindow;



    public void openWinOperationsPage() throws InterruptedException {
        scrollIntoView(winOperationsPage);
        sleep(3000);
        winOperationsPage.click();
    }

    public void openNewTab() {
        newTab.click();
        switchToNewTab();
    }

    public void openBlog() throws InterruptedException {
        blog.click();
        scrollIntoView(blogLink);
        sleep(3000);
        Assert.assertTrue(blogLink.isDisplayed());
        blogLink.click();
    }

    public void replaceWindow() {
        repWindow.click();
    }

    public void openNewWindow() throws InterruptedException {
        newWindow.click();
        switchToNewTab();
        driver.manage().window().maximize();
        sleep(5000);
    }
}
