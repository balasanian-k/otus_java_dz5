import components.DropDownComponent;
import components.HeaderComponentAuth;
import components.HeaderComponentUnauth;
import components.PersonalInfoForm;
import components.modal.LoginModal;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

public class MainTest {

    private WebDriver driver;
    private Logger logger = LogManager.getLogger(Logger.class);

    @BeforeAll
    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void otusTest() {

        MainPage mainPage = new MainPage(driver);
        HeaderComponentUnauth headerComponent = new HeaderComponentUnauth(driver);
        LoginModal loginModal = new LoginModal(driver);
        HeaderComponentAuth headerComponentAuth = new HeaderComponentAuth(driver);
        DropDownComponent dropDownComponent = new DropDownComponent(driver);
        PersonalInfoForm personalInfoForm = new PersonalInfoForm(driver);

        mainPage.open();
        logger.info("Открыли https://otus.ru");
        loginModal.modalShouldNotBeVisible();

        headerComponent.clickSignInButton();
        loginModal.modalShouldBeVisible();
        loginModal.loginUser();
        logger.info("Авторизовались на сайте");

        headerComponentAuth.moveToUserItem();
        dropDownComponent.clickUserItem();
        logger.info("Вошли в личный кабинет");

        personalInfoForm.fillPersonalInfo();
        logger.info("В разделе \"О себе\" заполнили все поля \"Личные данные\" и добавили не менее двух контактов и нажали сохранить");

        driver.manage().deleteAllCookies();
        mainPage.open();
        logger.info("Открыли https://otus.ru в \"чистом браузере\"");

        headerComponent.clickSignInButton();
        loginModal.loginUser();
        logger.info("Авторизовались на сайте");

        headerComponentAuth.moveToUserItem();
        dropDownComponent.clickUserItem();
        logger.info("Вошли в личный кабинет");

        personalInfoForm.checkPersonalInfo();
        logger.info("Проверили, что в разделе \"О себе\" отображаются указанные ранее данные");
    }
}
