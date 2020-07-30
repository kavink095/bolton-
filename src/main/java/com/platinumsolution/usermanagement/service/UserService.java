package com.platinumsolution.usermanagement.service;

import com.platinumsolution.usermanagement.dto.UserDTO;

public interface UserService {
    public boolean regUser(UserDTO userDTO);
    public boolean activatAcc(int gnNumber);
}
