package com.kodeveloper.food.web.sample;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by Hyojin Bae on 2017/05/29.
 */
public class Customer {
    public ObjectId id;
    public String firstName;
    public String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ObjectId getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
