package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends AbsBasePage {

    private By signInButton = By.xpath("//button[text()='Войти']");

    public MainPage(WebDriver driver) {
        super(driver, "/");
    }
}
