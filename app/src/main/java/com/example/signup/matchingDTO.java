package com.example.signup;

public class matchingDTO {

    private String userID;
    private String userName;
    private String userGender;
    private String lovation_work;
    private String Ucareer;
    private String Ulicense;


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getLovation_work() {
        return lovation_work;
    }

    public void setLovation_work(String lovation_work) {
        this.lovation_work = lovation_work;
    }

    public String getUcareer() {
        return Ucareer;
    }

    public void setUcareer(String ucareer) {
        Ucareer = ucareer;
    }

    public String getUlicense() {
        return Ulicense;
    }

    public void setUlicense(String ulicense) {
        Ulicense = ulicense;
    }

    @Override
    public String toString() {
        return "matchingDTO{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", lovation_work='" + lovation_work + '\'' +
                ", Ucareer='" + Ucareer + '\'' +
                ", Ulicense='" + Ulicense + '\'' +
                '}';
    }
}
