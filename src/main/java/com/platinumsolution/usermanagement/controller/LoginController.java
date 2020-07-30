package com.platinumsolution.usermanagement.controller;

import com.platinumsolution.usermanagement.dto.UserDTO;
import com.platinumsolution.usermanagement.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/login")
public class LoginController {
    @Autowired
    private UserLoginService userloginService;

    @PostMapping
    public boolean canAuthenticate(@RequestBody UserDTO userDTO) {
        return userloginService.canAuthenticate(userDTO.getUserEmail(), userDTO.getUserPassword());
    }
}
