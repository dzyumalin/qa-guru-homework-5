package components;

import static com.codeborne.selenide.Selenide.$;

public class DatePicker {

    public void setDate(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
    }

}
