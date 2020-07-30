package com.platinumsolution.usermanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", nullable = false, length = 12)
    private int userid;
    @Column(name = "userMobile", nullable = false, length = 10)
    private String userMobile;
    @Column(name = "userEmail", nullable = false, length = 100)
    private String userEmail;
    @Column(name = "userPassword", nullable = false, length = 100)
    private String userPassword;
    @Column(name = "activeStatus", nullable = false, length = 1)
    private int activeStatus;
    @Column(name = "gnNumber", nullable = false)
    private int gnNumber;

    public User() {
    }

    public User(String userMobile, String userEmail, String userPassword, int activeStatus, int gnNumber) {
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
        return "User{" +
                "userid=" + userid +
                ", userMobile='" + userMobile + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", activeStatus=" + activeStatus +
                ", gnNumber=" + gnNumber +
                '}';
    }
}
