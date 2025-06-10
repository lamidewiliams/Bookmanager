package org.example.service;

import org.example.dto.Addrequest;
import org.example.dto.Removerequest;
import org.example.dto.UserRequest;
import org.example.dto.UserResponse;

public interface UserService {

    UserResponse createaccount(UserRequest userRequest);
    UserResponse addbooks(Addrequest addrequest);
    UserResponse removebook(Removerequest removerequest);
}
