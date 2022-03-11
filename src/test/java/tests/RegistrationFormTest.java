package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.RegistrationFormTestData.*;


public class RegistrationFormTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
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
                .setUploadFile(file)
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
                .checkResultInModal("Picture", file)
                .checkResultInModal("Address", userAddress)
                .checkResultInModal("State and City", userState + " " + userCity);
    }
}