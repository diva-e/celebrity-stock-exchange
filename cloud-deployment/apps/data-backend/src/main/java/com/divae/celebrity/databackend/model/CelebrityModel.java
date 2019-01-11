package com.divae.celebrity.databackend.model;

import java.time.LocalDate;

public class CelebrityModel {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private LocalDate dayOfDeath;
    private String job;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



    @Override
    public String toString() {
        return "CelebrityModel{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", dayOfDeath=" + dayOfDeath +
                ", job='" + job + '\'' +
                '}';
    }
}
