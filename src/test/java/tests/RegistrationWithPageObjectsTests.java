package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {

        TestData data = new TestData();

        registrationPage.openPage()
                        .setFirstName(data.firstNameData)
                        .setLastName(data.lastNameData)
                        .setEmail(data.userEmailData)
                        .setGender(data.genderData)
                        .setUserNumber(data.userNumberData)
                        .setBirthDate(data.dayOfBirthData, data.monthOfBirthData, data.yearOfBirthData)
                        .setSubject(data.subjectsData)
                        .setHobbies(data.hobbiesData)
                        .setUploadPic(data.pictureData)
                        .setCurrentAddress(data.currentAddressData)
                        .setState(data.stateData)
                        .setCity(data.cityData)
                        .setSubmit();

        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", data.studentNameData)
                        .verifyResult("Student Email", data.userEmailData)
                        .verifyResult("Gender", data.genderData)
                        .verifyResult("Mobile", data.userNumberData)
                        .verifyResult("Date of Birth", data.fullDateOfBirthData)
                        .verifyResult("Subjects", data.subjectsData)
                        .verifyResult("Hobbies", data.hobbiesData)
                        .verifyResult("Picture", data.verifyPictureData)
                        .verifyResult("Address", data.currentAddressData)
                        .verifyResult("State and City", data.stateAndCityData);
    }
}
