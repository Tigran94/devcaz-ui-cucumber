package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.PropertyReader.getURL;
import static utils.Utils.isSorted;

public class PlayersPage extends BasePage {
    private final String ENDPOINT = "/user/player/admin";
    private final WebDriver webDriver;

    @FindBy(id = "payment-system-transaction-grid")
    private WebElement grid;
    @FindBy(css = "#payment-system-transaction-grid_c1 > a")
    private WebElement usernameColumnTitle;
    @FindBy(css = "tbody tr td:nth-child(2)")
    private List<WebElement> usernameColumnItems;

    public PlayersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    public PlayersPage sortByUsername() {
        click(usernameColumnTitle);
        return this;
    }

    public boolean isTableSortedByUsername() {
        waitForJQueryToLoad();
        return isSorted(usernameColumnItems);
    }

    @Override
    public void load() {
        webDriver.get(getURL() + ENDPOINT);
    }

    @Override
    public void isLoaded() throws Error {
        isElementDisplayed(grid);
        Assert.assertEquals(webDriver.getCurrentUrl(), getURL() + ENDPOINT);
    }
}
