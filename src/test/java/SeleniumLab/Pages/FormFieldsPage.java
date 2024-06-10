package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormFieldsPage extends Setup {
    public FormFieldsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


//  Declaring element variables
    @FindBy(linkText = "Form Fields")
    private WebElement ffbutton;

    @FindBy(name = "name")
    private WebElement name;

    @FindBy(css = "input[value='Water']")
    private WebElement water;

    @FindBy(css = "input[value='Wine']")
    private WebElement wine;

    @FindBy(css = "input[value='Blue']")
    private WebElement blueColor;

    @FindBy(css = "option[value='yes']")
    private WebElement yes;

    @FindBy(tagName = "li")
    private List<WebElement> list;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "message")
    private WebElement message;

    @FindBy(css = "[data-cy='submit-btn']")
    private WebElement submit;



//  Method Declaration
    public void clickButton(){
         ffbutton.click();
    }

    public void enterFullName(String fname) {
        name.sendKeys(fname);
    }

    public void selectDrinks() {
        if(!water.isSelected() && !wine.isSelected()){
            water.click();
            wine.click();
        }

    }

    public void selectColor() throws InterruptedException {
        scrollIntoView(blueColor);
        sleep(3000);
        if(!blueColor.isSelected()){
            blueColor.click();
        }
    }

    public void selectYes() {
        if(!yes.isSelected()){
            yes.click();
        }
    }

    public void getListTexts() {
        for(WebElement listItem : list){
            System.out.println(listItem.getText());
        }
    }

    public void enterEmail(String email) {
        this.email.sendKeys(email);
    }

    public void enterMessage(String message) {
        this.message.sendKeys(message);
    }

    public void clickSubmit() {
        submit.click();
    }




}
