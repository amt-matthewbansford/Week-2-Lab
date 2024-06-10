package Tests;

import Pages.CalendarPage;
import Pages.HomePage;
import Pages.Setup;
import Pages.TablesPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalendarTest extends Setup {
    @DataProvider
    private Object[][] data() {
        return new Object[][] {
            { "2021-01-15"},
        };
    }

    @DataProvider
    private Object[][] selectData() {
        return new Object[][] {
                { "2022", "January", "11"},
                { "2030", "March", "31"}
        };
    }

    @Test(dataProvider = "data")
    public void calendarTestByEnter(String date) throws InterruptedException{
        HomePage home = new HomePage(driver);
        CalendarPage calendar = new CalendarPage(driver);

        home.openHomePage();
        calendar.openCalendarPage();
        calendar.enterDate(date);
    }

    @Test(dataProvider = "selectData")
    public void calendarTestBySelect(String year, String month, String day) throws InterruptedException{
        HomePage home = new HomePage(driver);
        CalendarPage calendar = new CalendarPage(driver);

        home.openHomePage();
        calendar.openCalendarPage();
        calendar.selectMonthAndYear(year, month, day);
        calendar.assertSelectedDay();
    }
}
