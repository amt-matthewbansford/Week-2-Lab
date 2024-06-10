package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CalendarPage extends Setup{
    public CalendarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Calendars")
    private WebElement calendars;

    @FindBy(css = ".jp-contact-form-date")
    private WebElement calendarInput;

    @FindBy(css = "[itemprop] .pushbutton-wide")
    private WebElement submitButton;

    @FindBy(css = "#contact-form-success-header")
    private WebElement successMessage;

    @FindBy(css = ".field-value")
    private WebElement dateEntered;

    @FindBy(css = ".ui-datepicker-month")
    private WebElement dataMonth;

    @FindBy(css = ".ui-datepicker-year")
    private WebElement dataYear;

    @FindBy(css = "a[title='Next']")
    private WebElement nextButton;

    @FindBy(css = "a[title='Previous']")
    private WebElement previousButton;



    public void openCalendarPage() throws InterruptedException {
        scrollIntoView(calendars);
        sleep(3000);
        calendars.click();
    }

    public void enterDate(String date) {
        calendarInput.sendKeys(date);
        submitButton.click();
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(dateEntered.isDisplayed());
    }

    private int monthToNumber(String Month) {
        return switch (Month) {
            case "January" -> 1;
            case "February" -> 2;
            case "March" -> 3;
            case "April" -> 4;
            case "May" -> 5;
            case "June" -> 6;
            case "July" -> 7;
            case "August" -> 8;
            case "September" -> 9;
            case "October" -> 10;
            case "November" -> 11;
            case "December" -> 12;
            default -> throw new IllegalArgumentException("Invalid month: " + Month);
        };
    }

    public void selectMonthAndYear(String year, String month, String day) throws InterruptedException {
        calendarInput.click();
        int yearNumber = Integer.parseInt(year);

        while (true) {
            int currentYear = Integer.parseInt(dataYear.getText());
            int currentMonth = monthToNumber(dataMonth.getText());
            int monthEntered = monthToNumber(month);

            if (currentYear > yearNumber || (currentYear == yearNumber && currentMonth > monthEntered)) {
                previousButton.click();
                sleep(1000);  // Allow time for the calendar to update
            } else if (currentYear < yearNumber || currentMonth < monthEntered) {
                nextButton.click();
                sleep(1000);  // Allow time for the calendar to update
            } else {
                WebElement desiredDay = driver.findElement(By.linkText(day));
                if (desiredDay != null) {
                    desiredDay.click();
                    break;
                } else {
                    System.out.println("The day does not exist");
                }
            }
        }
    }

    public void assertSelectedDay() {
        submitButton.click();
        Assert.assertTrue(successMessage.isDisplayed());
        Assert.assertTrue(dateEntered.isDisplayed());
    }
}
