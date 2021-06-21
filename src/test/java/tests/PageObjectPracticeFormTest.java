package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PageObjectPracticeFormTest extends TestBase {

    String firstName = "Dmitry",
            lastName = "Rejman",
            userEmail = "bgdt@gmail.com",
            userNumber = "9527776556",
            userGender = "Male",
            userSubjects = "Computer Science",
            userHobbies = "Sports",
            monthOfBirth = "July",
            yearOfBirth = "1995",
            dayOfBirth = "005",
            dayWeekOfBirth = "Wednesday",
            currentAdress = "Unter den Linden",
            state = "NCR",
            city = "Gurgaon",
            picture = "qa.jpg";

    RegistrationPage registationPage = new RegistrationPage();

    @Test
    void successfulPracticeForm() {
        step("Open registration form", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
        step("Checking the registration form header", () -> {

        });
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        step("Fill out the student registration form", () -> {
            registationPage.typeFirstName(firstName);
            registationPage.typeLastName(lastName);
            registationPage.typeEmail(userEmail);
            registationPage.setGender();
            registationPage.typeNumber(userNumber);
        });
        step("Set date", () -> {
            registationPage.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        });
        step("Set subject", () -> {
            registationPage.tybeSubject(userSubjects);
        });
        step("Set hobbies", () -> {
            registationPage.setHobbiesCheck();
        });
        step("Upload image", () -> {
            registationPage.setUploadPicture(picture);
        });
        step("Set address", () -> {
            registationPage.setAreaCurrentAddress(currentAdress);
            registationPage.setCityAndState(state, city);
        });
        step("Submit form", () -> {
            registationPage.setSubButton();
        });
        step("Checking the form", () -> {
            registationPage.checkTable(firstName,
                    lastName,
                    userEmail,
                    userGender,
                    userNumber,
                    userSubjects,
                    userHobbies,
                    monthOfBirth,
                    yearOfBirth,
                    dayOfBirth,
                    currentAdress,
                    state,
                    city,
                    picture);
        });
    }
}
