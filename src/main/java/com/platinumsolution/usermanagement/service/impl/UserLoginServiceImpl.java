package com.platinumsolution.usermanagement.service.impl;

import com.platinumsolution.usermanagement.entity.User;
import com.platinumsolution.usermanagement.repository.UserRepository;
import com.platinumsolution.usermanagement.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public boolean canAuthenticate(String useremail, String password) {
        List<User> all = userRepository.findAll();
        boolean res = false;
        for (User user : all) {
            if (user.getUserEmail().equals(useremail)) {
                if (user.getUserPassword().equals(password)) {
                    res = true;
                }
            }
        }
        return res;
    }
}
