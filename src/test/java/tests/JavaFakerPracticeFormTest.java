package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class JavaFakerPracticeFormTest extends TestBase{

    Faker faker = new Faker(Locale.UK);

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10),
            userGender = "Male",
            userSubjects = "Computer Science",
            userHobbies = "Sports",
            monthOfBirth = "July",
            yearOfBirth = "1995",
            dayOfBirth = "005",
            dayWeekOfBirth = "Wednesday",
            currentAdress = faker.address().fullAddress(),
            state = "NCR",
            city = "Gurgaon",
            picture = "qa.jpg";

    RegistrationPage registationPage = new RegistrationPage();
    @Test
    void openPage() {
        step("Checking the registration form header", () -> {
            open("https://demoqa.com/automation-practice-form");
        });
    }
    @Test
    void successfulPracticeForm() {

        step("Checking the registration form header", () -> {
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        });

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
