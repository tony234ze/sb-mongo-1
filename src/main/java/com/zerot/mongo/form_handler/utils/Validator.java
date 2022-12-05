package com.zerot.mongo.form_handler.utils;

import com.zerot.mongo.form_handler.model.User;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static boolean validateName(String name) {
        return name.matches("(?!\s*$).+");
    }

    public static boolean validateEmail(String email) {
        return email.matches("[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}");
    }

    public static boolean validateLicenceCode(String licenceCode) {
        return licenceCode.matches("ZEROT-[A-Z]{3}-[0-9]{3}");
    }

    public static boolean validateExpirationDate(String expirationDate) {
        return expirationDate.matches("(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}");
    }

    public static List<String> validateUser(User user) {
        List<String> invalidFields = new ArrayList<>();
        if (!validateName(user.getName()))
            invalidFields.add("name: must not be empty");
        if (!validateEmail(user.getEmail()))
            invalidFields.add("email: must be a valid email");
        if (!validateLicenceCode(user.getLicenceCode()))
            invalidFields.add("licenceCode: must be a valid licence code");
        if (!validateExpirationDate(user.getExpirationDate()))
            invalidFields.add("expirationDate: must be DD/MM/YYYY");
        return invalidFields;
    }
}
