package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String uniqueid;
    private String firstname;
    private String lastName;
    private String Email;
    private String Username;
    private String gender;
    private String address;
    private String stateOfOrigin;
    private String secreteQuestion;
    private String phoneNumber;
    private String status;
    private String password;
    private List<String> booksList;
}
