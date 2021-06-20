package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

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

        open("https://demoqa.com/automation-practice-form");
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
