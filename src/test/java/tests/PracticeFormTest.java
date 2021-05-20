package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulPracticeForm() {
        String firstName = "Dmitry";
        String lastName = "Rejman";
        String userEmail = "bgdt@gmail.com";
        String userNumber = "9527776556";
        String currentAdress = "Unter den Linden";

        open("https://demoqa.com/automation-practice-form");

        // input Name
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);

        // input Email
        $("[id=userEmail]").setValue(userEmail);

        // select Gender
        $(byText("Male")).click();

        // input Mobile
        $("[id=userNumber]").setValue(userNumber);

        // select Date of Birth
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1995");
        $("[aria-label='Choose Wednesday, July 5th, 1995']").click();

        // input Subjects
        $("[id=subjectsInput]").setValue("Computer Science").pressEnter();

        // select Hobbies
        $(byText("Sports")).click();

        // select Picture
        $("[id=uploadPicture]").uploadFile(new File("src/img/qa.jpg"));

        // input Current Address
        $("[placeholder=\"Current Address\"]").setValue(currentAdress);

        // select state and city
        $("[id=state]").click();
        $(byText("NCR")).click();
        $("[id=city]").click();
        $(byText("Gurgaon")).click();
        $(byText("Submit")).click();

        // check Table
        $(".table-responsive").shouldHave(text(firstName), text(lastName),
                text(userEmail), text("Male"), text(userNumber), text("05 July,1995"),
                text("Computer Science"), text("Sports"), text("qa.jpg"),
                text("NCR"), text("Gurgaon"));
    }
}
