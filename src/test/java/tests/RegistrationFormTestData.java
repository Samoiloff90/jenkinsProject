package tests;

import static utils.RandomUtils.*;

public class RegistrationFormTestData {


    public static String firstName = getRandomString(10);
    public static String lastName = getRandomString(10);
    public static String userEmail = getRandomEmail();
    public static String gender = "Male";
    public static String userPhone = "1234567890";
    public static String birthDateDay = "1";
    public static String birthDateMouth = "August";
    public static String birthDateYear = "1990";
    public static String birthDate = birthDateDay + " " + birthDateMouth + "," + birthDateYear;
    public static String subjects = "Computer Science";
    public static String hobbies = "Sports";
    public static String file = "unix.png";
    public static String userAddress = "Puskina, dom 1";
    public static String userState = "NCR";
    public static String userCity = "Delhi";
}
