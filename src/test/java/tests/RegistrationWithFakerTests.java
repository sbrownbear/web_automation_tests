package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithFakerTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationTest() {

        TestData data = new TestData();

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(data.firstNameData);
        $("#lastName").setValue(data.lastNameData);
        $("#userEmail").setValue(data.userEmailData);
        $("#genterWrapper").$(byText(data.genderData)).click();
        $("#userNumber").setValue(data.userNumberData);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(data.monthOfBirthData);
        $(".react-datepicker__year-select").selectOption(data.yearOfBirthData);
        $(".react-datepicker__day--0" + data.dayOfBirthData + ":not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(data.subjectsData).pressEnter();
        $("#hobbiesWrapper").$(byText(data.hobbiesData)).click();
        $("#uploadPicture").uploadFromClasspath(data.pictureData);
        $("#currentAddress").setValue(data.currentAddressData);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(data.stateData)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(data.cityData)).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text(data.firstNameData), text(data.lastNameData), text(data.userEmailData), text(data.genderData),
                text(data.userNumberData), text(data.fullDateOfBirthData), text(data.subjectsData), text(data.hobbiesData),
                text(data.verifyPictureData), text(data.currentAddressData), text(data.stateAndCityData));
    }
}