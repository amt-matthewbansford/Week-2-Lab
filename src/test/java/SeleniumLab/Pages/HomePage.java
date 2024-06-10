package Pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends Setup {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void openHomePage() {
//      Open Practice Automation Page
        driver.get("https://practice-automation.com/");
    }


}
