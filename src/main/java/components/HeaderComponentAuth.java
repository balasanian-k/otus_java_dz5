package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponentAuth extends AbsBaseComponent{

    public HeaderComponentAuth(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//section/div[./span[text()='Тест']]")
    private WebElement userItem;

    public void moveToUserItem() {
        moveToElement(userItem);
    }
}
