package tests;

import com.github.javafaker.Faker;

public class TestData {

    Faker faker = new Faker();

    public String firstNameData = faker.name().firstName(),
            lastNameData = faker.name().lastName(),
            studentNameData = firstNameData + ' ' + lastNameData,
            userEmailData = faker.internet().emailAddress(),
            genderData = faker.options().option("Male", "Female", "Other"),
            userNumberData = faker.number().numberBetween(1000000000l, 9999999999l) + "",
            dayOfBirthData = String.format("%02d", faker.number().numberBetween(1, 28)),
            monthOfBirthData = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            yearOfBirthData = faker.number().numberBetween(1900, 2022) + "",
            fullDateOfBirthData = dayOfBirthData + " " + monthOfBirthData + "," + yearOfBirthData,
            subjectsData = faker.options().option("Chemistry", "Computer Science", "Commerce", "Accounting",
                    "Economics", "Social Studies", "Civics", "English", "Arts", "History", "Maths", "Phisics", "Biology", "Hindi"),
            hobbiesData = faker.options().option("Sports", "Reading", "Music"),
            pictureData = "img/1.png",
            verifyPictureData = "1.png",
            currentAddressData = faker.address().streetAddress(),
            stateData = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            cityData = setCityData(stateData),
            stateAndCityData = stateData + ' ' + cityData;

    public String setCityData(String state1) {
        String city = new String();
        switch (state1) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
                break;
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
                break;
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
                break;
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
                break;
            default:
        }
        return city;
    }
}
