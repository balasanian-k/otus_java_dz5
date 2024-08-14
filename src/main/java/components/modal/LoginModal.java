package components.modal;

import components.AbsBaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginModal extends AbsBaseComponent implements ILoginModal {

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#__PORTAL__ >div")
    private WebElement loginModal;

    @FindBy(css = "input[name='email']")
    private WebElement emailInputField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInputField;

    @FindBy(css = "#__PORTAL__ button")
    private WebElement signInButton;

    public void loginUser() {
        waitTools.waitForVisibleElement(emailInputField);
        driver.findElement(By.xpath("//div[./input[@name='email']]")).click();
        waitTools.waitForCondition(ExpectedConditions.stalenessOf(emailInputField));
        fillOutForm(emailInputField, System.getProperty("login"));
        driver.findElement(By.xpath("//div[./input[@type='password']]")).click();
        waitTools.waitForCondition(ExpectedConditions.stalenessOf(passwordInputField));
        fillOutForm(passwordInputField, System.getProperty("password"));
        signInButton.click();
    }

    @Override
    public void modalShouldNotBeVisible() {
        waitTools.waitForNotVisibleElement((loginModal));
    }

    @Override
    public void modalShouldBeVisible() {
        waitTools.waitForVisibleElement(loginModal);
    }
}
