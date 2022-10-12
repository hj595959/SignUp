package com.example.signup;

public class meminfo {

    String nameEditText; //이름
    String emailEditText; //이메일
    String birthDayEditText; //생년워일
    String phone; // 전화번호
    String addressEditText; //주소
    String rating; //등급
    String checkButton; //확인

    public meminfo(){


    }

    public String getNameEditText() {
        return nameEditText;
    }

    public void setNameEditText(String nameEditText) {
        this.nameEditText = nameEditText;
    }

    public String getEmailEditText() {
        return emailEditText;
    }

    public void setEmailEditText(String emailEditText) {
        this.emailEditText = emailEditText;
    }

    public String getBirthDayEditText() {
        return birthDayEditText;
    }

    public void setBirthDayEditText(String birthDayEditText) {
        this.birthDayEditText = birthDayEditText;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressEditText() {
        return addressEditText;
    }

    public void setAddressEditText(String addressEditText) {
        this.addressEditText = addressEditText;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCheckButton() {
        return checkButton;
    }

    public void setCheckButton(String checkButton) {
        this.checkButton = checkButton;
    }

    public meminfo(String nameEditText, String emailEditText, String birthDayEditText, String phone, String addressEditText, String rating, String checkButton) {
        this.nameEditText = nameEditText;
        this.emailEditText = emailEditText;
        this.birthDayEditText = birthDayEditText;
        this.phone = phone;
        this.addressEditText = addressEditText;
        this.rating = rating;
        this.checkButton = checkButton;
    }

    @Override
    public String toString() {
        return "meminfo{" +
                "nameEditText='" + nameEditText + '\'' +
                ", emailEditText='" + emailEditText + '\'' +
                ", birthDayEditText='" + birthDayEditText + '\'' +
                ", phone='" + phone + '\'' +
                ", addressEditText='" + addressEditText + '\'' +
                ", rating='" + rating + '\'' +
                ", checkButton='" + checkButton + '\'' +
                '}';
    }


}