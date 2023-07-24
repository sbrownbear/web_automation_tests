package tests;

import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String firstName = "Sergey",
                lastName = "Konoplev",
                studentName = firstName + ' ' + lastName,
                userEmail = "sergeyKonoplev@gmail.com",
                gender = "Male",
                userNumber = "9875036934",
                fullDateOfBirth = "08 May,1996",
                dayOfBirth = "08",
                monthOfBirth = "May",
                yearOfBirth = "1996",
                subjects = "Maths",
                hobbies = "Sports",
                picture = "img/1.png",
                verifyPicture = "1.png",
                currentAddress = "Russia",
                state = "NCR",
                city = "Delhi",
                stateAndCity = state + ' ' + city;

        registrationPage.openPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(userEmail)
                        .setGender(gender)
                        .setUserNumber(userNumber)
                        .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                        .setSubject(subjects)
                        .setHobbies(hobbies)
                        .setUploadPic(picture)
                        .setCurrentAddress(currentAddress)
                        .setState(state)
                        .setCity(city)
                        .setSubmit();

        registrationPage.verifyResultsModalAppears()
                        .verifyResult("Student Name", studentName)
                        .verifyResult("Student Email", userEmail)
                        .verifyResult("Gender", gender)
                        .verifyResult("Mobile", userNumber)
                        .verifyResult("Date of Birth", fullDateOfBirth)
                        .verifyResult("Subjects", subjects)
                        .verifyResult("Hobbies", hobbies)
                        .verifyResult("Picture", verifyPicture)
                        .verifyResult("Address", currentAddress)
                        .verifyResult("State and City", stateAndCity);
    }
}
