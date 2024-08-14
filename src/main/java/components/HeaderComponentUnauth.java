package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponentUnauth extends AbsBaseComponent{

    public HeaderComponentUnauth(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Войти']")
    private WebElement signInButton;

    public void clickSignInButton() {
        signInButton.click();
    }
}
