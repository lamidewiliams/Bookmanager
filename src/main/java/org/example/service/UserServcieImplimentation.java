package org.example.service;
import jakarta.transaction.Transactional;
import org.example.dto.*;
import org.example.repository.UserRepo;
import org.example.entity.Users;
import org.example.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServcieImplimentation implements  UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public UserResponse createaccount(UserRequest userRequest) {

        if (userRepo.existsByUniqueId(userRequest.getUniqueid())) {
            return UserResponse.builder()
                    .responseCode(UserUtil.AccountExistCode)
                    .responseMessage(UserUtil.AccountExistmessage)
                    .userInfo(null)
                    .build();

        }

        Users newuser = Users.builder()
                .uniqueId(UserUtil.FormulateuniquId())
                .firstname(userRequest.getFirstname())
                .lastName(userRequest.getLastName())
                .Email(userRequest.getEmail())
                .Username(userRequest.getUsername())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .secreteQuestion(userRequest.getSecreteQuestion())
                .phoneNumber(userRequest.getPhoneNumber())
                .status("ACTIVE")
                .password(userRequest.getPassword())
                .booksList(userRequest.getBooksList())
                .build();

        Users savedUser = userRepo.save(newuser);

        return UserResponse.builder()
                .responseCode(UserUtil.ProfileCreatedCode)
                .responseMessage(UserUtil.ProfileCreatedMessage)
                .userInfo(UserInfo.builder()
                        .UserName(savedUser.getUsername())
                        .UserStatus(savedUser.getStatus())
                        .build())
                .build();

    }

    @Transactional
    @Override
    public UserResponse addbooks(Addrequest addrequest) {
        boolean ifAccountExists = userRepo.existsByUniqueId(addrequest.getUniqueId());
        if (!ifAccountExists){
            return UserResponse.builder()
                    .responseCode(UserUtil.AccountNotExistCode)
                    .responseMessage(UserUtil.AccountNotExistmessage)
                    .userInfo(null)
                    .build();
        }

        Users useradd = userRepo.findByUniqueId(addrequest.getUniqueId());

        if (!useradd.getPassword().equals(addrequest.getPassword())) {
            return UserResponse.builder()
                    .responseCode(UserUtil.WrongPasswordcode)
                    .responseMessage(UserUtil.Wrongpasswordmessage)
                    .userInfo(null)
                    .build();
        }

        List<String> books = useradd.getBooksList();
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(addrequest.getBook());

        useradd.setBooksList(books);
        userRepo.save(useradd);

        return UserResponse.builder()
                .responseCode(UserUtil.BookAddedCode)
                .responseMessage(UserUtil.BookAddedMessage)
                .userInfo(UserInfo.builder()
                        .UserName(useradd.getUsername())
                        .UserStatus(useradd.getStatus())
                        .build())
                .build();
    }

    @Transactional
    @Override
    public UserResponse removebook(Removerequest removerequest) {
        boolean ifAccountExists = userRepo.existsByUniqueId(removerequest.getUniqueId());
        if (!ifAccountExists){
            return UserResponse.builder()
                    .responseCode(UserUtil.AccountNotExistCode)
                    .responseMessage(UserUtil.AccountNotExistmessage)
                    .userInfo(null)
                    .build();
        }

        Users useradd = userRepo.findByUniqueId(removerequest.getUniqueId());

        if (!useradd.getPassword().equals(removerequest.getPassword())) {
            return UserResponse.builder()
                    .responseCode(UserUtil.WrongPasswordcode)
                    .responseMessage(UserUtil.Wrongpasswordmessage)
                    .userInfo(null)
                    .build();
        }

        List<String> books = useradd.getBooksList();
        if (books == null) {
            books = new ArrayList<>();
        }
        books.remove(removerequest.getBook());

        useradd.setBooksList(books);
        userRepo.save(useradd);

        return UserResponse.builder()
                .responseCode(UserUtil.BookAddedCode)
                .responseMessage(UserUtil.BookAddedMessage)
                .userInfo(UserInfo.builder()
                        .UserName(useradd.getUsername())
                        .UserStatus(useradd.getStatus())
                        .build())
                .build();
    }
}









