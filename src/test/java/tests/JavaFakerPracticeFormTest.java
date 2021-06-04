package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        open("https://demoqa.com/automation-practice-form");
    }
    @Test
    void successfulPracticeForm() {

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        registationPage.typeFirstName(firstName);
        registationPage.typeLastName(lastName);
        registationPage.typeEmail(userEmail);
        registationPage.setGender();
        registationPage.typeNumber(userNumber);
        registationPage.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        registationPage.tybeSubject(userSubjects);
        registationPage.setHobbiesCheck();
        registationPage.setUploadPicture(picture);
        registationPage.setAreaCurrentAddress(currentAdress);
        registationPage.setCityAndState(state, city);
        registationPage.setSubButton();
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
    }
}
