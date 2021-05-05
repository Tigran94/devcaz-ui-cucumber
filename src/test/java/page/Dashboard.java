package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.PropertyReader.getURL;

public class Dashboard extends BasePage {
    private final WebDriver driver;
    private final String ENDPOINT = "/configurator/dashboard/index";

    @FindBy(id = "node-breadcrumbs")
    private WebElement rootSection;
    @FindBy(css = "#nav > li")
    private List<WebElement> navigationItemsList;
    @FindBy(css = "#s-menu-users > li")
    private List<WebElement> usersItemsList;

    public Dashboard(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Dashboard chooseNavigationItemFromTheListByTitle(final String title) {
        clickItemByTitle(navigationItemsList, title);
        return this;
    }

    public Dashboard chooseUsersItemFromTheListByTitle(final String title) {
        clickItemByTitle(usersItemsList, title);
        return this;
    }

    @Override
    protected void load() {
        driver.get(getURL() + ENDPOINT);
    }

    @Override
    public void isLoaded() throws Error {
        isElementDisplayed(rootSection);
        Assert.assertEquals(driver.getCurrentUrl(), getURL() + ENDPOINT);
    }
}
