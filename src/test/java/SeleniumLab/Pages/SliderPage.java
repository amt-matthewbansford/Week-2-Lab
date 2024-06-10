package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SliderPage extends Setup{
    public SliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(linkText = "Sliders")
    private WebElement sliderpage;

    @FindBy(css = "input#slideMe")
    private WebElement slider;

    @FindBy(css = "span#value")
    WebElement sliderValue;

    public void openSliderPage() throws InterruptedException {
        scrollIntoView(sliderpage);
        sleep(3000);
        sliderpage.click();
    }


    public void setSliderByClick() throws InterruptedException {
        if (slider != null) {
            int sliderWidth = slider.getSize().width;
            int slope = (100) / (sliderWidth);
            int moveAmount = (int) (slope * (sliderWidth * 0.5));

            Actions actions = new Actions(driver);

            actions.moveToElement(slider, moveAmount, 0).click().perform();
            sleep(3000);
        } else {
            System.out.println("Slider element is null.");
        }
    }

    public void setSliderByDragAndDrop() throws InterruptedException, MoveTargetOutOfBoundsException {
        if (slider != null) {
//            slope = (output_end - output_start) / (input_end - input_start)
//            output = output_start + slope * (input - input_start)
            int sliderWidth = slider.getSize().width;
            int slope = (100) / (sliderWidth);
            int moveToZero =  -683;
            int moveAmount = (int) (slope * (sliderWidth * 0.5));

            Actions actions = new Actions(driver);
//            Move to zero position first
            actions.clickAndHold(slider).moveByOffset(moveToZero, 0).release().perform();
            sleep(5000);
//            Drag to 50
            actions.clickAndHold(slider).moveByOffset(moveAmount, 0).release().perform();
        } else {
            System.out.println("Slider element is null.");
        }
    }




    public void assertSlider() {
        Assert.assertEquals(slider.getAttribute("value"), "50");
    }
}
