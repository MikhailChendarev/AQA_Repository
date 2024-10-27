package org.example.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private String password;

    private String roles;

    private Boolean isCV;

    private String searchOpening;

    private String searchStatus;

}
