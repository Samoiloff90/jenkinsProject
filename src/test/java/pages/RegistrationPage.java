package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalWindow;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //components
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ModalWindow modalWindow = new ModalWindow();

    //locators
    final private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),

            emailUserInput =  $("#userEmail"),
            gender = $(".practice-form-wrapper #genterWrapper"),
            userNumberInput = $("#userNumber"),
            birthDateInput = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),
            hobbiesWrap = $(".practice-form-wrapper #hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitBtn = $("#submit");




    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userMail) {
        emailUserInput.setValue(userMail);
        return this;
    }

    public RegistrationPage setUserGender (String gender) {
        this.gender
                .$(byText(gender))
                .click();
        return this;
    }

    public RegistrationPage setUserPhone (String phone) {
        userNumberInput.setValue(phone);
        return this;
    }


    public RegistrationPage setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        calendarComponent.setBirthDate(day, month, year);
        return this;
    }


    public RegistrationPage setSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        this.hobbiesWrap
                .$(byText(hobbies))
                .click();
        return this;
    }

    public RegistrationPage setUploadFile(String file) {
        uploadFileInput.uploadFromClasspath(file);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.scrollTo().click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity (String city) {
        cityInput.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmitBtn () {
        submitBtn.click();
        return this;
    }

    public RegistrationPage checkResultInModal(String label, String value) {
        ModalWindow.checkTableRow(label, value);
        return this;
    }
}

