package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablesPage extends Setup{
    public TablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Tables")
    private WebElement tables;

    @FindBy(css = ".wp-block-table tbody")
    private WebElement tableBody1;

    @FindBy(xpath = "//table[@id='tablepress-1']/tbody")
    private WebElement tableBody2;

    @FindBy(css = "tr")
    private List<WebElement> tableRows;

    @FindBy(css = "th")
    private List<WebElement> tableHeaders;

    @FindBy(css = "td")
    private List<WebElement> tableCells;

    @FindBy(xpath = "//div[@id='tablepress-1_filter']//input[@type='search']")
    private WebElement searchField;




    public void openTablesPage() throws InterruptedException {
        scrollIntoView(tables);
        sleep(3000);
        tables.click();
    }

    public void getLaptopAndPrice() {
        List <WebElement> row2 = tableRows.get(2).findElements(By.cssSelector("td"));
        System.out.println("Item is " + row2.getFirst().getText() + " and its price is " + row2.getLast().getText());
    }

    public void getSearchResults(String country) {
        searchField.sendKeys(country);
        List <WebElement> table2 = tableBody2.findElements((By.cssSelector("tr")));
        for (WebElement row : table2) {
            List <WebElement> cells = row.findElements(By.cssSelector("td"));
            for (WebElement cell : cells) {
                if (cell.getText().contains(country) && cell.getText().equals("Indonesia")) {
                    System.out.println("Your country " + cells.get(1).getText() + " is ranked at number " + cells.get(0).getText() + " and has a population of " + cells.get(2).getText() + " million.");
                }
            }
        }

    }
}
