package com.dto;

/**
 * Created by Panos on 25/7/16.
 */


public class UserSignUpRequestDto {
    private String username;


    private String password;
    private String rep_password;

    private String first_name;

    private String last_name;

    private String mail;
    private String phone_number;

    private Double latitude;
    private Double longitude;

    private String afm;



    private String address;


    private String gender;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRep_password() {
        return rep_password;
    }

    public void setRep_password(String rep_password) {
        this.rep_password = rep_password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getlongitude() {
        return longitude;
    }

    public void setlongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserSignUpRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rep_password='" + rep_password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mail='" + mail + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", afm='" + afm + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
