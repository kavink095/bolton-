package com.platinumsolution.usermanagement.controller;


import com.platinumsolution.usermanagement.dto.UserDTO;
import com.platinumsolution.usermanagement.entity.User;
import com.platinumsolution.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public boolean saveDoctor(@RequestBody UserDTO userDTO) {
        System.out.println("dto " + userDTO);
        return userService.regUser(userDTO);
    }

    @PutMapping("/gnNum/{id}")
    public boolean accAct(@PathVariable int id) {
        System.out.println("num controller:- " + id);
        return userService.activatAcc(id);
    }

}
