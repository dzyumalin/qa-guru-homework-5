package pages;

import com.codeborne.selenide.SelenideElement;
import components.DatePicker;
import components.SelectStateAndCity;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            emailInput = $("#userEmail"),
                            genderInput = $("#gender-radio-1").parent(),
                            mobileInput = $("#userNumber"),
                            uploadPicture = $("#uploadPicture"),
                            subjectsInput = $("#subjectsInput"),
                            hobbiesCheck = $("#hobbies-checkbox-1").parent(),
                            areaCurrentAddress = $("#currentAddress"),
                            subButton = $("#submit"),
                            tableInput = $(".table-responsive");

        public void typeFirstName(String value) {
            firstNameInput.val(value);
        }
        public void typeLastName(String value) {
            lastNameInput.val(value);
        }
        public void typeEmail(String value) {
            emailInput.val(value);
        }
        public void setDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
            new DatePicker().setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        }
        public void setGender() {
            genderInput.click();
        }
        public void typeNumber(String value) {
            mobileInput.val(value);
        }
        public void tybeSubject(String value) {
            subjectsInput.val(value).pressEnter();
        }
        public void setHobbiesCheck() {
            hobbiesCheck.click();
        }
        public void setUploadPicture(String picture) {
            uploadPicture.uploadFile(new File("src/test/resources/img/" + picture));
        }
        public void  setAreaCurrentAddress(String value) {
            areaCurrentAddress.val(value);
        }
        public void setCityAndState(String state, String city) {
            new SelectStateAndCity().setCityAndState(state, city);
        }
        public void setSubButton() {
            subButton.click();
        }
        public void checkTable(String firstName,
                               String lastName,
                               String userEmail,
                               String userGender,
                               String userNumber,
                               String userSubjects,
                               String userHobbies,
                               String monthOfBirth,
                               String yearOfBirth,
                               String dayOfBirth,
                               String currentAdress,
                               String state,
                               String city,
                               String picture) {
            tableInput.shouldHave(text("Student Name"), text(firstName + " " + lastName));
            tableInput.shouldHave(text("Student Email"), text(userEmail));
            tableInput.shouldHave(text("Gender"), text(userGender));
            tableInput.shouldHave(text("Mobile"), text(userNumber));
            tableInput.shouldHave(text("Date of Birth"), text("05" + " " + monthOfBirth + "," + yearOfBirth));
            tableInput.shouldHave(text("Subjects"), text(userSubjects));
            tableInput.shouldHave(text("Hobbies"), text(userHobbies));
            tableInput.shouldHave(text("Picture"), text(picture));
            tableInput.shouldHave(text("Address"), text(currentAdress));
            tableInput.shouldHave(text("State and City"), text(state + " " + city));
        }
}
