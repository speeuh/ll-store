package com.ll.store.model.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseModel {

    private long id;
    private String userName;
    private String email;
    private String password;

    public UserResponseModel(long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
