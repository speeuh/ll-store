package com.ll.store.service.dto.user;

import com.ll.store.model.user.UserResponseModel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {

    private long id;
    private String userName;
    private String email;
    private String password;

    public UserResponseDto(long id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public UserResponseModel convertResponseDtoToModel() {
        return new UserResponseModel(id, userName, email, password);
    }

}
