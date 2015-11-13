package com.walter.testing;

/**
 * Created by Walter on 11/12/2015.
 */
public class Student {
    private String names,email,age;

    public Student(String names, String email, String age) {
        this.names = names;
        this.email = email;
        this.age = age;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }
}
