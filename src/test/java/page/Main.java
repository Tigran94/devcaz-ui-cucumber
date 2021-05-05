package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utils.PropertyReader.getURL;

public class Main extends BasePage {
    private final WebDriver webDriver;
    private final String ENDPOINT = "/admin/login";

    @FindBy(id = "UserLogin_username")
    private WebElement username;
    @FindBy(id = "UserLogin_password")
    private WebElement password;
    @FindBy(name = "yt0")
    private WebElement submitButton;

    public Main(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public Main fillInLogin(final String login) {
        writeText(username, login);
        return this;
    }

    public Main fillInPassword(final String password) {
        writeText(this.password, password);
        return this;
    }

    public Main loginButtonClick() {
        click(submitButton);
        return this;
    }

    @Override
    public void load() {
        webDriver.get(getURL() + ENDPOINT);
    }

    @Override
    public void isLoaded() throws Error {
        Assert.assertEquals(webDriver.getCurrentUrl(), getURL() + ENDPOINT);
    }
}
