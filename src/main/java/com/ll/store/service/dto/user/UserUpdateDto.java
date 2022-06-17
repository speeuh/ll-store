package com.ll.store.service.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateDto {

    private String password;

    public UserUpdateDto(String password) {
        this.password = password;
    }
}
