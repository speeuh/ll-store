package com.ll.store.service.dto.user;

import com.ll.store.repository.entity.user.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {

    private String userName;
    private String email;
    private String password;

    public UserRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User convertRequestDtoToEntity(){
        return new User(userName, email, password);
    }

}
