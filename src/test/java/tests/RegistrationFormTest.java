package tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.RegistrationPage;
import static tests.RegistrationFormTestData.*;


@DisplayName("demoqa.com tests")
@Severity(SeverityLevel.CRITICAL)
public class RegistrationFormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @DisplayName("Заполнение формы регистрации")
    void successFillTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setUserGender(gender)
                .setUserPhone(userPhone)
                .setBirthDate(birthDateDay, birthDateMouth, birthDateYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
//                .setUploadFile(file)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmitBtn();

        //check:
        registrationPage
                .checkResultInModal("Student Name", firstName + " " + lastName)
                .checkResultInModal("Student Email", userEmail)
                .checkResultInModal("Gender", gender)
                .checkResultInModal("Mobile", userPhone)
                .checkResultInModal("Date of Birth", birthDate)
                .checkResultInModal("Subjects", subjects)
                .checkResultInModal("Hobbies", hobbies)
//                .checkResultInModal("Picture", file)
                .checkResultInModal("Address", userAddress)
                .checkResultInModal("State and City", userState + " " + userCity);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}