package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponentAuth extends AbsBaseComponent{

    public HeaderComponentAuth(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".header3__user-info-name")
    private WebElement userItem;

    public void moveToUserItem() {
        moveToElement(userItem);
    }
}
