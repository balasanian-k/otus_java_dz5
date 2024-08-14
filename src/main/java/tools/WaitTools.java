package tools;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTools {
    private WebDriver driver;

    public WaitTools(WebDriver driver) {
        this.driver = driver;
    }

    public boolean waitForCondition(ExpectedCondition condition) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(condition);
            return true;
        } catch (TimeoutException ignore) {
            return false;
        }
    }

    public void waitForVisibleElement(WebElement webElement) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.visibilityOf(webElement)));
    }

    public void waitForNotVisibleElement(WebElement webElement) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.invisibilityOf(webElement)));
    }

    public void waitForAttributeNotContains(WebElement locator, String attribute, String valueAttribute) {
        Assertions.assertTrue(waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(locator, attribute, valueAttribute))));
    }
}
