package Factories;

import Enums.Gender;
import Models.User;

public class UserFactory {
    public static User createUser(String name, int id, String genderString, int age) {
        Gender gender = genderString.startsWith("M") ? Gender.MALE : Gender.FEMALE;
        return new User(name, id, gender, age);
    }
}
