package com.example.signup;

public class member {

    String signName; //이름
    String gender; //성별
    String serviceId; //간병인,환자 서비스 체크
    String signmail; //이메일
    String signID; //아이디
    String signBirth; //년
    String signBirth2; //월
    String signBirth3; //일
    String signPW; //비밀번호
    String signPW2; //비밀번호 확인

    public member(){

    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSignmail() {
        return signmail;
    }

    public void setSignmail(String signmail) {
        this.signmail = signmail;
    }

    public String getSignID() {
        return signID;
    }

    public void setSignID(String signID) {
        this.signID = signID;
    }

    public String getSignBirth() {
        return signBirth;
    }

    public void setSignBirth(String signBirth) {
        this.signBirth = signBirth;
    }

    public String getSignBirth2() {
        return signBirth2;
    }

    public void setSignBirth2(String signBirth2) {
        this.signBirth2 = signBirth2;
    }

    public String getSignBirth3() {
        return signBirth3;
    }

    public void setSignBirth3(String signBirth3) {
        this.signBirth3 = signBirth3;
    }

    public String getSignPW() {
        return signPW;
    }

    public void setSignPW(String signPW) {
        this.signPW = signPW;
    }

    public String getSignPW2() {
        return signPW2;
    }

    public void setSignPW2(String signPw2) {
        this.signPW2 = signPW2;
    }

    public member(String gender,String serviceId,String signName ,String signmail, String signID,String signBirth, String signBirth2,String signBirth3,String signPW){
         this.gender = gender;
         this.serviceId = serviceId;
         this.signName=  signName;
         this.signmail = signmail;
         this.signID = signID;
         this.signBirth = signBirth;
         this.signBirth2 = signBirth2;
         this.signBirth3 = signBirth3;
         this.signPW = signPW;
    }
}
