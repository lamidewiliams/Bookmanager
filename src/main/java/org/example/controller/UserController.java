package org.example.controller;

import org.example.dto.*;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserResponse createAccount(@RequestBody UserRequest userRequest) {
        return userService.createaccount(userRequest);
    }

    @PostMapping("/add-book")
    public UserResponse addBooks(@RequestBody Addrequest addrequest) {
        return userService.addbooks(addrequest);
    }

    @PostMapping("/remove-book")
    public UserResponse removeBook(@RequestBody Removerequest removerequest) {
        return userService.removebook(removerequest);
    }
}
