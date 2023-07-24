package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationTest() {
        String firstName = "Sergey";
        String lastName = "Konoplev";
        String userEmail = "sergeyKonoplev@gmail.com";
        String gender = "Male";
        String userNumber = "9875036934";
        String fullDateOfBirth = "08 May,1996";
        String dayOfBirth = "08";
        String monthOfBirth = "May";
        String yearOfBirth = "1996";
        String subjects = "Maths";
        String hobbies = "Sports";
        String picture = "img/1.png";
        String verifyPicture = "1.png";
        String currentAddress = "Russia";
        String state = "NCR";
        String city = "Delhi";
        String stateAndCity = state + ' ' + city;

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(firstName), text(lastName), text(userEmail), text(gender),
                text(userNumber), text(fullDateOfBirth), text(subjects), text(hobbies),
                text(verifyPicture), text(currentAddress), text(stateAndCity));
    }
}