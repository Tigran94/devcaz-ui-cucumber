package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public abstract class BasePage extends LoadableComponent {
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
    }

    public void waitVisibility(final WebElement elementBy) {
        wait.until(ExpectedConditions.visibilityOf(elementBy));
    }

    public void waitVisibility(final List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    //Click Method by element located By
    public void click(final WebElement elementBy) {
        waitVisibility(elementBy);
        elementBy.click();
    }

    public void clickItemByTitle(final List<WebElement> elements, final String title) {
        waitVisibility(elements);
        for (WebElement element : elements) {
            if (element.getText().equals(title)) {
                element.click();
                break;
            }
        }
    }

    //Is Element located By  Displayed
    public void isElementDisplayed(final WebElement elementBy) {
        waitVisibility(elementBy);
        assertTrue(elementBy.isDisplayed());
    }


    //Write Text in field located By
    public void writeText(final WebElement elementBy, final String text) {
        waitVisibility(elementBy);
        elementBy.clear();
        elementBy.sendKeys(text);
    }

    public void waitForJQueryToLoad() {
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
        wait.until(jQueryLoad);
    }
}