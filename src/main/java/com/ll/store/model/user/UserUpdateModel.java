package com.ll.store.model.user;

import com.ll.store.service.dto.user.UserUpdateDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserUpdateModel {

    private String password;

    public UserUpdateDto convertUpdateModelToDto() {
        return new UserUpdateDto(password);
    }
}
