package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInfoForm extends AbsBaseComponent {

    public PersonalInfoForm(WebDriver driver) {
        super(driver);
    }

    // ФИ
    @FindBy(css = "[name='fname']")
    private WebElement firstNameField;

    @FindBy(css = "[name='lname']")
    private WebElement lastNameField;

    @FindBy(css = "[name='fname_latin']")
    private WebElement firstNameLatinField;

    @FindBy(css = "[name='lname_latin']")
    private WebElement lastNameLatinField;

    @FindBy(css = "[name='blog_name']")
    private WebElement blogNameField;

    // ДР
    @FindBy(css = "[name='date_of_birth']")
    private WebElement dateOfBirthField;

    //Страна
    @FindBy(xpath = "//input[contains(@name,'country')]")
    private WebElement сountryFieldWait;

    @FindBy(xpath = "//input[@name='country']/parent::label/parent::div")
    private WebElement сountryField;

    @FindBy(css = "button[title='Россия']")
    private WebElement countrySelection;

    //Город
    @FindBy(xpath = "//input[contains(@data-title,'Город') and not(@disabled='disabled')]")
    private WebElement cityFieldWait;

    @FindBy(xpath = "//input[@data-title='Город']/parent::label/parent::div")
    private WebElement cityField;

    @FindBy(css = "button[title='Пенза']")
    private WebElement citySelection;

    //Уровень языка
    @FindBy(xpath = "//input[@data-title='Уровень знания английского языка']/parent::label/parent::div")
    private WebElement languageField;

    @FindBy(css = "button[title='Выше среднего (Upper Intermediate)']")
    private WebElement languageSelection;

    //Готовность к переезду
    @FindBy(xpath = "//input[@id='id_ready_to_relocate_0']//following-sibling::span")
    private WebElement relocateRadioButton;

    @FindBy(css = "input[id='id_ready_to_relocate_0']")
    private WebElement relocateRadioButtonChecked;

    //Формат работы
    @FindBy(xpath = "//input[@title='Полный день']/parent::label/span")
    private WebElement workFormatCheckBox;

    @FindBy(css = "input[title='Полный день']")
    private WebElement workFormatCheckBoxChecked;

    //Способы связи
    @FindBy(xpath = "//input[@name='contact-0-service']/following-sibling::div")
    private WebElement сommunicationFieldOne;

    @FindBy(css = "button[data-value='skype']")
    private WebElement сommunicationSelectionOne;

    @FindBy(css = "input[id='id_contact-0-value']")
    private WebElement сontactOneField;

    @FindBy(xpath = "//input[@name='contact-1-service']/following-sibling::div")
    private WebElement сommunicationFieldTwo;

    @FindBy(xpath = "//input[@name='contact-1-service']/parent::label/following-sibling::div/descendant::button[@data-value='telegram']")
    private WebElement сommunicationSelectionTwo;

    @FindBy(css = "input[id='id_contact-1-value']")
    private WebElement contactTwoField;

    //Пол
    @FindBy(css = "select[id='id_gender']")
    private WebElement gendersField;

    @FindBy(css = "option[value='f']")
    private WebElement genderSelection;

    //Компания
    @FindBy(css = "input[id='id_company']")
    private WebElement companyField;

    //Должость
    @FindBy(css = "input[id='id_work']")
    private WebElement positionField;

    //Опыт разработки
    @FindBy(css = "select[id ='id_experience-0-experience']")
    private WebElement experienceField;

    @FindBy(xpath = "//option[text()='Java']")
    private WebElement experienceSelection;

    @FindBy(css = "select[id ='id_experience-0-level']")
    private WebElement experienceLevelField;

    @FindBy(xpath = "//option[text()='Более 10 лет']")
    private WebElement experienceLevelSelection;

    @FindBy(css = "button[name='continue']")
    private WebElement saveButton;

    private String firstNameValue = "Тест";
    private String lastNameValue = "Тестов";
    private String firstNameLatinValue = "Test";
    private String lastNameLatinValue = "Testov";
    private String blogNameValue = "Tecт";
    private String dateOfBirthValue = "12.04.1988";
    private String countryValue = "Россия";
    private String cityValue = "Пенза";
    private String languageValue = "Выше среднего (Upper Intermediate)";
    private String сontactOneValue = "@test_skype";
    private String contactTwoValue = "@test_telegram";
    private String companyValue = "ООО \"Test\"";
    private String positionValue = "Тестировщик";


    public void fillPersonalInfo() {
        fillOutForm(firstNameField, firstNameValue);
        fillOutForm(lastNameField, lastNameValue);
        fillOutForm(firstNameLatinField, firstNameLatinValue);
        fillOutForm(lastNameLatinField, lastNameLatinValue);
        fillOutForm(blogNameField, blogNameValue);
        fillOutForm(dateOfBirthField, dateOfBirthValue);
        waitTools.waitForVisibleElement(сountryField);
        сountryField.click();
        waitTools.waitForVisibleElement(countrySelection);
        countrySelection.click();
        waitTools.waitForAttributeNotContains(сountryFieldWait, "disabled", "disabled");
        waitTools.waitForAttributeNotContains(cityFieldWait, "disabled", "disabled");
        cityField.click();
        waitTools.waitForVisibleElement(citySelection);
        citySelection.click();
        languageField.click();
        languageSelection.click();
        relocateRadioButton.click();
        workFormatCheckBox.click();
        moveToElementAndClick(сommunicationFieldOne);
        waitTools.waitForVisibleElement(сommunicationSelectionOne);
        сommunicationSelectionOne.click();
        сontactOneField.click();
        fillOutForm(сontactOneField, сontactOneValue);
        moveToElementAndClick(сommunicationFieldTwo);
        waitTools.waitForVisibleElement(сommunicationSelectionTwo);
        сommunicationSelectionTwo.click();
        contactTwoField.click();
        fillOutForm(contactTwoField, contactTwoValue);
        gendersField.click();
        genderSelection.click();
        fillOutForm(companyField, companyValue);
        fillOutForm(positionField, positionValue);
        experienceField.click();
        experienceSelection.click();
        experienceLevelField.click();
        experienceLevelSelection.click();
        saveButton.click();
    }

    public void checkPersonalInfo() {
        checkAttribute(firstNameField, firstNameValue);
        checkAttribute(lastNameField, lastNameValue);
        checkAttribute(firstNameLatinField, firstNameLatinValue);
        checkAttribute(lastNameLatinField, lastNameLatinValue);
        checkAttribute(blogNameField, blogNameValue);
        checkAttribute(dateOfBirthField, dateOfBirthValue);
        checkText(сountryField, countryValue);
        checkText(cityField, cityValue);
        checkText(languageField, languageValue);
        checkAttributeChecked(relocateRadioButtonChecked);
        checkAttributeChecked(workFormatCheckBoxChecked);
        checkAttribute(сontactOneField, сontactOneValue);
        checkAttribute(contactTwoField, contactTwoValue);
        checkAttributeChecked(genderSelection);
        checkAttribute(companyField, companyValue);
        checkAttribute(positionField, positionValue);
        checkAttributeChecked(experienceSelection);
        checkAttributeChecked(experienceLevelSelection);
    }
}
