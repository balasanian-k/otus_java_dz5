package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownComponent extends AbsBaseComponent {

    public DropDownComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href*=personal]")
    private WebElement userItemProfile;

    public void clickUserItem() {
        userItemProfile.click();
    }
}
