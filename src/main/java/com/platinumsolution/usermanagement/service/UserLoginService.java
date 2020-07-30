package com.platinumsolution.usermanagement.service;

public interface UserLoginService {
    boolean canAuthenticate(String useremail, String password);
}
