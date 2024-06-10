package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Setup {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        this.driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void scrollIntoView(WebElement element) {
//      Declaring an instance of JavaScriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void enterAlertMessage(String message) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(message);
    }

    public void sleep(long time) throws InterruptedException {
        Thread.sleep(time);
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    public void setElementAttribute(String attributeName, String attributeValue, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, attributeName, attributeValue);
    }

    public void switchToNewTab() {
        String originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
