package com.zerot.mongo.form_handler.model;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;
    @NonNull
    private String name; // ^(?!\s*$).+$

    @NonNull
    private String email; // ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$

    @NonNull
    private String licenceCode; // ^ZEROT-[A-Z]{3}-[0-9]{3}$
    @NonNull
    private String expirationDate; // ^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$

    public User() {}

    public User(String name, String email, String licenceCode, String expirationDate) {
        this.name = name;
        this.email = email;
        this.licenceCode = licenceCode;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}

