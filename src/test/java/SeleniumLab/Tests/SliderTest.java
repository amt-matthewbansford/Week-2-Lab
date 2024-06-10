package Tests;

import Pages.HomePage;
import Pages.Setup;
import Pages.SliderPage;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.annotations.Test;

public class SliderTest extends Setup {
    @Test
    public void sliderTest() throws InterruptedException, MoveTargetOutOfBoundsException {
        HomePage homePage = new HomePage(driver);
        SliderPage sliderPage = new SliderPage(driver);

        homePage.openHomePage();
        sliderPage.openSliderPage();
        sliderPage.setSliderByClick();
        sliderPage.setSliderByDragAndDrop();
        sliderPage.assertSlider();
    }
}
