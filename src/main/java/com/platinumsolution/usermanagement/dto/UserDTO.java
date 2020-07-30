package com.platinumsolution.usermanagement.dto;

public class UserDTO {

    private int userid;
    private String userMobile;
    private String userEmail;
    private String userPassword;
    private int activeStatus;
    private int gnNumber;

    public UserDTO() {
    }

    public UserDTO(String userMobile, String userEmail, String userPassword, int activeStatus, int gnNumber) {
        this.userMobile = userMobile;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.activeStatus = activeStatus;
        this.gnNumber = gnNumber;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getGnNumber() {
        return gnNumber;
    }

    public void setGnNumber(int gnNumber) {
        this.gnNumber = gnNumber;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userid=" + userid +
                ", userMobile='" + userMobile + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", activeStatus=" + activeStatus +
                ", gnNumber=" + gnNumber +
                '}';
    }
}
