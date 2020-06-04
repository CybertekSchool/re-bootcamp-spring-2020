package com.cybertek.library.utilities.common;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class LibraryUserUtility {
    /**
     * take user type create map that contains student or librarian user form data
     * @param userGroup
     *
     * @return
     *          user map
     */
    public static Map<String, Object> createUser(int userGroup){
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String usernameEmail = faker.name().username();
        String companyUrl = faker.company().url().substring(4);
        String email = usernameEmail + "@"+companyUrl;
        String address = faker.address().fullAddress();
        Map<String, Object> user = new HashMap<>();
        user.put("full_name", fullName);
        user.put("email", email);
        user.put("password", faker.number().digits(5));
        user.put("user_group_id", userGroup);
        user.put("status", "active");
        user.put("start_date", "2020-05-05");
        user.put("end_date", "2021-05-05");
        user.put("address", address);
        return user;
    }

}
