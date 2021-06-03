package tests;


import components.DatePicker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
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
        // input Name
        registationPage.typeFirstName(firstName);
        registationPage.typeLastName(lastName);

        // input Email
        registationPage.typeEmail(userEmail);

        // select Gender
        registationPage.setGender();

        // input Mobile
        registationPage.typeNumber(userNumber);

        // select Date of Birth
        registationPage.setDate(dayOfBirth, monthOfBirth, yearOfBirth);

        // input Subjects
        registationPage.tybeSubject(userSubjects);

        // select Hobbies
        registationPage.setHobbiesCheck();

        // select Picture
        registationPage.setUploadPicture(picture);

        // input Current Address
        registationPage.setAreaCurrentAddress(currentAdress);

        // select state and city
        registationPage.setCityAndState(state, city);
        registationPage.setSubButton();

        // check Table
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
