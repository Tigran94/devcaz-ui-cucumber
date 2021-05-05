package steps;

import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.Dashboard;
import page.Main;
import page.PlayersPage;
import utils.PropertyReader;

public class Steps extends DriverFactory {

    private Main main;
    private Dashboard dashboard;
    private PlayersPage playersPage;

    @Before
    public void init() {
        PropertyReader.load();
        start();
        final WebDriver driver = getDriver();
        main = new Main(driver);
        dashboard = new Dashboard(driver);
        playersPage = new PlayersPage(driver);
    }

    @After
    public void teardown() {
        finish();
    }

    @Given("I go to main page")
    public void iGoToMainPage() {
        main.load();
        main.isLoaded();
    }

    @And("I go to the players section")
    public void iGoToPlayersPage() {
        dashboard.chooseNavigationItemFromTheListByTitle("Users")
                .chooseUsersItemFromTheListByTitle("Players");
    }

    //TODO open the bug -> A user logging in only after submitting the verification code
    @And("I login as {string} with password {string}")
    public void iLoginAsWithPassword(final String login, final String password) {
        main.fillInLogin(login)
                .fillInPassword(password)
                .loginButtonClick();
    }

    @And("I redirect to the players section")
    public void iShouldRedirectToPlayersSection() {
        playersPage.load();
        playersPage.isLoaded();
    }

    @And("I sort the table by the username")
    public void iSortTheTableByTheUsername() {
        playersPage.sortByUsername();
    }

    @Then("I should redirected to the appropriate section")
    public void iShouldSuccessfullyRedirectedToThePlayersSection() {
        playersPage.isLoaded();
    }

    @Then("I have successfully logged in")
    public void iShouldSuccessfullyLoggedIn() {
        dashboard.isLoaded();
    }

    @Then("I should assert the table sorting by the username")
    public void iAssertTheTableByUsername() {
        Assert.assertTrue("The table isn't sorted correct", playersPage.isTableSortedByUsername());
    }
}
